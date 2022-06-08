package ood.lsp.parking;

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
}
