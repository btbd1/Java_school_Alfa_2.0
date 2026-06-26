package zadanie_9;

import com.github.lalyos.jfiglet.FigletFont;
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

  private static final Random random = new Random();

  public static void main(String[] args) throws Exception {

    // Генерация логотипа компании
    String surname1 = getRandomSurname();
    String ampersand = "&";
    Faker faker = new Faker();
    String surname2 = faker.name().lastName();

    System.out.println(FigletFont.convertOneLine(surname1));
    System.out.println(FigletFont.convertOneLine(ampersand));
    System.out.println(FigletFont.convertOneLine(surname2));

    // ===== Генерация юридических данных =====
    System.out.println(faker.name().fullName());
    System.out.println(faker.phoneNumber().phoneNumber());
    System.out.println(faker.address().fullAddress());
  }

  // метод получения случайной фамилии из массива
  private static String getRandomSurname() {
    int index = random.nextInt(SURNAMES.length);
    return SURNAMES[index];
  }
}
