package ood.lsp.parking;

import java.util.Objects;

public class PassengerCar implements IVehicle {
    public static final int SIZE = 1;
    private final int sizeParkingPlace;
    private final String number;

    public PassengerCar(String number) {
        this.sizeParkingPlace = SIZE;
        this.number = number;
    }

    @Override
    public int getSize() {
        return sizeParkingPlace;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return sizeParkingPlace == that.sizeParkingPlace && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeParkingPlace, number);
    }
}
