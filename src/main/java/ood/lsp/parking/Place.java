package ood.lsp.parking;

import java.util.*;

public class Place {
    private final IVehicle[] place;

    public Place(int size) {
        place = new IVehicle[size];
    }

    public int size() {
        return 0;
    }

    public boolean getStatus(int index) {
        return false;
    }

    public void addCar(int index, IVehicle car) {
        
    }

    @Override
    public String toString() {
        return "Place{"
                + "pickedTypePlace=" + Arrays.toString(place)
                + ", place=" + Arrays.toString(place)
                + '}';
    }
}
