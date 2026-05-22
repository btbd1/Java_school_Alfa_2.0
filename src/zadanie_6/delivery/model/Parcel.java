package zadanie_6.delivery.model;

public class Parcel {

  // поля
  private String recipient;
  private String address;
  protected double weight;
  String trackNumber;

  // конструкторы
  public Parcel(String recipient, String address, double weight, String trackNumber){
    this.recipient = recipient;
    this.address = address;
    this.weight = weight;
    this.trackNumber = trackNumber;
  }

  public Parcel(){
  }

  // геттеры
  public String getRecipient() {
    return recipient;
  }

  public String getAddress() {
    return address;
  }

  public double getWeight() {
    return weight;
  }

  // сеттеры
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  // методы
  public double calculateDeliveryPrice(){
    return 100 + (weight * 30);
  }

  public void printInfo(){
    System.out.println("Получатель: " + getRecipient());
    System.out.println("Адрес: " + getAddress());
    System.out.println("Вес: " + getWeight());
    System.out.println("Трек-номер: " + trackNumber);
  }

}
