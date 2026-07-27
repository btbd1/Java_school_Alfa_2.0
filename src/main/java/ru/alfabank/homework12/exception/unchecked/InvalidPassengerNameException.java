package ru.alfabank.homework12.exception.unchecked;

public class InvalidPassengerNameException extends ValidationException {
  public InvalidPassengerNameException(String reason) {
    super("Некорректное имя пассажира: " + reason);
  }
}
