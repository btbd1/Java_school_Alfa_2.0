import java.util.Random;

public class Zadanie2 {
  public static void main(String[] args) {
    Random rnd = new Random();

    int age = rnd.nextInt(0, 100);
    double sum = rnd.nextDouble() * 1000000;    // сумма на счете до 1000000
    double contribution = sum * 0.075;

    boolean hasInvitation = rnd.nextBoolean();
    boolean blacklist = rnd.nextBoolean();

    boolean isAdult = age >= 18;
    boolean hasInvitationOrMoney = hasInvitation || sum > 50000;
    boolean notBlacklisted = !blacklist;

    // Проверка: проходит ли пользователь
    boolean canPass = isAdult && hasInvitationOrMoney && notBlacklisted;

    System.out.println(canPass);
    if (canPass) System.out.println("Обязательный добровольный взнос: " + String.format("%.2f", contribution));
  }
}

