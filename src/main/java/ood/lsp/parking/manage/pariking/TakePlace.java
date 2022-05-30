package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.IVehicle;
import ood.lsp.parking.StartUI;
import ood.lsp.parking.console.ConsoleInput;

import java.util.Arrays;
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
            ui.run();
        } else {
            int sizePlace = ui.getVehicle().sizeParkingPlace();
            System.out.printf("Vehicle has a size parking place - %s\n", sizePlace);
            if (sizePlace == 1) {
                ui.parking().accept(sizePlace);
                Optional<int[]> amountPlace = Optional.ofNullable(ui.parking().availablePlace());
                if (amountPlace.isEmpty()) {
                    System.out.println("Sorry, passenger parking has no the empty place");
                } else {
                    System.out.println("Please, choose the parking place");
                    System.out.printf("Empty place: %s\n", Arrays.toString(ui.parking().availablePlace()));
                    int ans = ConsoleInput.askInt(ConsoleInput.askStr());
                    boolean isOccupied = ui.parking().takeParkingPlace(ans);
                    if (!isOccupied) {
                        System.out.println("Please choose another place");
                    }
                }
                ui.run();
            }
        }
    }
}
