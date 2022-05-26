package ood.lsp.parking;

public class Place {
    private boolean[] cargo;
    private boolean[] passenger;
    private static final int CARGO_SIZE = 2;
    private static final int PASSENGER_SIZE = 1;

    public Place(int capacityCargo, int capacityPassenger) {
        this.cargo = new boolean[capacityCargo];
        this.passenger = new boolean[capacityPassenger];
    }

    public boolean[] getCargo() {
        return cargo;
    }

    public void setCargo(boolean[] cargo) {
        this.cargo = cargo;
    }

    public boolean[] getPassenger() {
        return passenger;
    }

    public boolean getPassengerByIndex(int index) {
        return passenger[index];
    }

    public void setPassenger(int index, boolean status) {
        this.passenger[index] = status;
    }
}
