package ood.lsp.parking;

import java.util.Objects;
import java.util.stream.IntStream;

public class PassengerParking implements IParking {
    private boolean[] amountSpace;

    public PassengerParking(int amountSpace) {
        this.amountSpace = new boolean[amountSpace];
    }

    @Override
    public boolean isSpaceForCargoCar() {
        System.out.println(amountSpace.length);
        return true;
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

    public void getAvailableSpace() {
        IntStream.range(0, amountSpace.length)
                .filter(space -> amountSpace[space])
                .forEach(space -> System.out.printf("Space number which  available: %s\n", space));
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
