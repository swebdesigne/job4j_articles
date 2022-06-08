package ood.lsp.parking;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Parking implements IParking {
    private Place typeParking;
    List<Place> place;

    public Parking(int sizePassenger, int sizeCargo) {
        place = List.of(new Place(sizePassenger), new Place(sizeCargo));
    }

    private Place getTypeParking() {
        return typeParking;
    }

    private void setTypeParking(int size) {

    }

    @Override
    public boolean takePlace(IVehicle car) {
        return false;
    }

    @Override
    public Optional<String> pairAvailableParkingPlace() {
        return Optional.empty();
    }

    private void takePairPlaceForCargoCarInPassengerParking(String pairPlace, IVehicle car) {

    }

    @Override
    public Map<Integer, List<Integer>> allAvailablePlace() {
        return null;
    }

    @Override
    public Map<Integer, List<Integer>> allOccupiedPlace() {
        return null;
    }

    private Map<Integer, List<Integer>> getAllPlaceByPredicate(Predicate<Integer> predicate) {
        return null;
    }

    private OptionalInt availablePlaceOnParking() {
        return OptionalInt.empty();
    }

    private OptionalInt getPlaceByPredicate(Predicate<Integer> predicate) {
        return OptionalInt.empty();
    }
}
