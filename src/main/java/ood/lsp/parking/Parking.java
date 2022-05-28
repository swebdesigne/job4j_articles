package ood.lsp.parking;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking<T extends IVehicle> implements IParking<T> {
    private final Place place;
    private final int capacity;

    public Parking(int capacityCargo, int capacityPassenger) {
        capacity = capacityCargo + capacityPassenger;
        this.place = new Place(capacityCargo, capacityPassenger);
    }

    @Override
    public void takeParkingPlace(int index) {
        if (!place.getStatus(index)) {
            place.setStatus(index, true);
        }
    }

    @Override
    public void freeUpPlace(int index) {
        if (place.getStatus(index)) {
            place.setStatus(index, false);
        }
    }

    @Override
    public String[] pairAvailableParkingPlace() {
        return IntStream.range(0, place.getSpace().length)
                .filter(index -> index < place.getCapacity() - 1)
                .filter(index -> !place.getStatus(index) && !place.getStatus(index + 1))
                .mapToObj(index -> "[" + index + ", " + (index + 1) + "]")
                .toArray(String[]::new);
    }

    public int getFullCapacity() {
        return capacity;
    }

    @Override
    public void accept(T vehicle) {
        place.pickTypePlace(vehicle.sizeParkingPlace());
    }

    @Override
    public int getCapacity() {
        return place.getCapacity();
    }

    @Override
    public int[] getAvailablePlace() {
        return getPlaceByPredicate(index -> !place.getStatus(index));
    }

    @Override
    public int[] getOccupiedPlace() {
        return getPlaceByPredicate(place::getStatus);
    }

    private int[] getPlaceByPredicate(Predicate<Integer> predicate) {
        return IntStream.range(0, place.getCapacity())
                .filter(predicate::test)
                .toArray();
    }

    public static void main(String[] args) {
        IVehicle passenger = new PassengerCar(1);
        Parking<IVehicle> parking = new Parking<>(3, 4);
        parking.accept(passenger);
        parking.takeParkingPlace(0);
        parking.takeParkingPlace(3);
        Arrays.stream(parking.pairAvailableParkingPlace()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(parking.getOccupiedPlace()).forEach(System.out::println);
        System.out.println(parking.getFullCapacity());
    }
}
