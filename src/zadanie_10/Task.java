package zadanie_10;

public class Task {
  // название задачи
  private String name;
  // статус задачи
  private boolean isCompleted;

  public Task(String name) {
    this.name = name;
    this.isCompleted = false;
  }

  // смена статуса задачи
  public void toggleStatus() {
    this.isCompleted = !this.isCompleted;
  }

  // для получения статуса задачи
  public boolean isCompleted() {
    return isCompleted;
  }

  // возвращение названия задачи
  public String getName() {
    return name;
  }

  // отобразить статус задачи
  public void displayInfo() {
    String status = isCompleted ? "[x]" : "[ ]";
    System.out.println(status + " " + name);
  }

}
