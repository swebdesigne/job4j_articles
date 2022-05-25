package ood.lsp.parking;

import java.util.Map;

public class Parking {
    private Map<String, IParking> parking;

    public Parking(Map<String, IParking> parking) {
        this.parking = parking;
    }

    public int totalAmountSpace() {
        return parking.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(parking -> parking.getAmountSpace())
                .sum();
    }

    public static void main(String[] args) {
        Parking parking = new Parking(
                Map.of(
                    "Passenger", new PassengerParking(3),
                    "Cargo", new CargoParking(2)
                )
        );
        IParking cargo = parking.parking.get("Passenger");

        cargo.takeParkingPlace(2);
        cargo.isSpaceForCargoCar();
    }
}
