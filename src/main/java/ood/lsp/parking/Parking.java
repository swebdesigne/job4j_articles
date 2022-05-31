package ood.lsp.parking;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking<T extends IVehicle> implements IParking<T> {
    private final Place place;
    private final int capacity;

    public Parking(int capacityCargo, int capacityPassenger) {
        capacity = capacityCargo + capacityPassenger;
        this.place = new Place(capacityCargo, capacityPassenger);
    }

    @Override
    public boolean takeParkingPlace(int index) {
        if ((index < 0 || index > place.getCapacity()) || place.getStatus(index)) {
            return false;
        }
        place.setStatus(index, true);
        return true;
    }

    @Override
    public void freeUpPlace(int index) {
        if (place.getStatus(index)) {
            place.setStatus(index, false);
        }
    }

    @Override
    public String[] pairAvailableParkingPlace() {
        return IntStream.range(0, place.getPlaceByIndex().length)
                .filter(index -> index < place.getCapacity() - 1)
                .filter(index -> !place.getStatus(index) && !place.getStatus(index + 1))
                .mapToObj(index -> "[" + index + ", " + (index + 1) + "]")
                .toArray(String[]::new);
    }

    public void takePairPlaceForCargoCarInPassengerParking(String pairPlace) {
        Scanner scanner = new Scanner(pairPlace.replaceAll("[^\\d ]", ""));
        while (scanner.hasNextInt()) {
            takeParkingPlace(scanner.nextInt());
        }
        scanner.close();
    }

    public int getFullCapacity() {
        return capacity;
    }

    @Override
    public void accept(int size) {
        place.pickTypePlace(size);
    }

    @Override
    public int getCapacity() {
        return place.getCapacity();
    }

    public String[] allAvailablePlace() {
        return place.getAllPlace().keySet().stream()
                .map(index -> {
                            String res = "[";
                            boolean[] tmp = place.getAllPlace().get(index);
                            for (int i = 0; i < tmp.length; i++) {
                                if (!tmp[i]) {
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
    public int[] availablePlace() {
        return getPlaceByPredicate(index -> !place.getStatus(index));
    }

    @Override
    public int[] occupiedPlace() {
        return getPlaceByPredicate(place::getStatus);
    }

    private int[] getPlaceByPredicate(Predicate<Integer> predicate) {
        return IntStream.range(0, place.getCapacity())
                .filter(predicate::test)
                .toArray();
    }
}
