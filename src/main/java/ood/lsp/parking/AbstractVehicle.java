package ood.lsp.parking;

import java.util.Objects;

public abstract class AbstractVehicle implements IVehicle {
    private final int sizeParkingPlace;
    private final String number;

    protected AbstractVehicle(int sizeParkingPlace, String number) {
        this.sizeParkingPlace = sizeParkingPlace;
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
        AbstractVehicle car = (AbstractVehicle) o;
        return sizeParkingPlace == car.sizeParkingPlace && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeParkingPlace, number);
    }

}
