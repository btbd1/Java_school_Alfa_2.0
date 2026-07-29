package ru.alfabank.homework12;

import ru.alfabank.homework12.exception.checked.*;
import ru.alfabank.homework12.exception.unchecked.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) {

    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));  // настройка для вывода кириллицы

      // 1. Подготовка данных
    String[] flights = {"SU-123", "TK-777", "KC-909", "AE-404"};
    BaggageDropDesk desk = new BaggageDropDesk(flights);

    // 2. Вывод заголовка
    printHeader(flights);

    // 3. Массив сценариев: [имя_сценария, имя_пассажира, рейс, вес]
    Object[][] scenarios = {
        {"Успешная сдача багажа", "Иван Петров", "SU-123", 18},
        {"Рейс не существует", "Мария Смирнова", "XX-999", 15},
        {"Багаж слишком тяжелый", "Алексей Иванов", "TK-777", 35},
        {"Проблема с печатью бирки", "Елена Кузнецова", "AE-404", 20},
        {"Некорректное имя (null)", null, "SU-123", 18},
        {"Некорректный вес (отрицательный)", "Ольга Соколова", "KC-909", -10}
    };

    // 4. Цикл по всем сценариям
          for (int i = 0; i < scenarios.length; i++) {
      Object[] scenario = scenarios[i];
      String scenarioName = (String) scenario[0];
      String passengerName = (String) scenario[1];
      String flightNumber = (String) scenario[2];
      int weight = (int) scenario[3];

      System.out.println("СЦЕНАРИЙ " + (i + 1) + ": " + scenarioName);
      System.out.println("----------------------------------------");

      // 5. try-catch блок для всех сценариев
      try {
        BaggageTicket ticket = desk.checkInBaggage(passengerName, flightNumber, weight);
        System.out.println("РЕЗУЛЬТАТ: Багаж успешно зарегистрирован!");
        System.out.println("Бирка: " + ticket);

      } catch (InvalidPassengerNameException e) {
        System.out.println("Ошибка валидации имени: " + e.getMessage());

      } catch (InvalidBaggageWeightException e) {
        System.out.println("Ошибка валидации веса: " + e.getMessage());
        System.out.println("Детали: получен вес " + e.getInvalidWeight() + " кг");
        System.out.println("Вес должен быть положительным");


      } catch (FlightNotFoundException e) {
        System.out.println("Ошибка валидации рейса: " + e.getMessage());
        System.out.println("Рекомендация: Попросите пассажира проверить номер рейса");
        System.out.print("Доступные рейсы: ");
        for (String flight : flights) {
          System.out.print(flight + " ");
        }
        System.out.println();

      } catch (OverweightBaggageException e) {
        System.out.println("Ошибка перевеса: " + e.getMessage());
        int extraWeight = e.getWeight() - e.getMaxWeight();
        int fee = extraWeight * 500;
        System.out.println("Фактический вес: " + e.getWeight() + " кг");
        System.out.println("Максимальный вес: " + e.getMaxWeight() + " кг");
        System.out.println("Перевес: " + extraWeight + " кг");
        System.out.println("Доплата: " + fee + " рублей");

      } catch (BaggageTagPrintException e) {
        System.out.println("Ошибка печати: " + e.getMessage());
        System.out.println("Проверьте наличие бумаги в принтере");
        System.out.println("Проверьте наличие чернил");
        System.out.println("Попробуйте напечатать бирку снова");
        System.out.println("Если проблема повторяется, используйте резервный принтер");

      } catch (AirportServiceException e) {
        System.out.println("Общая ошибка сервиса: " + e.getMessage());
      }

      printSeparator();
    }

  }

  // Вспомогательные методы
  private static void printHeader(String[] flights) {
    System.out.println("╔══════════════════════════════════════════════════════════════╗");
    System.out.println("║           СТОЙКА ПРИЁМА БАГАЖА                               ║");
    System.out.println("╚══════════════════════════════════════════════════════════════╝");
    System.out.print("Доступные рейсы: ");
    for (String flight : flights) {
      System.out.print(flight + " ");
    }
    System.out.println("\nМаксимальный вес багажа: 23 кг\n");
    System.out.println("════════════════════════════════════════════════════════════════\n");
  }

  private static void printSeparator() {
    System.out.println("\n" + "═".repeat(60) + "\n");
  }

}
