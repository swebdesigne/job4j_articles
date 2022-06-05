package ood.lsp.parking;

public class CargoCar implements IVehicle {
     private final int sizeParkingPlace;
     private final String number;

     public CargoCar(int sizeParkingPlace, String number) {
          this.sizeParkingPlace = sizeParkingPlace;
          this.number = number;
     }

     @Override
     public int sizeParkingPlace() {
          return sizeParkingPlace;
     }

     public String getNumber() {
          return number;
     }
}
