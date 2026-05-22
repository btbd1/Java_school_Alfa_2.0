package zadanie_7.arena.heroes;

public class Hero {

  protected static final int MAX_LEVEL = 100;

  private static int heroesCreated = 0;

  private final String name;
  private int level;
  private int health;

  public Hero(String name, int level, int health) {
    this.name = name;
    this.level = Math.min(level, MAX_LEVEL);;
    this.health = health;

    heroesCreated++;
  }

  // геттеры
  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public int getHealth() {
    return health;
  }

  // сеттеры

  public void setHealth(int health) {
    this.health = Math.max(health, 0);
  }

  // методы
  public void printInfo() {
    System.out.println("Имя: " + name + ", Уровень: " + level + ", Здоровье: " + health);
  }

  public void takeDamage(int damage) {
    health = health - damage;
    if (health < 0) {
      health = 0;
    }
  }

  public void levelUp() {
    if (level < MAX_LEVEL) {
      level++;
    }
  }

  public void attack() {
    System.out.println("Герой наносит обычный удар.");
  }

  public void attack(String target) {
    System.out.println("Герой наносит обычный удар. Цель: " + target);
  }

  public void attack(String target, int times) {
    System.out.println("Герой атакует цель " + target + " " + times + " раза.");
  }

  public static void printHeroesCreated() {
    System.out.println("Всего создано героев: " + heroesCreated);
  }

  public final void rest() {
    System.out.println("Герой отдыхает и восстанавливает силы.");
  }

}
