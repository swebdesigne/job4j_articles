package ood.isp.menu;

import ood.isp.menu.action.AddMenuAction;
import ood.isp.menu.action.ExitAction;
import ood.isp.menu.action.IAction;
import ood.isp.menu.action.ShowMenuAction;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TODOApp {
    private final Menu menu = new SimpleMenu();
    private final Map<String, IAction> scheduler;
    private final Scanner scanner = new Scanner(System.in);
    private final SimpleMenuPrinter printer = new SimpleMenuPrinter();

    public TODOApp(Map<String, IAction> scheduler) {
        this.scheduler = scheduler;
    }

    public void print(Menu menu) {
        printer.print(menu);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Menu getMenu() {
        return menu;
    }

    public void add(String parentName, String childName, ActionDelegate actionDelegate) {
        this.menu.add(parentName, childName, actionDelegate);
    }

    public void run() {
        showMenu();
        String ask = scanner.nextLine();
        if (validate(ask, scheduler.size())) {
            scheduler.get(ask).execute(this);
        } else {
            run();
        }
    }

    public void showMenu() {
        for (Map.Entry<String, IAction> entry : scheduler.entrySet()) {
            System.out.printf("%s. %s\n", entry.getKey(), entry.getValue().title());
        }
    }

    public boolean validate(String input, int size) {
        try {
            int ask = Integer.parseInt(input);
            if (ask < 1 || ask > size) {
                System.out.println("Wrong input, you can select: 1 .. " + (size));
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, input must be a number from 1 .. " + (size));
            return false;
        }
        return true;
    }

    public void close() {
        scanner.close();
    }

    public static void main(String[] args) {
        new TODOApp(
                new TreeMap<>(
                        Map.of(
                                "1", new AddMenuAction(),
                                "2", new ShowMenuAction(),
                                "3", new ExitAction()
                        )
                )
        ).run();
    }
}
