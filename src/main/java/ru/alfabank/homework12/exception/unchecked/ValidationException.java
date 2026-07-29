package ru.alfabank.homework12.exception.unchecked;

public class ValidationException extends RuntimeException {
  public ValidationException(String message) {
    super(message);
  }
}