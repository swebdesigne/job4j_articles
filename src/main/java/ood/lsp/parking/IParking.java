package ood.lsp.parking;

import java.util.Optional;
import java.util.OptionalInt;

public interface IParking {
    boolean takePlace(IVehicle car);
    Optional<String> pairAvailableParkingPlace();
}
