package ood.srp.designe.srp.ocp;

import java.util.List;

public class CarsInheritance {
    private static class Car {
        public String sound() {
            return "beep-beep";
        }
    }

    private static class NoSoundCar  extends Car {
        @Override
        public String sound() {
            return "Sound not exists";
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car(), new Car());
        cars.forEach(x -> System.out.println(x.sound()));
        System.out.println(System.lineSeparator());
        List<NoSoundCar> noSoundCars = List.of(new NoSoundCar(), new NoSoundCar());
        noSoundCars.forEach(x -> System.out.println(x.sound()));
        System.out.println(System.lineSeparator());
        System.out.println(new CarsInheritance.Car().sound());
    }
}
