package zadanie_11;

public class CoffeeMachine {

  private static int minimumWaterAmount = 200;

  public void makeCoffee (int ml){
    if (ml <= minimumWaterAmount){
      throw new NotEnoughWaterException(
          "В кофемашине недостаточно воды. Доступно: "
              + ml + " мл. Добавьте не менее: "
              + (minimumWaterAmount - ml + 1) + " мл.");
    }

    System.out.println("Кофе приготовлен");

  };

  public int calculateCups (int ml, int cupCapacity){
    return ml / cupCapacity;
  };

  public void printCoffeeName (String coffeeName){
    System.out.println(coffeeName.toUpperCase());
  };
}
