public class Zadanie1 {
  public static void main(String[] args) {
    // переменные
    String employeeName = "Глеб";
    String position = "Старший шаурма-инженер";
    double ratePerShift = 5000.0;  // ставка за смену
    int numberOfShifts = 8;  // количество смен
    double bonus = 3000.0;  // бонус
    double fine = 500.0;  //штраф
    double price = 300.0;  // цена за шт
    int quantity = 100;  // количество проданных шт

    double baseSalary = numberOfShifts * ratePerShift; // Зарплата без премии

    double finalSalary = baseSalary + bonus - fine; // Зарплата с учетом премии и штрафа

    double revenue = quantity * price; // Выручка

  // вывод данных
    System.out.println("Сотрудник: " + employeeName);
    System.out.println("Должность: " + position);
    System.out.println("Оплата за смены: " + (int) baseSalary);
    System.out.println("Премия: " + (int) bonus);
    System.out.println("Штраф: " + (int) fine);
    System.out.println("Итоговая зарплата: " + (int) finalSalary);
    System.out.println("Шаур-выручка: " + (int) revenue);
  }
}

