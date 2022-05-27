package ood.lsp.parking;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Parking implements IParking {
    private Place place;
    private final int capacity;

    public Parking(int capacityCargo, int capacityPassenger) {
        capacity = capacityCargo + capacityPassenger;
        this.place = new Place(capacityCargo, capacityPassenger);
    }

    @Override
    public String[] isPlaceForCargoCarOnPassengerParking() {
        return IntStream.range(0, place.getSpace().length)
                .filter(index -> index < place.getCapacity() - 1)
                .filter(index -> !place.getStatus(index) && !place.getStatus(index + 1))
                .mapToObj(index -> "[" + index + ", " + (index + 1) + "]")
                .toArray(String[]::new);
    }

    public int getAmountPlace() {
        return capacity;
    }

    @Override
    public void accept(int size) {
        place.pickTypePlace(size);
    }

    @Override
    public void freeUpSpace(int index) {
        if (place.getStatus(index)) {
            place.setStatus(index, false);
        }
    }

    @Override
    public int getAmountSpace() {
        return place.getSpace().length;
    }

    @Override
    public void getAvailableSpace() {
        IntStream.range(0, place.getSpace().length)
                .filter(index -> !place.getStatus(index))
                .forEach(space -> System.out.printf("Space number which available: %s\n", space));
    }

    @Override
    public void getOccupiedSpace() {
        IntStream.range(0, place.getSpace().length)
                .filter(index -> place.getStatus(index))
                .forEach(space -> System.out.printf("Space number which available: %s\n", space));
    }

    @Override
    public void takeParkingPlace(int index) {
        if (!place.getStatus(index)) {
            place.setStatus(index, true);
        }
    }

    public static void main(String[] args) {
        Parking parking = new Parking(3, 4);
        parking.accept(1);
        parking.takeParkingPlace(0);
        Arrays.stream(parking.isPlaceForCargoCarOnPassengerParking()).forEach(System.out::println);
        System.out.println();
        parking.getOccupiedSpace();
    }
}
