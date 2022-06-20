package ood.lsp.parking;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenTakePlaceTrue() {
        PassengerCar passengerCar = new PassengerCar("12NOP");
        Parking parking = new Parking(3, 2);
        assertTrue(parking.takePlace(passengerCar));
    }

    @Test
    public void whenTakePlaceFalse() {
        PassengerCar passengerCar = new PassengerCar("12NOP");
        Parking parking = new Parking(0, 0);
        assertFalse(parking.takePlace(passengerCar));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenWrongSizeParkingForCargoCar() {
        CargoCar car = new CargoCar(1, "12NOP");
        Parking parking = new Parking(2, 1);
        parking.takePlace(car);
    }

    @Test
    public void whenPairAvailableParkingPlaceIsExistsInPassengerParking() {
        Parking parking = new Parking(3, 2);
        CargoCar car = new CargoCar(2, "1222AKK");
        assertTrue(parking.pairAvailableParkingPlace(car).isPresent());
    }

    @Test
    public void whenPairAvailableParkingPlaceNotExistsInPassengerParking() {
        Parking parking = new Parking(0, 2);
        CargoCar car = new CargoCar(2, "1222AKK");
        assertTrue(parking.pairAvailableParkingPlace(car).isEmpty());
    }

    @Test
    public void allAvailablePlace() {
        Parking parking = new Parking(0, 0);
        assertTrue(parking.allAvailablePlace().isEmpty());
    }

    @Test
    public void allAvailablePlacePlaceWhenHasOccupiedPlace() {
        Parking parking = new Parking(5, 2);
        PassengerCar car = new PassengerCar("123NOP");
        PassengerCar car2 = new PassengerCar("456NOS");
        CargoCar car3 = new CargoCar(2, "1222AKK");
        parking.takePlace(car);
        parking.takePlace(car2);
        parking.takePlace(car3);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(0, List.of(2, 3, 4));
        expected.put(1, List.of(1));
        assertEquals(parking.allAvailablePlace(), expected);
    }

    @Test
    public void allOccupiedPlace() {
        Parking parking = new Parking(5, 2);
        PassengerCar car = new PassengerCar("123NOP");
        PassengerCar car2 = new PassengerCar("456NOS");
        CargoCar car3 = new CargoCar(2, "1222AKK");
        CargoCar car4 = new CargoCar(2, "12AKK");
        CargoCar car5 = new CargoCar(3, "1233AKK");
        parking.takePlace(car);
        parking.takePlace(car2);
        parking.takePlace(car3);
        parking.takePlace(car4);
        parking.takePlace(car5);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(0, List.of(0, 1, 2, 3, 4));
        expected.put(1, List.of(0, 1));
        assertEquals(parking.allOccupiedPlace(), expected);
    }

    @Test
    public void whenExistsDuplicateNoAddToParking() {
        Parking parking = new Parking(3, 2);
        PassengerCar car = new PassengerCar("123NOP");
        parking.takePlace(car);
        parking.takePlace(car);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(0, List.of(0));
        assertEquals(parking.allOccupiedPlace(), expected);
    }
}
