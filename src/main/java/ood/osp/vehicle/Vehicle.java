package ood.osp.vehicle;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Vehicle {
   public List<Car> findVehicle(List<Car> car, Predicate<Car> carPredicate) {
        return car.stream().filter(carPredicate).collect(Collectors.toList());
   }
}
