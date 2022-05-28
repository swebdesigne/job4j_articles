package ood.lsp.parking;

public class PassengerCar implements IVehicle {
    private final int sizeParkingPlace;

    public PassengerCar(int sizeParkingPlace) {
        this.sizeParkingPlace = sizeParkingPlace;
    }

    @Override
    public int sizeParkingPlace() {
        return sizeParkingPlace;
    }
}
