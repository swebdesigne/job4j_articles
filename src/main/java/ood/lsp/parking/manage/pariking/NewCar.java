package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.CargoCar;
import ood.lsp.parking.IVehicle;
import ood.lsp.parking.StartUI;
import ood.lsp.parking.PassengerCar;

public class NewCar implements IManage {
    private int random(int to) {
        return (int) (Math.random() * to);
    }

    private IVehicle createCar() {
        String numberCar = "";
        int random = random(2);
        String letters = "ACIDIFY";
        numberCar += random(9);
        numberCar += random(9);
        numberCar += random(9);
        numberCar += letters.charAt(random(7));
        numberCar += letters.charAt(random(7));
        numberCar += letters.charAt(random(7));
        if (random == 1) {
            return new PassengerCar(1, numberCar);
        }
        return new CargoCar(2, numberCar);
    }

    @Override
    public String msg() {
        return "Create a new car.";
    }

    @Override
    public void execute(StartUI ui) {
        IVehicle car = createCar();
        System.out.printf("New car is created: [Number: %s, Parking size: %s]\n",
                car.getNumber(), car.sizeParkingPlace()
        );
        ui.setVehicle(car);
        ui.run();
    }
}
