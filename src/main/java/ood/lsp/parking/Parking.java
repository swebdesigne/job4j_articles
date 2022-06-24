package ood.lsp.parking;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking implements IParking {
    private final Place passengerCarsPlaces;
    private final Place cargoCarsPlaces;

    public Parking(int sizePassenger, int sizeCargo) {
        passengerCarsPlaces = new Place(sizePassenger);
        cargoCarsPlaces = new Place(sizeCargo);
    }

    private Place getTypeParking(int size) {
        return (size == PassengerCar.SIZE) ? passengerCarsPlaces : cargoCarsPlaces;
    }

    @Override
    public boolean takePlace(IVehicle car) {
        int sizeParking = car.getSize();
        Place parking = getTypeParking(sizeParking);
        OptionalInt optional = availablePlaceOnParking(sizeParking);
        if (optional.isPresent() && !checkCarExists(car)) {
            parking.addCar(optional.getAsInt(), car);
        } else {
            if (sizeParking > PassengerCar.SIZE) {
                Optional<String> isExists = pairAvailableParkingPlace(car);
                if (isExists.isEmpty() || checkCarExists(car)) {
                    return false;
                }
                takePairPlaceForCargoCarInPassengerParking(isExists.get(), car);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkCarExists(IVehicle car) {
        for (int i = 0; i < getTypeParking(car.getSize()).size(); i++) {
            Optional<IVehicle> optional = Optional.ofNullable(getTypeParking(car.getSize()).getPlace()[i]);
            if (optional.isPresent() && optional.get().equals(car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<String> pairAvailableParkingPlace(IVehicle car) {
        Place passengerParking = getTypeParking(PassengerCar.SIZE);
        return IntStream.range(0, passengerParking.size())
                .filter(index -> index < passengerParking.size() - 1)
                .filter(index -> checkPairEmptyPlace(index, car.getSize(), passengerParking))
                .mapToObj(index -> getEmptyPlace(index, car.getSize(), passengerParking).toString())
                .findFirst();
    }

    private boolean checkPairEmptyPlace(int index, int sizeParking, Place passengerParking) {
        for (int i = 0; index < passengerParking.size() - 1; index++, i++) {
            if (!passengerParking.getStatus(index) && i <= sizeParking) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getEmptyPlace(int index, int sizeParking, Place passengerParking) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; index < passengerParking.size(); index++, i++) {
            if (passengerParking.getStatus(index) && i < sizeParking) {
                result.add(index);
            }
        }
        return result.size() < sizeParking ? new ArrayList<>() : result;
    }

    private void takePairPlaceForCargoCarInPassengerParking(String pairPlace, IVehicle car) {
        Scanner scanner = new Scanner(pairPlace.replaceAll("[^\\d ]", ""));
        while (scanner.hasNextInt()) {
            getTypeParking(1).addCar(scanner.nextInt(), car);
        }
        scanner.close();
    }

    @Override
    public Map<Integer, List<Integer>> allAvailablePlace() {
        return getAllPlaceByPredicate(index -> index.equals(true));
    }

    @Override
    public Map<Integer, List<Integer>> allOccupiedPlace() {
        return getAllPlaceByPredicate(index -> index.equals(false));
    }

    private Map<Integer, List<Integer>> getAllPlaceByPredicate(Predicate<Boolean> predicate) {
        Map<Integer, List<Integer>> places = new HashMap<>();
        List<Place> place = List.of(passengerCarsPlaces, cargoCarsPlaces);
        for (int i = 0; i < place.size(); i++) {
            List<Integer> value = new ArrayList<>();
            Place tmp = place.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                if (predicate.test(tmp.getStatus(j))) {
                    value.add(j);
                    places.put(i, value);
                }
            }
        }
        return places;
    }

    private OptionalInt availablePlaceOnParking(int size) {
        return getPlaceByPredicate(size, getTypeParking(size)::getStatus);
    }

    private OptionalInt getPlaceByPredicate(int size, Predicate<Integer> predicate) {
        return IntStream.range(0, getTypeParking(size).size()).filter(predicate::test).findFirst();
    }
}

