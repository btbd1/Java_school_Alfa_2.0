package main.java.ru.alfabank.homework15;

public class BoardGame {
  private String name;
  private int minAge;
  private int rentalCost;
  private boolean rented;

  public BoardGame(String name, int minAge, int rentalCost) {
    validateName(name);
    validateMinAge(minAge);
    validateRentalCost(rentalCost);

    this.name = name;
    this.minAge = minAge;
    this.rentalCost = rentalCost;
    this.rented = false;
  }


  private void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Название не может быть null или пустым");
    }
  }

  private void validateMinAge(int minAge) {
    if (minAge < 0) {
      throw new IllegalArgumentException("Минимальный возраст не может быть отрицательным");
    }
  }

  private void validateRentalCost(double rentalCost) {
    if (rentalCost <= 0) {
      throw new IllegalArgumentException("Стоимость аренды должна быть положительной");
    }
  }

  public String getName() {
    return name;
  }
  public int getMinAge() {
    return minAge;
  }
  public int getRentalCost() {
    return rentalCost;
  }

  public boolean isRented() {
    return rented;
  }

  public void setRented(boolean rented) {
    this.rented = rented;
  }

  public boolean canBeRentedBy(int age) {
    return age >= minAge;
  }

}
