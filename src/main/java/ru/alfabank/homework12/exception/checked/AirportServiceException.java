package ru.alfabank.homework12.exception.checked;

public class AirportServiceException extends Exception {

  public AirportServiceException(String message) {
    super(message);
  }

  public AirportServiceException(String message, Throwable cause) {
    super(message, cause);
  }

}