package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;
import ood.lsp.parking.console.ConsoleInput;

import java.util.Arrays;
import java.util.Optional;

public class PCargo implements IAddToParking {
    public PCargo() {
        System.out.println("Please, choose the parking place");
    }

    @Override
    public void add(StartUI ui) {
        Optional<int[]> amountPlace = Optional.ofNullable(ui.parking().availablePlace());
        if (amountPlace.isEmpty()) {
            System.out.println("Sorry, passenger parking has no the empty place");

            ConsoleInput.askStr();
        } else {
            System.out.printf("Empty place: %s\n", Arrays.toString(ui.parking().availablePlace()));
            int ans = ConsoleInput.askInt(ConsoleInput.askStr());
            if (!ui.parking().takeParkingPlace(ans)) {
                System.out.printf("Please choose another place № %s\n", ans);
                add(ui);
            }
        }
    }
}
