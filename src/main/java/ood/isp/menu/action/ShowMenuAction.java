package ood.isp.menu.action;

import ood.isp.menu.TODOApp;

public class ShowMenuAction implements IAction {
    @Override
    public String title() {
        return "Display menu:";
    }

    @Override
    public void execute(TODOApp app) {
        app.print(app.getMenu());
        app.run();
    }
}
