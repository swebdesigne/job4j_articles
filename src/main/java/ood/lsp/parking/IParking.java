package ood.lsp.parking;

public interface IParking {
    void freeUpSpace(int index);
    boolean isSpaceForCargoCar();
    boolean accept(int size);
    int getAmountSpace();
    void getAvailableSpace();
    void getOccupiedSpace();
    void takeParkingPlace(int index);
    boolean isParkingSpaceAvailable(int index);
}
