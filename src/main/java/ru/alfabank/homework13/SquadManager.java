package ru.alfabank.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;


public class SquadManager {
  public void demonstrateListCreations() {

    // Способ 1: new ArrayList<>() - полностью изменяемый список
    System.out.println("1. ОСНОВНОЙ ОТРЯД (new ArrayList<>())");
    List<String> mainSquad = new ArrayList<>();
    mainSquad.add("Штурмовик-1");
    mainSquad.add("Штурмовик-2");
    mainSquad.add("Штурмовик-3");
    mainSquad.add("Штурмовик-4");
    System.out.println("Создан основной отряд: " + mainSquad);
    System.out.println("Размер: " + mainSquad.size());
    System.out.println("Тип списка: " + mainSquad.getClass().getSimpleName());
    System.out.println();

    // Способ 2: Arrays.asList() - частично изменяемый (фиксированный размер)
    System.out.println("2. ОТРЯД ПОДДЕРЖКИ (Arrays.asList())");
    List<String> supportSquad = Arrays.asList("Поддержка-1", "Поддержка-2", "Поддержка-3");
    System.out.println("Создан отряд поддержки: " + supportSquad);
    System.out.println("Размер: " + supportSquad.size());
    System.out.println("Тип списка: " + supportSquad.getClass().getSimpleName());
    System.out.println();

    // Способ 3: List.of() - полностью неизменяемый (Java 9+)
    System.out.println("3. ЭЛИТНЫЙ ОТРЯД (List.of())");
    List<String> eliteSquad = List.of("Элита-1", "Элита-2");
    System.out.println("Создан элитный отряд: " + eliteSquad);
    System.out.println("Размер: " + eliteSquad.size());
    System.out.println("Тип списка: " + eliteSquad.getClass().getSimpleName());
    System.out.println();

    System.out.println("Изменение: ОСНОВНОЙ ОТРЯД (new ArrayList<>())");
    testAddOperation(mainSquad, "Новый штурмовик");
    testRemoveOperation(mainSquad, "Штурмовик-1");
    System.out.println("Текущее состояние: " + mainSquad);
    System.out.println();


    System.out.println("Изменение: ОТРЯД ПОДДЕРЖКИ (Arrays.asList())");
    testAddOperation(supportSquad, "Поддержка-4");
    testRemoveOperation(supportSquad, "Поддержка-1");
    System.out.println("Текущее состояние: " + supportSquad);
    System.out.println();

    System.out.println("Изменение: ЭЛИТНЫЙ ОТРЯД (List.of())");
    testAddOperation(eliteSquad, "Элита-3");
    testRemoveOperation(eliteSquad, "Элита-1");
    System.out.println("Текущее состояние: " + eliteSquad);
    System.out.println();
  }

  // тестирование добавления элементов
  private void testAddOperation(List<String> list, String element) {
    System.out.print("Попытка добавить '" + element + "': ");
    try {
      list.add(element);
      System.out.println("УСПЕШНО! Элемент добавлен");
    } catch (UnsupportedOperationException e) {
      System.out.println("ОШИБКА: UnsupportedOperationException - " + e.getMessage());
    } catch (Exception e) {
      System.out.println("ОШИБКА: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
  }

  // тестирование удаления элементов
  private void testRemoveOperation(List<String> list, String element) {
    System.out.print("Попытка удалить '" + element + "': ");
    try {
      boolean removed = list.remove(element);
      if (removed) {
        System.out.println("УСПЕШНО! Элемент удален");
      } else {
        System.out.println("Элемент не найден в списке!");
      }
    } catch (UnsupportedOperationException e) {
      System.out.println("ОШИБКА: UnsupportedOperationException - " + e.getMessage());
    } catch (Exception e) {
      System.out.println("ОШИБКА: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
  }

  // фильтрация элементов
  public void filterOutCowards(List<String> squad) {
    System.out.println("ФИЛЬТРАЦИЯ ОТРЯДА\n");

    System.out.println("Отряд ДО фильтрации (" + squad.size() + " бойцов):");
    printSquadWithNumbers(squad);
    System.out.println();

    Iterator<String> iterator = squad.iterator();
    int removedCount = 0;

    while (iterator.hasNext()) {
      String name = iterator.next();
      if (name.startsWith("Трус")) {
        iterator.remove();
        removedCount++;
      }
    }

    System.out.println("\nУдалено бойцов: " + removedCount);
    System.out.println("Осталось бойцов: " + squad.size());
    System.out.println();
    System.out.println("Отряд ПОСЛЕ фильтрации: ");
    printSquadWithNumbers(squad);
  }

  // ФИЛЬТРАЦИЯ ЧЕРЕЗ REMOVEIF()
  public void filterOutCowardsWithRemoveIf(List<String> squad) {
    System.out.println("Отряд ДО фильтрации:");
    printSquadWithNumbers(squad);
    System.out.println();

    int sizeBefore = squad.size();
    boolean removed = squad.removeIf(name -> name.startsWith("Трус"));

    int removedCount = sizeBefore - squad.size();
    System.out.println("Удалено бойцов: " + removedCount);
    System.out.println("Осталось бойцов: " + squad.size());
    System.out.println();

    System.out.println("Отряд ПОСЛЕ фильтрации: ");
    printSquadWithNumbers(squad);
  }

  // вывод списка после фильтрации
  private void printSquadWithNumbers(List<String> squad) {
    if (squad.isEmpty()) {
      System.out.println("  (отряд пуст)");
      return;
    }

    for (int i = 0; i < squad.size(); i++) {
      String name = squad.get(i);
      System.out.println((i + 1) + ". " + name);
    }
  }
}
