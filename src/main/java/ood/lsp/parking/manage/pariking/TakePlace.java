package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.IVehicle;
import ood.lsp.parking.StartUI;

import java.util.Optional;

public class TakePlace implements IManage {
    @Override
    public String msg() {
        return "Take a place.";
    }

    @Override
    public void execute(StartUI ui) {
        Optional<IVehicle> optional = Optional.ofNullable(ui.getVehicle());
        if (optional.isEmpty()) {
            System.out.println("Was selected no car");
        } else {
            int size = ui.getVehicle().sizeParkingPlace();
            ui.parking().accept(size);
            System.out.printf("Car has a size parking place - %s\n", size);
            if (size == 1) {
                new AddToParking(new PPassenger()).execute(ui);
            } else {
                new AddToParking(new PCargo()).execute(ui);
            }
            System.out.println("Car was added to parking");
        }
        ui.run();
    }
}
