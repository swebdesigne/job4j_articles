package ood.isp.menu;

public class Exit implements IScheduler {
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
