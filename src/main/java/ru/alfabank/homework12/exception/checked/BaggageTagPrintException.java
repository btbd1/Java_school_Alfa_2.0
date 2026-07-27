package ru.alfabank.homework12.exception.checked;

public class BaggageTagPrintException extends AirportServiceException {
  public BaggageTagPrintException(String message) {
    super(message);
  }

  public BaggageTagPrintException(String message, Throwable cause) {
    super(message, cause);
  }
}
