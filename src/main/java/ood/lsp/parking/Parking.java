package ood.lsp.parking;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking implements IParking {
    private final static int SIZE_PASSENGER = 1;
    private final static int SIZE_CARGO = 2;
    private Place pickTypeParking;
    Map<Integer, Place> placeMap;

    public Parking(int sizeCargo, int sizePassenger) {
        placeMap = Map.of(
                SIZE_PASSENGER, new Place(sizePassenger),
                SIZE_CARGO, new Place(sizeCargo)
        );
    }

    private Place getPickTypeParking() {
        return pickTypeParking;
    }

    private void setPickTypeParking(int size) {
        this.pickTypeParking = placeMap.get(size);
    }

    @Override
    public boolean takePlace(IVehicle car) {
        int sizeParking = car.sizeParkingPlace();
        setPickTypeParking(sizeParking);
        OptionalInt optional = availablePlaceOnParking();
        if (optional.isPresent()) {
            getPickTypeParking().addCar(optional.getAsInt(), car);
        } else {
            if (sizeParking > 1) {
                setPickTypeParking(1);
                Optional<String> isExists = pairAvailableParkingPlace();
                if (isExists.isEmpty()) {
                    return false;
                }
                takePairPlaceForCargoCarInPassengerParking(isExists.get(), car);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<String> pairAvailableParkingPlace() {
        return IntStream.range(0, getPickTypeParking().size())
                .filter(index -> index < getPickTypeParking().size() - 1)
                .filter(index -> getPickTypeParking().getStatus(index) && getPickTypeParking().getStatus(index + 1))
                .mapToObj(index -> "[" + index + ", " + (index + 1) + "]")
                .findFirst();
    }

    private void takePairPlaceForCargoCarInPassengerParking(String pairPlace, IVehicle car) {
        Scanner scanner = new Scanner(pairPlace.replaceAll("[^\\d ]", ""));
        while (scanner.hasNextInt()) {
            getPickTypeParking().addCar(scanner.nextInt(), car);
        }
        scanner.close();
    }

    @Override
    public Map<Integer, List<Integer>> allAvailablePlace() {
        return getAllPlaceByPredicate(index -> getPickTypeParking().getStatus(index));
    }

    @Override
    public Map<Integer, List<Integer>> allOccupiedPlace() {
        return getAllPlaceByPredicate(index -> !getPickTypeParking().getStatus(index));
    }

    private Map<Integer, List<Integer>> getAllPlaceByPredicate(Predicate<Integer> predicate) {
        Map<Integer, List<Integer>> info = new HashMap<>();
        for (Integer parking : placeMap.keySet()) {
            setPickTypeParking(parking);
            List<Integer> value = new ArrayList<>();
            for (int i = 0; i < getPickTypeParking().size(); i++) {
                if (predicate.test(i)) {
                    value.add(i);
                    info.put(parking, value);
                }
            }
        }
        return info;
    }

    private OptionalInt availablePlaceOnParking() {
        return getPlaceByPredicate(getPickTypeParking()::getStatus);
    }

    private OptionalInt getPlaceByPredicate(Predicate<Integer> predicate) {
        return IntStream.range(0, getPickTypeParking().size())
                .filter(predicate::test)
                .findFirst();
    }
}
