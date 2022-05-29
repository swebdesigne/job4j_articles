package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;

public class SelectParking implements IManage {
    @Override
    public String msg() {
        return "Select parking.";
    }

    @Override
    public void execute(StartUI startUI) {
        System.out.println("Select the size for parking place");
        int size = Integer.parseInt(startUI.ask());
        startUI.parking().accept(size);
    }
}
