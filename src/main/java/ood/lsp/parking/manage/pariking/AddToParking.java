package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;

public class AddToParking {
    IAddToParking parking;

    public AddToParking(IAddToParking parking) {
        this.parking = parking;
    }

    public void execute(StartUI ui) {
        parking.add(ui);
    }
}
