package ru.alfabank.homework13;


import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import main.java.ru.alfabank.homework13.Alien;
import main.java.ru.alfabank.homework13.MissionReport;

public class Main {

  public static void main(String[] args) {
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));  // настройка для вывода кириллицы

    ArrayList<Alien> aliens = new ArrayList<>();

    Alien alien1 = new Alien("Зигмунд", "Марс", 5);
    Alien alien2 = new Alien("Коннор", "Венера", 3);
    Alien alien3 = new Alien("Зигмунд", "Марс", 8);
    Alien alien4 = new Alien("Питер", "Юпитер", 9);
    Alien alien5 = new Alien("Зигмунд", "Венера", 2);

    aliens.add(alien1);
    aliens.add(alien2);
    aliens.add(alien3);
    aliens.add(alien4);
    aliens.add(alien5);

    System.out.println("Список пришельцев:");
    for (Alien alien : aliens) {
      System.out.println(alien);
    }
    System.out.println("Всего пришельцев: " + aliens.size());
    System.out.println();

    System.out.println("Проверка на дубликаты:");
    checkForDuplicates(aliens);
  }

  private static void checkForDuplicates(ArrayList<Alien> list) {
    Set<Alien> seen = new HashSet<>();
    Set<Alien> duplicates = new HashSet<>();

    for (Alien alien : list) {
      if (!seen.add(alien)) {
        duplicates.add(alien);
      }
    }

    if (duplicates.isEmpty()) {
      System.out.println("Дубликатов не найдено!");
    } else {
      System.out.println("Найдены дубликаты:");
      for (Alien duplicate : duplicates) {
        System.out.println("  " + duplicate);
        System.out.println("  (встречается несколько раз в списке)");
      }
    }

    // формирование отрядов
    SquadManager squadManager = new SquadManager();
    squadManager.demonstrateListCreations();

    // отсеивание трусов
    ArrayList<String> squad = new ArrayList<>();
    squad.add("Алексей");
    squad.add("Трус Петя");
    squad.add("Дмитрий");
    squad.add("Трус Вася");
    squad.add("Сергей");

    System.out.println("Создан отряд:");
    for (String name : squad) {
      System.out.println("  - " + name);
    }
    System.out.println();

    squadManager.filterOutCowards(squad);

    System.out.println();

    // Бонус: демонстрация альтернативного метода
        /*
        System.out.println("ДЕМОНСТРАЦИЯ REMOVEIF()");
        ArrayList<String> squad2 = new ArrayList<>();
        squad2.add("Иван");
        squad2.add("Трус Андрей");
        squad2.add("Петр");
        squad2.add("Трус Степан");
        squad2.add("Михаил");
        squadManager.filterOutCowardsWithRemoveIf(squad2);
        */

    // работа с очередью

    AssaultQueue queue = new AssaultQueue();

    queue.addRecruit("Штурмовик-1");
    queue.addRecruit("Штурмовик-2");
    queue.addRecruit("Штурмовик-3");
    queue.addRecruit("Штурмовик-4");
    queue.addRecruit("Штурмовик-5");
    System.out.println();

    queue.printQueue();
    System.out.println();

    // Удаляем 2 человек
    System.out.println("Уходит первый: " + queue.retreatCoward());
    System.out.println("Уходит второй: " + queue.retreatCoward());
    System.out.println();

    queue.printQueue();
    System.out.println();

    // Добавляем 3 новых
    queue.addRecruit("Штурмовик-6");
    queue.addRecruit("Штурмовик-7");
    queue.addRecruit("Штурмовик-8");

    System.out.println("\nИТОГИ");
    queue.printQueue();
    System.out.println();

    // System.out.println("toString(): " + queue);

    System.out.println("ОТЧЕТЫ КОМАНДОВАНИЮ");
    // Список пойманных пришельцев
    ArrayList<Alien> captured = new ArrayList<>();
    captured.add(new Alien("Зигмунд", "Марс", 5));
    captured.add(new Alien("Коннор", "Венера", 3));
    captured.add(new Alien("Август", "Юпитер", 9));

    // первый отчёт
    MissionReport report1 = new MissionReport(
        "Штурм Зоны 51",
        captured,
        50
    );

    System.out.println("ОТЧЁТ №1:");
    System.out.println(report1);
    System.out.println();

    // второй отчёт с теми же данными
    ArrayList<Alien> captured2 = new ArrayList<>();
    captured2.add(new Alien("Зигмунд", "Марс", 5));
    captured2.add(new Alien("Коннор", "Венера", 3));
    captured2.add(new Alien("Август", "Юпитер", 9));

    MissionReport report2 = new MissionReport(
        "Штурм Зоны 51",
        captured2,
        50
    );

    System.out.println("ОТЧЁТ №2 (с теми же данными):");
    System.out.println(report2);
    System.out.println();

    // Сравниваем отчёты
    System.out.println("Сравнение через == : " + (report1 == report2));
    System.out.println("Сравнение через equals() : " + report1.equals(report2));
  }
}
