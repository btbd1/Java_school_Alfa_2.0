package zadanie_6.delivery.model;

public class ExpressParcel extends Parcel {

  private int deliveryHours;

  public ExpressParcel(String recipient, String address, double weight, String trackNumber,int deliveryHours){
    super(recipient, address, weight, trackNumber);
    this.deliveryHours = deliveryHours;
  }

  public double calculateDeliveryPrice(){
    double basePrice = super.calculateDeliveryPrice();
    if (deliveryHours < 24) {
      return basePrice + 500;
    } else {
      return basePrice;
    }
  }

  public void printInfo(){
    super.printInfo();
    System.out.println("Delivery deadline: " + deliveryHours);
  }
}
