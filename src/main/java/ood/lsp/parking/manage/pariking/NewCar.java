package ood.lsp.parking.manage.pariking;

import ood.lsp.parking.CargoCar;
import ood.lsp.parking.IVehicle;
import ood.lsp.parking.StartUI;
import ood.lsp.parking.PassengerCar;

public class NewCar implements IManage {

    public static int random(int to) {
        return (int) (Math.random() * to);
    }

    public IVehicle createCar() {
        String letters = "ACIDIFY";
        int random = random(2);
        StringBuilder numberCar = new StringBuilder();
        numberCar.append(random(9))
                .append(random(9))
                .append(random(9))
                .append(letters.charAt(random(7)))
                .append(letters.charAt(random(7)))
                .append(letters.charAt(random(7)));
        if (random == 1) {
            return new PassengerCar(1, numberCar.toString());
        }
        return new CargoCar(2, numberCar.toString());
    }

    @Override
    public String msg() {
        return "Create a new car.";
    }

    @Override
    public void execute(StartUI manage) {
        IVehicle car = createCar();
        System.out.printf("New car is created:[Number: %s, Parking size: %s]\n",
                car.getNumber(), car.sizeParkingPlace()
        );
        manage.setVehicle(car);
        manage.run();
    }
}
