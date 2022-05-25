package ood.lsp.parking;

import java.util.Objects;
import java.util.stream.IntStream;

public class PassengerParking implements IParking {
    private static int SIZE = 1;
    private boolean[] amountSpace;

    public PassengerParking(int amountSpace) {
        this.amountSpace = new boolean[amountSpace];
    }

    @Override
    public boolean isSpaceForCargoCar() {
        IntStream.range(0, amountSpace.length)
                .filter(index -> index < amountSpace.length - 1)
                .filter(index -> !isParkingSpaceAvailable(index) && !isParkingSpaceAvailable(index + 1))
                .forEach(space -> System.out.printf("Available spaces: [%s, %s]\n", space, space + 1));
        return true;
    }

    @Override
    public boolean accept(int size) {
        return size > SIZE;
    }

    @Override
    public void freeUpSpace(int index) {
        if (isParkingSpaceAvailable(index)) {
            amountSpace[index] = false;
        }
    }

    @Override
    public int getAmountSpace() {
        return amountSpace.length;
    }

    @Override
    public void getAvailableSpace() {
        IntStream.range(0, amountSpace.length)
                .filter(index -> !amountSpace[index])
                .forEach(space -> System.out.printf("Space number which available: %s\n", space));
    }

    public void getOccupiedSpace() {
        IntStream.range(0, amountSpace.length)
                .filter(index -> amountSpace[index])
                .forEach(space -> System.out.printf("Space number which available: %s\n", space));
    }

    @Override
    public void takeParkingPlace(int index) {
        if (!isParkingSpaceAvailable(index)) {
            amountSpace[index] = true;
        }
    }

    @Override
    public boolean isParkingSpaceAvailable(int index) {
        Objects.checkIndex(index, amountSpace.length);
        return amountSpace[index];
    }
}
