package ood.lsp.parking;

import java.util.Objects;

public class CargoParking implements IParking {
    private boolean[] amountSpace;

    public CargoParking(int amountSpace) {
        this.amountSpace = new boolean[amountSpace];
    }

    @Override
    public void freeUpSpace(int index) {

    }

    @Override
    public boolean isSpaceForCargoCar() {
        return false;
    }

    @Override
    public boolean accept(int size) {
        return false;
    }

    @Override
    public int getAmountSpace() {
        return amountSpace.length;
    }

    @Override
    public void getAvailableSpace() {

    }

    @Override
    public void getOccupiedSpace() {

    }


    @Override
    public void takeParkingPlace(int index) {
        Objects.checkIndex(index, amountSpace.length);
    }

    @Override
    public boolean isParkingSpaceAvailable(int index) {
        return amountSpace[index];
    }

}
