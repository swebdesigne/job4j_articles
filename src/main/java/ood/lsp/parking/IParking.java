package ood.lsp.parking;

public interface IParking {
    void freeUpSpace(int index);
    boolean isSpaceForCargoCar();
    void accept(int size);
    int getAmountSpace();
    void getAvailableSpace();
    void getOccupiedSpace();
    void takeParkingPlace(int index);
}
