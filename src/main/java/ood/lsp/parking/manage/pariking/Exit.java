package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;

public class Exit implements IManage {
    @Override
    public String msg() {
        return "Exit.";
    }

    @Override
    public void execute(StartUI manage) {
        System.out.println("Are you sure (yes, no) ?");
        String ans = manage.ask();
        if (ans.equals("no")) {
            manage.run();
        } else {
            System.out.println("Goodbye!!!");
            manage.stop();
        }
    }
}
