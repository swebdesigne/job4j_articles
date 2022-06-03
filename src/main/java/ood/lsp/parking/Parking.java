package ood.lsp.parking;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Parking implements IParking {
    private final Place place;

    public Parking(int capacityCargo, int capacityPassenger) {
        this.place = new Place(capacityCargo, capacityPassenger);
    }

    @Override
    public boolean takePlace(IVehicle car) {
        int sizeParking = car.sizeParkingPlace();
        place.pickTypeParking(sizeParking);
        OptionalInt optional = availablePlaceOnParking();
        if (optional.isPresent()) {
            place.addCar(optional.getAsInt(), car);
        } else {
            if (sizeParking > 1) {
                place.pickTypeParking(1);
                Optional<String> isExists = pairAvailableParkingPlace();
                if (isExists.isEmpty()) {
                    return false;
                }
                takePairPlaceForCargoCarInPassengerParking(isExists.get(), car);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<String> pairAvailableParkingPlace() {
        return IntStream.range(0, place.getPlaceByIndex().length)
                .filter(index -> index < place.getCapacity() - 1)
                .filter(index -> place.getStatus(index) && place.getStatus(index + 1))
                .mapToObj(index -> "[" + index + ", " + (index + 1) + "]")
                .findFirst();
    }

    public void takePairPlaceForCargoCarInPassengerParking(String pairPlace, IVehicle car) {
        Scanner scanner = new Scanner(pairPlace.replaceAll("[^\\d ]", ""));
        while (scanner.hasNextInt()) {
            place.addCar(scanner.nextInt(), car);
        }
        scanner.close();
    }

    public String[] allAvailablePlace() {
        return getAllPlaceByPredicate(index -> place.getStatus(index));
    }


    public String[] allOccupiedPlace() {
        return getAllPlaceByPredicate(index -> !place.getStatus(index));
    }

    private String[] getAllPlaceByPredicate(Predicate<Integer> predicate) {
        return place.getAllPlace().keySet().stream()
                .map(numberParking -> {
                            place.pickTypeParking(numberParking);
                            String res;
                            res = "Parking № " + numberParking + " -> [";
                            for (int i = 0; i < place.getPlaceByIndex().length; i++) {
                                if (predicate.test(i)) {
                                    res += i;
                                    if (i != place.getPlaceByIndex().length - 1) {
                                        res += ", ";
                                    }
                                }
                            }
                            return res + "]";
                        }
                ).toArray(String[]::new);
    }

    private OptionalInt availablePlaceOnParking() {
        return getPlaceByPredicate(index -> place.getStatus(index));
    }

    private OptionalInt getPlaceByPredicate(Predicate<Integer> predicate) {
        return IntStream.range(0, place.getCapacity())
                .filter(predicate::test)
                .findAny();
    }

    public static void main(String[] args) {
        Parking parking = new Parking(3, 4);
        Arrays.stream(parking.allAvailablePlace()).forEach(System.out::println);
        PassengerCar car1 = new PassengerCar(1, "123NOUN");
        parking.takePlace(car1);
        PassengerCar car2 = new PassengerCar(1, "234NOUN");
        parking.takePlace(car2);
        PassengerCar car3 = new PassengerCar(2, "345NOUN");
        parking.takePlace(car3);
        PassengerCar car4 = new PassengerCar(2, "456NOUN");
        parking.takePlace(car4);
        PassengerCar car5 = new PassengerCar(2, "567NOUN");
        System.out.println(parking.takePlace(car5));
        PassengerCar car6 = new PassengerCar(2, "568NOUN");
        System.out.println(parking.takePlace(car6));
        Arrays.stream(parking.allAvailablePlace()).forEach(System.out::println);
        Arrays.stream(parking.allOccupiedPlace()).forEach(System.out::println);
    }
}
