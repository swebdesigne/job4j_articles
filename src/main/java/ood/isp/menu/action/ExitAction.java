package ood.isp.menu.action;

import ood.isp.menu.TODOApp;

public class ExitAction implements IAction {
    @Override
    public String title() {
        return "Exit:";
    }

    @Override
    public void execute(TODOApp app) {
        System.out.println("Come again, bye!");
        app.close();
    }
}
