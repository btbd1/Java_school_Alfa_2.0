package ru.alfabank.homework14.sub2;

public class XMLUtils {
  public static String createEmptyElement(String tagName) {
    if (tagName == null || tagName.isEmpty()) {
      return "<invalid/>";
    }
    return "<" + tagName + "></" + tagName + ">";
  }
}
