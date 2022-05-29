package ood.lsp.parking;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Place {
    private static final int CARGO_SIZE = 2;
    private static final int PASSENGER_SIZE = 1;
    private boolean[] pickedTypePlace;
    private final Map<Integer, boolean[]> place;
    private Map<Integer, Map<Integer, IVehicle>> vehicle;

    public Place(int capacityCargo, int capacityPassenger) {
        place = Map.of(
                PASSENGER_SIZE, new boolean[capacityPassenger],
                CARGO_SIZE, new boolean[capacityCargo]
        );
    }

    void pickTypePlace(int size) {
        pickedTypePlace = place.get(size);
    }

    public int getCapacity() {
        return pickedTypePlace.length;
    }

    public boolean[] getSpace() {
        return pickedTypePlace;
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
