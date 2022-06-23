package ood.lsp.parking;

public class CargoCar extends AbstractVehicle {
     public CargoCar(int sizeParkingPlace, String number) {
          super(sizeParkingPlace, number);
          if (sizeParkingPlace <= PassengerCar.SIZE) {
               throw new IllegalArgumentException("Size of the parking place should be more than `SIZE`");
          }
     }
}
