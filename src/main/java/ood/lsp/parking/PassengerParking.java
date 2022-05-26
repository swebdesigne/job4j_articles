package ood.lsp.parking;

import java.util.Objects;
import java.util.stream.IntStream;

public class PassengerParking implements IParking {
    private final int capacity;
    private static final int PASSENGER_SIZE = 1;
    private Place place;

    public PassengerParking(int amountSpace) {
        capacity = 7 - 1;
        this.place = new Place(3, 4);
    }

    @Override
    public boolean isSpaceForCargoCar() {
        IntStream.range(0, capacity)
                .filter(index -> index < capacity)
                .filter(index -> !isParkingSpaceAvailable(index) && !isParkingSpaceAvailable(index + 1))
                .forEach(space -> System.out.printf("Available spaces: [%s, %s]\n", space, space + 1));
        return true;
    }

    @Override
    public boolean accept(int size) {
        return size > PASSENGER_SIZE;
    }

    @Override
    public void freeUpSpace(int index) {
        if (isParkingSpaceAvailable(index)) {
            place.setPassenger(index, false);
        }
    }

    @Override
    public int getAmountSpace() {
        return place.getPassenger().length;
    }

    @Override
    public void getAvailableSpace() {
        IntStream.range(0, place.getPassenger().length)
                .filter(index -> !place.getPassengerByIndex(index))
                .forEach(space -> System.out.printf("Space number which available: %s\n", space));
    }

    public void getOccupiedSpace() {
        IntStream.range(0, place.getPassenger().length)
                .filter(index -> place.getPassengerByIndex(index))
                .forEach(space -> System.out.printf("Space number which available: %s\n", space));
    }

    @Override
    public void takeParkingPlace(int index) {
        if (!isParkingSpaceAvailable(index)) {
            place.setPassenger(index, true);
        }
    }

    @Override
    public boolean isParkingSpaceAvailable(int index) {
        Objects.checkIndex(index, place.getPassenger().length - 1);
        return place.getPassengerByIndex(index);
    }
}
