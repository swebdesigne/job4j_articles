package ood.isp.menu;

public class ShowMenu implements IScheduler {
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
