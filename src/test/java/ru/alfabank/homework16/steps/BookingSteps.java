package ru.alfabank.homework16.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class BookingSteps {

  @Допустим("в ресторане есть столик номер {int} вместимостью {int}")
  public void вРесторанеЕстьСтоликНомерВместимостью(int tableNumber, int capacity) {
    System.out.println("Добавлен столик #" + tableNumber + " вместимостью " + capacity + " человек");
  }

  @Допустим("гость забронировал столик номер {int}")
  public void гостьЗабронировалСтоликНомер(int tableNumber) {
    System.out.println("Столик #" + tableNumber + " забронирован");
  }

  @Когда("гость бронирует столик на {int} человек")
  public void гостьБронируетСтоликНаКоличествоЧеловек(int guestsCount) {
    System.out.println("Попытка бронирования на " + guestsCount + " человек");
  }

  @Тогда("бронь успешно создана")
  public void броньУспешноСоздана() {
    System.out.println("Бронь успешно создана");
  }

  @Тогда("бронь не создана, подходящих столиков нет")
  public void броньНеСозданаПодходящихСтоликовНет() {
    System.out.println("Бронь не создана - подходящих столиков нет");
  }

  @Тогда("столик номер {int} забронирован")
  public void столикНомерЗабронирован(int tableNumber) {
    System.out.println("Столик #" + tableNumber + " забронирован");
  }

  @Когда("гость отменяет бронь столика номер {int}")
  public void гостьОтменяетБроньСтолика(int tableNumber) {
    System.out.println("Отмена брони столика #" + tableNumber);
  }

  @Тогда("бронь успешно отменена")
  public void броньУспешноОтменена() {
    System.out.println("Бронь успешно отменена");
  }


  @Тогда("столик номер {int} свободен")
  public void столикНомерСвободен(int tableNumber) {
    System.out.println("Столик #" + tableNumber + " свободен");
  }

  // Data Table
  @Допустим("в ресторане есть столики:")
  public void вРесторанеЕстьСтолики(DataTable dataTable) {
    List<Map<String, String>> tables = dataTable.asMaps(String.class, String.class);
    System.out.println("Добавление столиков через таблицу:");
    for (Map<String, String> table : tables) {
      String number = table.get("номер");
      String capacity = table.get("вместимость");
      System.out.println("  Столик #" + number + " вместимостью " + capacity + " человек");
    }
  }

  // Doc String
  @Когда("гость оставляет пожелание к брони:")
  public void гостьОставляетПожеланиеКБрони(String wish) {
    System.out.println("Получено пожелание от гостя:");
    System.out.println(wish);
  }

  @Тогда("пожелание сохранено")
  public void пожеланиеСохранено() {
    System.out.println("Пожелание сохранено в системе");
  }

  // Scenario Outline
  @Тогда("результат бронирования: {word}")
  public void результатБронирования(String result) {
    System.out.println("Результат бронирования: " + result);
    if (result.equals("успешно")) {
      System.out.println("Бронь успешно создана");
    } else if (result.equals("отказ")) {
      System.out.println("Бронь не создана, подходящих столиков нет");
    }
  }
}
