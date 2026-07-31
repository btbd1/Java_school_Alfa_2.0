package test.java.ru.alfabank.homework15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import main.java.ru.alfabank.homework15.BoardGame;
import main.java.ru.alfabank.homework15.GameRental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RentalCostTest {

  private GameRental rental;

  // создание нового объекта для теста
  @BeforeEach
  void init() {
    rental = new GameRental();
  }

  // проверка - calculateCost() правильно считает стоимость аренды
  @Test
  void calculateCost_validGameAndDays_returnsCorrectCost() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);

    int cost = rental.calculateCost("Monopoly", 3);

    assertEquals(300, cost);
  }

  // проверка - calculateCost() выбрасывает исключение, если игры нет
  @Test
  void calculateCost_nonExistingGame_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> rental.calculateCost("Несуществующая", 3));
  }

  // проверка - calculateCost() выбрасывает исключение при 0 дней
  @Test
  void calculateCost_zeroDays_throwsException() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);

    assertThrows(IllegalArgumentException.class,
        () -> rental.calculateCost("Monopoly", 0));
  }

  // проверка - calculateCost() правильно считает для разных игр и дней
  @ParameterizedTest
  @MethodSource("costCalculationProvider")
  void calculateCost_variousScenarios_returnsCorrectCost(String name, int rentalCost, int days, int expectedCost) {
    BoardGame game = new BoardGame(name, 8, rentalCost);
    rental.addGame(game);

    int cost = rental.calculateCost(name, days);

    assertEquals(expectedCost, cost);
  }

  static Stream<Arguments> costCalculationProvider() {
    return Stream.of(
        Arguments.of("Monopoly", 100, 1, 100),
        Arguments.of("Monopoly", 100, 3, 300),
        Arguments.of("Dobble", 50, 5, 250),
        Arguments.of("Carcassonne", 150, 2, 300),
        Arguments.of("Chess", 75, 10, 750)
    );
  }
}
