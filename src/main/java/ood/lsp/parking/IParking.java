package ood.lsp.parking;

import java.util.Optional;
import java.util.OptionalInt;

public interface IParking {
    boolean takePlace();
    Optional<String> pairAvailableParkingPlace();
    int getCapacity();
    void pickPlace(int size);
    OptionalInt availablePlaceOnParking();
    OptionalInt occupiedOnParking();
}
