import java.util.Arrays;

public class Zadanie3_1 {

  public static void main(String[] args) {

    String[] petyaBasket = {"курица", "бананы", "творог"};
    String[] kolyaBasket = {"курица", "бананы", "творог"};
    String[] terentiyBasket = {"пиво", "творог", "ласка магия черного"};

    // 1. сравнение кол-ва товаров
      // Петя и Коля
    if (petyaBasket.length > kolyaBasket.length) {
      System.out.println("У Пети больше товаров");
    } else if (petyaBasket.length < kolyaBasket.length) {
      System.out.println("У Коли больше товаров");
    } else {
      System.out.println("У Пети и Коли одинаковое количество товаров в корзине");
    }

    // Петя и Терентий
    if (petyaBasket.length > terentiyBasket.length) {
      System.out.println("У Пети больше товаров");
    } else if (petyaBasket.length < terentiyBasket.length) {
      System.out.println("У Терентия больше товаров");
    } else {
      System.out.println("У Пети и Терентия одинаковое количество товаров в корзине");
    }

    // 2. сравнение состава корзин
    // Петя и Коля
    if (Arrays.equals(petyaBasket, kolyaBasket)) {
      System.out.println("Товары у Пети и Коли в корзинах одинаковые");
    } else {
      System.out.println("Товары У Пети и Коли в корзинах разные");
    }

    // Петя и Терентий
    if ( Arrays.equals(petyaBasket, terentiyBasket)) {
      System.out.println("Товары у Пети и Терентия в корзинах одинаковые");
    } else {
      System.out.println("Товары у Пети и Терентия в корзинах разные");
    }

    // 3. Исследование названий

    String[][] allBaskets = {petyaBasket, kolyaBasket, terentiyBasket};

      // Самое длинное название
    String longestName = "";
    int    longestLen  = 0;

    for (String[] basket : allBaskets) {
      for (String item : basket) {
        if (item.length() > longestLen) {
          longestLen  = item.length();
          longestName = item;
        }
      }
    }
    System.out.println("Самое длинное название товара: " + longestName);

      // Самое короткое название
    String shortestName = allBaskets[0][0];
    int shortestLen  = shortestName.length();

    for (String[] basket : allBaskets) {
      for (String item : basket) {
        if (item.length() < shortestLen) {
          shortestLen  = item.length();
          shortestName = item;
        }
      }
    }
    System.out.println("Самое короткое название товара: " + shortestName);

    // Средняя длина названия товара
    int totalLen  = 0;
    int quantity  = 0;

    for (String[] basket : allBaskets) {
      for (String item : basket) {
        totalLen  += item.length();
        quantity += 1;
      }
    }
    double averageLen  = (double) totalLen / quantity;
    System.out.println("Средняя длина названия товара " + String.format("%.2f", averageLen) + " символов");
  }
}
