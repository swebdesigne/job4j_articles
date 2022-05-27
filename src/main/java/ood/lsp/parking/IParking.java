package ood.lsp.parking;

import java.util.List;

public interface IParking {
    void freeUpSpace(int index);
    String[] isPlaceForCargoCarOnPassengerParking();
    void accept(int size);
    int getAmountSpace();
    void getAvailableSpace();
    void getOccupiedSpace();
    void takeParkingPlace(int index);
}
