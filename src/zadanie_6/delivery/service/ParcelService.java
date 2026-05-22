package zadanie_6.delivery.service;

import zadanie_6.delivery.model.Parcel;

public class ParcelService {

  public void printParcelsReport(Parcel[] parcels){
    for (int i = 0; i < parcels.length; i++) {
      Parcel parcel = parcels[i];

      // информация о посылке
      parcel.printInfo();

      // стоимость доставки
      System.out.println("Стоимость доставки: " + parcel.calculateDeliveryPrice());

      System.out.println();
    }
  }
}
