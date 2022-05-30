package ood.lsp.parking;

import ood.lsp.parking.console.ConsoleInput;
import ood.lsp.parking.manage.pariking.*;

import java.util.List;
import java.util.stream.IntStream;

public class StartUI {
    private IVehicle vehicle;
    private final List<IManage> control;
    private final Parking<IVehicle> parking;

    public StartUI(List<IManage> control, Parking<IVehicle> parking) {
        this.control = control;
        this.parking = parking;
    }

    public IVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Parking<IVehicle> parking() {
        return parking;
    }

    public void run() {
        showMenu();
        String input = ConsoleInput.askStr();
        if (!ConsoleInput.validate(input, control.size())) {
            run();
        } else {
            control.get(ConsoleInput.askInt(input)).execute(this);
        }
    }

    private void showMenu() {
        IntStream.range(0, control.size())
                .forEach(index -> System.out.printf("%s. %s\n", index, control.get(index).msg()));
    }

    public static void main(String[] args) {
        List<IManage> control = List.of(
                new NewCar(),
                new AvailablePlace(),
                new SelectParking(),
                new Exit()
        );
        StartUI parkingManage = new StartUI(control, new Parking<>(3, 4));
        parkingManage.run();
    }
}