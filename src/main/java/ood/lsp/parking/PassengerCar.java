package ood.lsp.parking;

public class PassengerCar implements IVehicle {
    private final int sizeParkingPlace;
    private final String number;
    public PassengerCar(int sizeParkingPlace, String number) {
        this.sizeParkingPlace = sizeParkingPlace;
        this.number = number;
    }

    @Override
    public int sizeParkingPlace() {
        return sizeParkingPlace;
    }

    public String getNumber() {
        return number;
    }
}
