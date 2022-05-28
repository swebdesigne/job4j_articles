package ood.lsp.parking;

public class CargoCar implements IVehicle {
     private final int sizeParkingPlace;

     public CargoCar(int sizeParkingPlace) {
          this.sizeParkingPlace = sizeParkingPlace;
     }

     @Override
     public int sizeParkingPlace() {
          return sizeParkingPlace;
     }
}
