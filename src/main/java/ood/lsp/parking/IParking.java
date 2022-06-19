package ood.lsp.parking;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IParking {
    boolean takePlace(IVehicle car);
    Optional<String> pairAvailableParkingPlace(IVehicle car);
    Map<Integer, List<Integer>> allAvailablePlace();
    Map<Integer, List<Integer>> allOccupiedPlace();
}
