package zadanie_9;

import com.github.lalyos.jfiglet.FigletFont;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import net.datafaker.Faker;

import java.util.Random;
public class CompanyLogoGenerator {

  // Массив фамилий для первой части логотипа
  private static final String[] SURNAMES = {
      "Cooper",
      "Pitt",
      "Hoffman",
      "Richy"
  };

  public static void main(String[] args) throws Exception {
    // Установка кодировки для вывода
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));


    // Генерация логотипа компании

    String surname1 = getRandomSurname();
    String ampersand = "&";
    Faker faker = new Faker();
    String surname2 = faker.name().lastName();

    System.out.println(FigletFont.convertOneLine(surname1));
    System.out.println(FigletFont.convertOneLine(ampersand));
    System.out.println(FigletFont.convertOneLine(surname2));

    // ===== Генерация юридических данных =====
    System.out.println("~ РЕГИСТРАЦИОННЫЕ ДАННЫЕ ~");
    System.out.println();

    String fullName = faker.name().fullName();
    System.out.println("ФИО: " + fullName);
    String phoneNumber = faker.phoneNumber().phoneNumber();
    System.out.println("Телефон: " + phoneNumber);
    String address = faker.address().fullAddress();
    System.out.println("Адрес: " + address);
  }

  // метод получения случайной фамилии из массива
  private static String getRandomSurname() {
    Random random = new Random();
    int index = random.nextInt(SURNAMES.length);
    return SURNAMES[index];
  }
}
