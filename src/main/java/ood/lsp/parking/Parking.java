package ood.lsp.parking;

public class Parking implements IParking {
    private int amountCargoCarParkingPlace;
    private int amountPassengerCarParkingPlace;

    public Parking(int amountCargoCarParkingPlace, int amountPassengerCarParkingPlace) {
        this.amountCargoCarParkingPlace = amountCargoCarParkingPlace;
        this.amountPassengerCarParkingPlace = amountPassengerCarParkingPlace;
    }

    @Override
    public void checkAvailableParkingSpace() {

    }

    @Override
    public void takeParkingPlace() {

    }

    @Override
    public void totalAmountParkingSpace(Vehicle vehicle) {

    }
}
