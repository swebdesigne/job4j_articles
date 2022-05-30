package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.StartUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AvailablePlace implements IManage {
    @Override
    public String msg() {
        return "All available place.";
    }

    @Override
    public void execute(StartUI ui) {
        IntStream.range(0, ui.parking().allAvailablePlace().length).forEach(
                index -> {
                    String places = ui.parking().allAvailablePlace()[index];
                    System.out.printf("Parking № %s: %s\n", index, places.equals("[]") ? "no available place" : places);
                }
        );
        ui.run();
    }
}
