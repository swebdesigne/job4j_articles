package ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Ignore
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

    @Ignore
    @Test
    public void whenPairAvailableParkingPlaceIsExists() {
        Parking parking = new Parking(3, 2);
        parking.pairAvailableParkingPlace();
        assertTrue(parking.pairAvailableParkingPlace().isEmpty());
    }

    @Ignore
    @Test
    public void whenPairAvailableParkingPlaceNotExists() {
        Parking parking = new Parking(3, 2);
        parking.pairAvailableParkingPlace();
        assertFalse(parking.pairAvailableParkingPlace().isEmpty());
    }

    @Ignore
    @Test
    public void allAvailablePlace() {
        Parking parking = new Parking(0, 0);
        assertTrue(parking.allAvailablePlace().isEmpty());
    }

    @Ignore
    @Test
    public void allOccupiedPlace() {
        Parking parking = new Parking(3, 2);
        assertTrue(parking.allOccupiedPlace().isEmpty());
    }
}
