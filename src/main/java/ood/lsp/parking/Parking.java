package ood.lsp.parking;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking implements IParking {
    private Place typeParking;
    private final List<Place> place;

    public Parking(int sizePassenger, int sizeCargo) {
        place = List.of(new Place(sizePassenger), new Place(sizeCargo));
    }

    private Place getTypeParking() {
        return typeParking;
    }

    private void setTypeParking(int size) {
        typeParking = (size == PassengerCar.SIZE) ? place.get(0) : place.get(1);
    }

    @Override
    public boolean takePlace(IVehicle car) {
        int sizeParking = car.getSizeParkingPlace();
        setTypeParking(sizeParking);
        OptionalInt optional = availablePlaceOnParking();
        if (optional.isPresent() && !checkCarExists(car)) {
            getTypeParking().addCar(optional.getAsInt(), car);
        } else {
            if (sizeParking > PassengerCar.SIZE) {
                setTypeParking(PassengerCar.SIZE);
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
        for (int i = 0; i < getTypeParking().size(); i++) {
            Optional<IVehicle> optional = Optional.ofNullable(getTypeParking().getPlace()[i]);
            if (optional.isPresent() && optional.get().equals(car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<String> pairAvailableParkingPlace(IVehicle car) {
        Place passengerParking = place.get(0);
        return IntStream.range(0, passengerParking.size())
                .filter(index -> index < passengerParking.size() - 1)
                .filter(index -> checkPairEmptyPlace(index, car.getSizeParkingPlace(), passengerParking))
                .mapToObj(index -> getEmptyPlace(index, car.getSizeParkingPlace(), passengerParking).toString())
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
            getTypeParking().addCar(scanner.nextInt(), car);
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
        Map<Integer, List<Integer>> parking = new HashMap<>();
        for (int i = 0; i < place.size(); i++) {
            List<Integer> value = new ArrayList<>();
            Place tmp = place.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                if (predicate.test(tmp.getStatus(j))) {
                    value.add(j);
                    parking.put(i, value);
                }
            }
        }
        return parking;
    }

    private OptionalInt availablePlaceOnParking() {
        return getPlaceByPredicate(getTypeParking()::getStatus);
    }

    private OptionalInt getPlaceByPredicate(Predicate<Integer> predicate) {
        return IntStream.range(0, getTypeParking().size()).filter(predicate::test).findFirst();
    }
}

