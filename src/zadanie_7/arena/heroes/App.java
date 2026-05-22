package zadanie_7.arena.heroes;


public class App {

  public static void main(String[] args) {
    Hero[] heroes = {
        new Knight("Alexandro", 9, 14, 7),
        new Archer("Christine", 5, 7, 11),
        new Mage("Dambledore", 11, 6, 25)
    };

    for (Hero hero : heroes) {
      hero.printInfo();
      hero.attack();
    }

    // финальная переменная Knight
    final Knight knight = new Knight("Alexandro", 9, 14, 7);

    // вывод значений до изменений
    System.out.println("\n=== До изменений ===");
    System.out.println(knight);

    // вносим изменения в поля
    knight.setHealth(50);
    knight.levelUp();

    // вывод значений после изменений
    System.out.println("\n=== После изменений ===");
    System.out.println(knight);

  }

}
