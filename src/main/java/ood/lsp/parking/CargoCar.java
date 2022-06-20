package ood.lsp.parking;

import java.util.Objects;

public class CargoCar implements IVehicle {
     private final int sizeParkingPlace;
     private final String number;

     public CargoCar(int sizeParkingPlace, String number) {
          if (sizeParkingPlace <= PassengerCar.SIZE) {
               throw new IllegalArgumentException("Size of the parking place should be more than `SIZE`");
          }
          this.sizeParkingPlace = sizeParkingPlace;
          this.number = number;
     }

     @Override
     public int getSizeParkingPlace() {
          return sizeParkingPlace;
     }

     public String getNumber() {
          return number;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) {
               return true;
          }
          if (o == null || getClass() != o.getClass()) {
               return false;
          }
          CargoCar car = (CargoCar) o;
          return sizeParkingPlace == car.sizeParkingPlace && Objects.equals(number, car.number);
     }

     @Override
     public int hashCode() {
          return Objects.hash(sizeParkingPlace, number);
     }
}
