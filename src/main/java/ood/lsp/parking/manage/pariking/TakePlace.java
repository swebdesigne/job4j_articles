package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.IVehicle;
import ood.lsp.parking.StartUI;
import org.apache.commons.math3.analysis.function.Add;

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
            new AddToParking(size).add(ui);
            System.out.println("Car was added to parking");
        }
        ui.run();
    }
}
