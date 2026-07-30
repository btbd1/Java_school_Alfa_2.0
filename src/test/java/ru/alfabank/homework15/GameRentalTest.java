package test.java.ru.alfabank.homework15;

import main.java.ru.alfabank.homework15.BoardGame;
import main.java.ru.alfabank.homework15.GameRental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GameRentalTest {

  private GameRental rental;

  @BeforeEach
  void init() {
    rental = new GameRental();
  }

  @Test
  void rentGame_validGameAndAge_returnsTrueAndMarksRented() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);

    boolean result = rental.rentGame("Monopoly", 10);

    assertTrue(result);
    assertTrue(game.isRented());
  }

  @Test
  void rentGame_tooYoung_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);

    boolean result = rental.rentGame("Monopoly", 6);

    assertFalse(result);
    assertFalse(game.isRented());
  }

  @Test
  void rentGame_alreadyRented_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);
    rental.rentGame("Monopoly", 10);

    boolean result = rental.rentGame("Monopoly", 12);

    assertFalse(result);
    assertTrue(game.isRented());
  }

  @Test
  void returnGame_rentedGame_returnsTrueAndMarksAvailable() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);
    rental.rentGame("Monopoly", 10);

    boolean result = rental.returnGame("Monopoly");

    assertTrue(result);
    assertFalse(game.isRented());
  }

  @Test
  void returnGame_nonExistingGame_returnsFalse() {
    boolean result = rental.returnGame("Несуществующая");
    assertFalse(result);
  }

  @Test
  void returnGame_notRentedGame_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);

    boolean result = rental.returnGame("Monopoly");

    assertFalse(result);
    assertFalse(game.isRented());
  }

  @Test
  void reset_marksAllGamesAsAvailable() {
    BoardGame game1 = new BoardGame("Monopoly", 8, 100.0);
    BoardGame game2 = new BoardGame("Dobble", 6, 50.0);
    rental.addGame(game1);
    rental.addGame(game2);
    rental.rentGame("Monopoly", 10);
    rental.rentGame("Dobble", 10);

    rental.reset();

    assertFalse(game1.isRented());
    assertFalse(game2.isRented());
  }

  @ParameterizedTest
  @CsvSource({
      "8, 10, true",
      "8, 8, true",
      "8, 7, false",
      "10, 5, false"
  })
  void rentGame_variousAges_returnsExpected(int minAge, int customerAge, boolean expected) {
    BoardGame game = new BoardGame("Test", minAge, 100.0);
    rental.addGame(game);

    boolean result = rental.rentGame("Test", customerAge);

    assertEquals(expected, result);
    if (expected) {
      assertTrue(game.isRented());
    } else {
      assertFalse(game.isRented());
    }
  }
}
