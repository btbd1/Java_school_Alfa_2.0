package main.java.ru.alfabank.homework13;

import java.util.Objects;

public class Alien {
  private String name;
  private String planet;
  private int dangerLevel;

  public Alien(String name, String planet, int dangerLevel) {
    if (dangerLevel < 1 || dangerLevel > 10) {
      throw new IllegalArgumentException("Некорректный уровень опасности - должен быть в диапазоне от 1 до 10");
    }

    this.name = name;
    this.planet = planet;
    this.dangerLevel = dangerLevel;
  }

  public String getName() {
    return name;
  }

  public String getPlanet() {
    return planet;
  }

  public int getDangerLevel() {
    return dangerLevel;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Alien other = (Alien) obj;  //привести к одному типу - Alien

    return Objects.equals(name, other.name) && Objects.equals(planet, other.planet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, planet);
  }

  @Override
  public String toString() {
    return String.format("Alien{name='%s', planet='%s', dangerLevel=%d}", name, planet, dangerLevel);
  }

}
