package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;

import java.io.IOException;
import java.util.Arrays;

public class AvailablePlace implements IManage {
    @Override
    public String msg() {
        return "Available place.";
    }

    @Override
    public void execute(StartUI manage) throws IOException {
        Arrays.stream(manage.parking().availablePlace()).forEach(System.out::println);
    }
}
