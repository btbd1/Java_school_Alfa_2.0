package ru.alfabank.homework12.exception.checked;

public class OverweightBaggageException extends AirportServiceException {
  private final int weight;
  private final int maxWeight;

  public OverweightBaggageException(int weight, int maxWeight) {
    super("Вес багажа " + weight + " кг превышает допустимый лимит " + maxWeight + " кг");
    this.weight = weight;
    this.maxWeight = maxWeight;
  }

  public int getWeight() {
    return weight;
  }

  public int getMaxWeight() {
    return maxWeight;
  }
}