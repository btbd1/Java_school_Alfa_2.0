package ru.alfabank.homework14.sub2;

public class XMLUtilsTestManual {

  public static void main(String[] args) {
    // Тест 1: валидный тег
    String result1 = XMLUtils.createEmptyElement("user");
    String expected1 = "<user></user>";
    if (result1.equals(expected1)) {
      System.out.println("Тест 1 пройден ✓");
    } else {
      System.out.println("Тест 1 провален! Ожидалось: " + expected1 + ", получено: " + result1);
    }

    // Тест 2: null
    String result2 = XMLUtils.createEmptyElement(null);
    String expected2 = "<invalid/>";
    if (result2.equals(expected2)) {
      System.out.println("Тест 2 пройден ✓");
    } else {
      System.out.println("Тест 2 провален! Ожидалось: " + expected2 + ", получено: " + result2);
    }

    // Тест 3: пустая строка
    String result3 = XMLUtils.createEmptyElement("");
    String expected3 = "<invalid/>";
    if (result3.equals(expected3)) {
      System.out.println("Тест 3 пройден ✓");
    } else {
      System.out.println("Тест 3 провален! Ожидалось: " + expected3 + ", получено: " + result3);
    }
  }
}
