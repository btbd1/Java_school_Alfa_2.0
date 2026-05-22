package zadanie_6.delivery.model;

public class FragileParcel extends Parcel {

  private boolean requiresCarefulHandling;

  // конструктор
  public FragileParcel(String recipient, String address, double weight, String trackNumber, boolean requiresCarefulHandling){
    super(recipient, address, weight, trackNumber);
    this.requiresCarefulHandling = requiresCarefulHandling;
  }

  // методы
  public double calculateDeliveryPrice(){
    return super.calculateDeliveryPrice() + 200;
  }

  public void printInfo(){
    super.printInfo();
    System.out.println("Handle with care: " + requiresCarefulHandling);
  }
}
