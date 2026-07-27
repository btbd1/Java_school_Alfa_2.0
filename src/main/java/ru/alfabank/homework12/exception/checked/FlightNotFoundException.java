package ru.alfabank.homework12.exception.checked;

public class FlightNotFoundException extends AirportServiceException {
  public FlightNotFoundException(String flightNumber) {
    super("Рейс " + flightNumber + " не найден в расписании");
  }
}
