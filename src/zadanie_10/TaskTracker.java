package zadanie_10;
import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
  private List<Task> tasks;

  public TaskTracker() {
    this.tasks = new ArrayList<>();
    }

  // добавление задачи
  public void addTask(String taskName) {
    Task newTask = new Task(taskName);
    tasks.add(newTask);
    System.out.println("Задача \"" + taskName + "\" добавлена.");
  }

  // вывести все задачи
  public void displayAllTasks() {
    if (tasks.isEmpty()) {
      System.out.println("Список задач пуст.");
      return;
    }

    System.out.println("Список всех задач:");
    for (Task task : tasks) {
      task.displayInfo();
    }
  }

  // найти и вывести задачу и её статус
  public void findTaskByName(String taskName) {
    for (Task task : tasks) {
      if (task.getName().equalsIgnoreCase(taskName)) {
        System.out.println("Задача найдена:");
        task.displayInfo();
        return;
      }
    }
    System.out.println("Задача \"" + taskName + "\" не найдена");
  }

  // переключение статуса задачи (отметить выполненным/невыполненным)
  public void toggleTaskStatus(String taskName) {
    for (Task task : tasks) {
      if (task.getName().equalsIgnoreCase(taskName)) {
        task.toggleStatus();  // смена статуса
        String status = task.isCompleted() ? "выполненная" : "невыполненная";
        System.out.println("Задача \"" + taskName + "\" отмечена как " + status);
        return;
      }
    }
    System.out.println("Задача \"" + taskName + "\" не найдена");
  }

  // отобразить статистику по выполнению задач
  public void displayStatistics() {
    int total = tasks.size();
    int completed = 0;

    for (Task task : tasks) {
      if (task.isCompleted()) {
        completed++;
      }
    }

    int open = total - completed;

    System.out.println("Статистика по задачам:");
    System.out.println("Всего задач: " + total);
    System.out.println("Выполнено: " + completed);
    System.out.println("Открыто: " + open);
  }
}

