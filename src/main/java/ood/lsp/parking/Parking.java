package ood.lsp.parking;

import java.util.stream.IntStream;

public class Parking implements IParking {
    private Place place;
    private final int capacity;

    public Parking(int capacityCargo, int capacityPassenger) {
        capacity = (capacityCargo + capacityPassenger) - 1;
        this.place = new Place(capacityCargo, capacityPassenger);
    }

    @Override
    public boolean isSpaceForCargoCar() {
        IntStream.range(0, place.getSpace().length)
                .filter(index -> index < place.getSpace().length - 1)
                .filter(index -> !place.getStatus(index) && !place.getStatus(index + 1))
                .forEach(space -> System.out.printf("There is available on the passenger of place: [%s, %s]\n", space, space + 1));
        return true;
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
        parking.takeParkingPlace(2);
        System.out.println(parking.place.getStatus(2));
        parking.isSpaceForCargoCar();
        parking.getOccupiedSpace();
    }
}
