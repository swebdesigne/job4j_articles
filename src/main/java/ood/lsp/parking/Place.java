package ood.lsp.parking;

import java.util.*;

public class Place {
    private boolean[] pickedTypePlace;
    private static final int CARGO_SIZE = 2;
    private static final int PASSENGER_SIZE = 1;
    private final Map<Integer, boolean[]> place;

    public Place(int capacityCargo, int capacityPassenger) {
        place = Map.of(
                PASSENGER_SIZE, new boolean[capacityPassenger],
                CARGO_SIZE, new boolean[capacityCargo]
        );
    }

    void pickTypeParking(int size) {
        pickedTypePlace = place.get(size);
    }

    public int getCapacity() {
        return pickedTypePlace.length;
    }

    public boolean[] getPlaceByIndex() {
        return pickedTypePlace;
    }

    public  Map<Integer, boolean[]> getAllPlace() {
        return new HashMap<>(place);
    }

    public boolean getStatus(int index) {
        Objects.checkIndex(index, pickedTypePlace.length);
        return pickedTypePlace[index];
    }

    public void setStatus(int index, boolean status) {
        Objects.checkIndex(index, pickedTypePlace.length);
        pickedTypePlace[index] = status;
    }

    @Override
    public String toString() {
        return "Place{"
                + "pickedTypePlace=" + Arrays.toString(pickedTypePlace)
                + ", spaces=" + place
                + '}';
    }
}
