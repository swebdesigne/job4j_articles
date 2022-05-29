package ood.lsp.parking;

import ood.lsp.parking.manage.pariking.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StartUI {
    private IVehicle vehicle;
    private final List<IManage> manages;
    private final Parking<IVehicle> parking;
    Scanner scanner = new Scanner(System.in);

    public StartUI(List<IManage> manages, Parking<IVehicle> parking) {
        this.manages = manages;
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
        String input;
        showMenu();
        input = ask();
        validate(input);
        try {
            manages.get(Integer.parseInt(input)).execute(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validate(String input) {
        try {
            int ask = Integer.parseInt(input);
            if (ask < 0 || ask >= manages.size()) {
                System.out.println("Wrong input, you can select: 0 .. " + (manages.size() - 1));
                run();
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, input must be a number  from 0 to " + (manages.size() - 1));
            run();
        }
    }

    private void showMenu() {
        IntStream.range(0, manages.size())
                .forEach(index -> System.out.printf("%s. %s\n", index, manages.get(index).msg()));
    }

    public String ask() {
        return scanner.nextLine();
    }

    public void stop() {
        scanner.close();
    }

    public static void main(String[] args) {
        List<IManage> manages = List.of(
                new NewCar(),
                new AvailablePlace(),
                new SelectParking(),
                new Exit()
        );
        StartUI parkingManage = new StartUI(manages, new Parking<>(3, 4));
        parkingManage.run();
//        IVehicle passenger = new PassengerCar(1, "123k");
//        Parking<IVehicle> parking = new Parking<>(3, 4);
//        parking.accept(passenger);
    }
}


//        parking.takeParkingPlace(2);
//        parking.takeParkingPlace(3);
//        Arrays.stream(parking.pairAvailableParkingPlace()).forEach(System.out::println);
//        System.out.println(parking.getFullCapacity());
//        parking.takePairPlaceForCargoCarInPassengerParking(parking.pairAvailableParkingPlace()[0]);
//        Arrays.stream(parking.occupiedPlace()).forEach(System.out::println);
//        Arrays.stream(parking.availablePlace()).forEach(System.out::println);

