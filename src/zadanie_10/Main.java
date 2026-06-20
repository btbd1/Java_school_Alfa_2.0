package zadanie_10;

public class Main {
  public static void main(String[] args) {
    TaskTracker tracker = new TaskTracker();

    System.out.println("===Возможности TaskTracker ===\n");

    System.out.println("1. Добавление задач:");
    tracker.addTask("Посетить дейлик");
    tracker.addTask("Запросить все доступы");
    tracker.addTask("Написать документацию");
    tracker.addTask("Протестировать API");
    System.out.println();

    System.out.println("2. Текущий список задач:");
    tracker.displayAllTasks();
    System.out.println();

    System.out.println("3. Переключение статусов задач:");
    tracker.toggleTaskStatus("Посетить дейлик");
    tracker.toggleTaskStatus("Запросить все доступы");
    tracker.toggleTaskStatus("Написать документацию");
    System.out.println();

    System.out.println("4. Список после изменений:");
    tracker.displayAllTasks();
    System.out.println();

    System.out.println("5. Перевод задачи в невыполненную:");
    tracker.toggleTaskStatus("Запросить все доступы");
    System.out.println();

    System.out.println("6. Итоги рабочего дня по списку:");
    tracker.displayAllTasks();
    System.out.println();

    System.out.println("7. Статистика:");
    tracker.displayStatistics();
    System.out.println();

    System.out.println("8. Поиск задачи:");
    tracker.findTaskByName("Протестировать API");
    tracker.findTaskByName("Несуществующая задача");
    System.out.println();

  }
}
