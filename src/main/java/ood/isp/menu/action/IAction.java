package ood.isp.menu.action;

import ood.isp.menu.TODOApp;

public interface IAction {
    String title();
    void execute(TODOApp app);
}
