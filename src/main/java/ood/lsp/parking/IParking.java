package ood.lsp.parking;

public interface IParking<T> {
    void takeParkingPlace(int index);
    void freeUpPlace(int index);
    String[] pairAvailableParkingPlace();
    int getCapacity();
    void accept(T vehicle);
    int[] getAvailablePlace();
    int[] getOccupiedPlace();
}
