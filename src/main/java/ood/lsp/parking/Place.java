package ood.lsp.parking;

import java.util.*;

public class Place {
    private final IVehicle[] place;

    public Place(int size) {
        place = new IVehicle[size];
    }

    public int size() {
        return place.length;
    }

    public boolean getStatus(int index) {
        Optional<IVehicle> optional = Optional.ofNullable(place[index]);
        return optional.isEmpty();
    }

    public void addCar(int index, IVehicle car) {
        place[index] = car;
    }

    @Override
    public String toString() {
        return "Place{"
                + "pickedTypePlace=" + Arrays.toString(place)
                + ", place=" + Arrays.toString(place)
                + '}';
    }
}
