package ood.lsp.parking;

public interface IParking {
    void freeUpSpace(int index);
    boolean isSpaceForCargoCar();
    int getAmountSpace();
    void getAvailableSpace();
    void takeParkingPlace(int index);
    boolean isParkingSpaceAvailable(int index);
}
