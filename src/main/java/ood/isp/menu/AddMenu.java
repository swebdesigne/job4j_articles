package ood.isp.menu;

public class AddMenu implements IScheduler {
    private static final int COUNT_ANSWER = 2;
    private static final ActionDelegate STUB_ACTION = System.out::println;

    @Override
    public String title() {
        return "Add menu:";
    }

    @Override
    public void execute(TODOApp app) {
        System.out.println(
                "Please to point the parent category for element of menu: "
                        + "\n\t1. ROOT:"
                        + "\n\t2. Select from the exists categories:"
        );
        String ans = app.getScanner().nextLine();
        if (!app.validate(ans, COUNT_ANSWER)) {
            execute(app);
        }
        String child = "";
        if (Integer.parseInt(ans) == 1) {
            System.out.println("Please add name category: ");
            child = app.getScanner().nextLine();
            app.add(Menu.ROOT, child, STUB_ACTION);
        } else if (Integer.parseInt(ans) == 2) {
            System.out.println("Please point the name parent category: ");
            String parent = app.getScanner().nextLine();
            System.out.println("Please point the name child element: ");
            child = app.getScanner().nextLine();
            app.add(parent, child, STUB_ACTION);
        }
        app.run();
    }
}
