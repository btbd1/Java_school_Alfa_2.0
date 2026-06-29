package zadanie_11;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class App {

  public static void main(String[] args) {
    // Установка кодировки для вывода
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

    CoffeeMachine machine = new CoffeeMachine();
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println("Введите количество воды в мл: ");
      int waterAmount = scanner.nextInt();
    }
    catch (InputMismatchException e){
      System.out.println("Ошибка: нужно ввести число");
    }
    scanner.close();

    try {
      machine.makeCoffee(100);
    }
    catch (NotEnoughWaterException e){
      System.out.println(e.getMessage());
    }
    finally {
      System.out.println("Проверка кофемашины завершена.");
    }

    try {
      machine.calculateCups(1000, 0);
    }
    catch (ArithmeticException e){
      System.out.println("Ошибка: размер чашки не может быть 0");
    }

    String x = null;

    try {
      machine.printCoffeeName(x);
    }
    catch (NullPointerException e){
      System.out.println("Ошибка: название кофе отсутствует");
    }

  }
}
