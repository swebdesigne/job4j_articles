package ood.lsp.parking;

public class PassengerCar implements IVehicle {
    public static final int SIZE = 1;
    private final int sizeParkingPlace;
    private final String number;

    public PassengerCar(String number) {
        this.sizeParkingPlace = SIZE;
        this.number = number;
    }

    @Override
    public int getSizeParkingPlace() {
        return sizeParkingPlace;
    }

    public String getNumber() {
        return number;
    }
}
