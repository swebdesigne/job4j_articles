package ood.isp.menu;

import java.util.Optional;

public class SimpleMenuPrinter implements MenuPrinter {
    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        Optional<Menu> opMenu = Optional.of(menu);
        for (var temp : menu) {
            var count = temp.getNumber().split("\\.").length - 1;
            for (int i = 0; i < count; i++) {
                System.out.print(INDENT);
            }
            String out = temp.getNumber() + " " + temp.getName();
            System.out.println((count == 0 ? "" : " ") + out);
        }
    }
}
