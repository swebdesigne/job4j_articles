package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;
import ood.lsp.parking.console.ConsoleInput;

public class SelectParking implements IManage {
    @Override
    public String msg() {
        return "Select parking.";
    }

    @Override
    public void execute(StartUI ui) {
        System.out.println("Select the size for parking place");
        ui.parking().accept(ConsoleInput.askInt(ConsoleInput.askStr()));
    }
}
