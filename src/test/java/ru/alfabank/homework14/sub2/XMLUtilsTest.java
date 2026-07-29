package ru.alfabank.homework14.sub2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class XMLUtilsTest {

  @Test
  void testCreateEmptyElementWithValidTag() {
    // Arrange
    String tagName = "user";
    String expected = "<user></user>";

    // Act
    String actual = XMLUtils.createEmptyElement(tagName);

    // Assert
    assertEquals(expected, actual, "Метод должен возвращать корректный XML-тег для валидного названия");
  }

  @Test
  void testCreateEmptyElementWithNullTag() {
    // Arrange
    String tagName = null;
    String expected = "<invalid/>";

    // Act
    String actual = XMLUtils.createEmptyElement(tagName);

    // Assert
    assertEquals(expected, actual, "При передаче null метод должен возвращать <invalid/>");
  }

  @Test
  void testCreateEmptyElementWithEmptyString() {
    // Arrange
    String tagName = "";
    String expected = "<invalid/>";

    // Act
    String actual = XMLUtils.createEmptyElement(tagName);

    // Assert
    assertEquals(expected, actual, "При передаче пустой строки метод должен возвращать <invalid/>");
  }
}
