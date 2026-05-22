package zadanie_6.delivery.app;

import zadanie_6.delivery.model.Parcel;
import zadanie_6.delivery.model.FragileParcel;
import zadanie_6.delivery.model.ExpressParcel;
import zadanie_6.delivery.service.ParcelService;

public class Main {
  public static void main(String[] args) {
    // обычная посылка
    Parcel baseParcel = new Parcel("В. Ленин", "Москва, Красная площадь 15", 12.5, "MSK123456");

    // хрупкая посылка
    FragileParcel fragileParcel = new FragileParcel("Е. Великая", "Санкт-Петербург, Дворцовая площадь 1", 1.25, "SPB789012", true);

    // экспресс-посылка
    ExpressParcel expressParcel = new ExpressParcel("К. Минин", "Нижний Новгород, площадь Минина 10", 3.0, "NN345678", 12);

    // посылка через конструктор без аргументов
    Parcel justParcel = new Parcel();
    justParcel.setRecipient("А. Козлова");
    justParcel.setAddress("Екатеринбург, ул. Малышева 50");
    justParcel.setWeight(1.5);

    // массив из посылок
    Parcel[] parcels = { baseParcel, fragileParcel, expressParcel, justParcel};

    // объект ParcelService
    ParcelService parcelService = new ParcelService();

    // метод printParcelsReport
    parcelService.printParcelsReport(parcels);

  }
}
