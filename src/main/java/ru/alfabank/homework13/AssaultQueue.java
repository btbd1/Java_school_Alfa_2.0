package ru.alfabank.homework13;

import java.util.LinkedList;

public class AssaultQueue {
  private LinkedList<String> queue;

  public AssaultQueue() {
    this.queue = new LinkedList<>();
  }

  // добавление в конец очереди
  public void addRecruit(String name) {
    queue.addLast(name);
    System.out.println("Добавлен штурмовик: " + name);
  }

  // удаление из начала очереди
  public String retreatCoward() {
    String name = queue.removeFirst();
    System.out.println("Удален из начала: " + name);
    return name;
  }

  // текущее состояние очереди
  public void printQueue() {
    System.out.println("Текущее состояние очереди:");
    if (queue.isEmpty()) {
      System.out.println("  (очередь пуста)");
      return;
    }
    System.out.println("  Размер очереди: " + queue.size());
    System.out.println("  Очередь: " + queue);
  }


  @Override
  public String toString() {
    if (queue.isEmpty()) {
      return "AssaultQueue{очередь пуста}";
    }

    return "AssaultQueue{размер=" + queue.size() +
        ", штурмовики=" + queue + "}";
  }

  // Дополнительные методы
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public int size() {
    return queue.size();
  }
}
