package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;

import java.util.Map;

public class AddToParking {
    IAddToParking parking;

    public AddToParking(int size) {
        parking = Map.of(1, new PPassenger(), 2, new PCargo()).get(size);
    }

    public void add(StartUI ui) {
        parking.add(ui);
    }
}
