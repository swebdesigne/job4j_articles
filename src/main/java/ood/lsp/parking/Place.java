package ood.lsp.parking;

import java.util.*;

public class Place {
    private IVehicle[] pickedTypePlace;
    private static final int CARGO_SIZE = 2;
    private static final int PASSENGER_SIZE = 1;
    private final Map<Integer, IVehicle[]> place;

    public Place(int capacityCargo, int capacityPassenger) {
        place = Map.of(
                PASSENGER_SIZE, new IVehicle[capacityPassenger],
                CARGO_SIZE, new IVehicle[capacityCargo]
        );
    }

    void pickTypeParking(int size) {
        pickedTypePlace = place.get(size);
    }

    public int getCapacity() {
        return pickedTypePlace.length;
    }

    public IVehicle[] getPlaceByIndex() {
        return pickedTypePlace;
    }

    public  Map<Integer, IVehicle[]> getAllPlace() {
        return new HashMap<>(place);
    }

    public boolean getStatus(int index) {
        Optional<IVehicle> optional = Optional.ofNullable(pickedTypePlace[index]);
        return optional.isEmpty();
    }

    public void addCar(int index, IVehicle car) {
        pickedTypePlace[index] = car;
    }

    @Override
    public String toString() {
        return "Place{"
                + "pickedTypePlace=" + Arrays.toString(pickedTypePlace)
                + ", spaces=" + place
                + '}';
    }
}
