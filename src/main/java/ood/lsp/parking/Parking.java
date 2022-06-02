package ood.lsp.parking;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking implements IParking {
    private final Place place;
    private int pickedPlace;

    public Parking(int capacityCargo, int capacityPassenger) {
        this.place = new Place(capacityCargo, capacityPassenger);
    }

    @Override
    public boolean takePlace(IVehicle car) {
        OptionalInt optional = availablePlaceOnParking();
        if (optional.isPresent()) {
            place.setStatus(optional.getAsInt(), car);
        } else {
            if (pickedPlace > 1) {
                pickPlace(1);
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
        return IntStream.range(0, place.getPlaceByIndex().length)
                .filter(index -> index < place.getCapacity() - 1)
                .filter(index -> place.getStatus(index) && place.getStatus(index + 1))
                .mapToObj(index -> "[" + index + ", " + (index + 1) + "]")
                .findFirst();
    }

    public void takePairPlaceForCargoCarInPassengerParking(String pairPlace, IVehicle car) {
        Scanner scanner = new Scanner(pairPlace.replaceAll("[^\\d ]", ""));
        while (scanner.hasNextInt()) {
            place.setStatus(scanner.nextInt(), car);
        }
        scanner.close();
    }

    @Override
    public void pickPlace(int size) {
        pickedPlace = size;
        place.pickTypeParking(size);
    }

    @Override
    public int getCapacity() {
        return place.getCapacity();
    }

    public String[] allAvailablePlace() {
        return place.getAllPlace().values().stream()
                .map(car -> {
                            String res = "";
                            res = "[";
                            for (int i = 0; i < car.length; i++) {
                                if (place.getStatus(i)) {
                                    if (i != 0) {
                                        res += ", ";
                                    }
                                    res += i;
                                }
                            }
                            return res + "]";
                        }
                ).toArray(String[]::new);
    }

    @Override
    public OptionalInt availablePlaceOnParking() {
        return getPlaceByPredicate(index -> !place.getStatus(index));
    }

    @Override
    public OptionalInt occupiedOnParking() {
        return getPlaceByPredicate(place::getStatus);
    }

    private OptionalInt getPlaceByPredicate(Predicate<Integer> predicate) {
        return IntStream.range(0, place.getCapacity())
                .filter(predicate::test)
                .findFirst();
    }
}
