package zadanie_7.arena.heroes;

public class Knight extends Hero {

  private int armor;

  public Knight(String name, int level, int health, int armor) {
    super(name, level, health);
    this.armor = armor;
  }

  @Override
  public void attack() {
    System.out.println("Рыцарь бьёт мечом!");
  }

//  @Override
//  public final void rest() {
//    System.out.println("Герой отдыхает.");
//  }



  @Override
  public String toString() {
    return "Knight{" +
        "name='" + getName() + '\'' +
        ", level=" + getLevel() +
        ", health=" + getHealth() +
        ", armor=" + armor +
        '}';
  }

}
