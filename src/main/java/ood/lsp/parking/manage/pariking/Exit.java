package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;
import ood.lsp.parking.console.ConsoleInput;

public class Exit implements IManage {
    private static final String NO = "no";
    private static final String YES = "yes";

    @Override
    public String msg() {
        return "Exit.";
    }

    @Override
    public void execute(StartUI ui) {
        System.out.println("Are you sure (yes, no) ?");
        String ans = ConsoleInput.askStr();
        if (ans.equals(NO)) {
            ui.run();
        } else if (ans.equals(YES)) {
            System.out.println("Goodbye!");
            ConsoleInput.stop();
        } else {
            System.out.println("Wrong answer, please repeat!");
            ui.run();
        }
    }
}
