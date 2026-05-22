import java.util.Scanner;

public class Zadanie4_1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите пять строк через Enter:\n");

    int count = 0;
    String[] lines = new String[5];  // массив для записи строк

    while (count < 5) {
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("NULL")) {
        System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...");
        lines[count] = "XX";
      } else {
        lines[count] = input;
      }
      count++;
    }

    StringBuilder message = new StringBuilder();  // объединение строк
    for (int i = 0; i < lines.length; i++) {
      message.append(lines[i]);
      if (i < lines.length - 1) {
        message.append("#");
      }
    }
    System.out.println("Расшифрованное послание: " + message);
    scanner.close();
  }
}
