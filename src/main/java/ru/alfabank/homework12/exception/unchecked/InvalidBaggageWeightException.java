package ru.alfabank.homework12.exception.unchecked;

public class InvalidBaggageWeightException extends ValidationException {
  private final int invalidWeight;

  public InvalidBaggageWeightException(int invalidWeight) {
    super("Некорректный вес багажа: " + invalidWeight + " кг. Вес должен быть положительным числом.");
    this.invalidWeight = invalidWeight;
  }

  public int getInvalidWeight() {
    return invalidWeight;
  }
}
