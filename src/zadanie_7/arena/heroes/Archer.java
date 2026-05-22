package zadanie_7.arena.heroes;

public class Archer extends Hero{

  private int arrowsCount;

  public Archer(String name, int level, int health, int arrowsCount) {
    super(name, level, health);
    this.arrowsCount = arrowsCount;
  }

  @Override
  public void attack() {
    System.out.println("Лучник выпускает стрелу!");
  }

  @Override
  public String toString() {
    return "Archer{" +
        "name='" + getName() + '\'' +
        ", level=" + getLevel() +
        ", health=" + getHealth() +
        ", arrowsCount=" + arrowsCount +
        '}';
  }

}
