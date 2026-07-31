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

  // создание нового объекта для теста
  @BeforeEach
  void init() {
    rental = new GameRental();
  }

  // проверка - успешная аренда игры (возраст подходит, игра свободна)
  @Test
  void rentGame_validGameAndAge_returnsTrueAndMarksRented() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);

    boolean result = rental.rentGame("Monopoly", 10);

    assertTrue(result);
    assertTrue(game.isRented());
  }

  // проверка - нельзя арендовать игру, если ты младше возрастного ограничения
  @Test
  void rentGame_tooYoung_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);

    boolean result = rental.rentGame("Monopoly", 6);

    assertFalse(result);
    assertFalse(game.isRented());
  }

  // проверка - уже арендованную игру нельзя арендовать снова
  @Test
  void rentGame_alreadyRented_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);
    rental.rentGame("Monopoly", 10);

    boolean result = rental.rentGame("Monopoly", 12);

    assertFalse(result);
    assertTrue(game.isRented());
  }

  // проверка - успешный возврат арендованной игры
  @Test
  void returnGame_rentedGame_returnsTrueAndMarksAvailable() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);
    rental.rentGame("Monopoly", 10);

    boolean result = rental.returnGame("Monopoly");

    assertTrue(result);
    assertFalse(game.isRented());
  }

  // проверка - возврат несуществующей игры возвращает false
  @Test
  void returnGame_nonExistingGame_returnsFalse() {
    boolean result = rental.returnGame("Несуществующая");
    assertFalse(result);
  }

  // проверка - возврат неарендованной игры возвращает false
  @Test
  void returnGame_notRentedGame_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);

    boolean result = rental.returnGame("Monopoly");

    assertFalse(result);
    assertFalse(game.isRented());
  }

  // проверка - reset() делает все игры доступными для аренды
  @Test
  void reset_marksAllGamesAsAvailable() {
    BoardGame game1 = new BoardGame("Monopoly", 8, 100);
    BoardGame game2 = new BoardGame("Dobble", 6, 50);
    rental.addGame(game1);
    rental.addGame(game2);
    rental.rentGame("Monopoly", 10);
    rental.rentGame("Dobble", 10);

    rental.reset();

    assertFalse(game1.isRented());
    assertFalse(game2.isRented());
  }

  // проверка - игру нельзя арендовать, если ее нет в каталоге
  @Test
  void rentGame_nonExistingGame_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> rental.rentGame("Несуществующая", 10));
  }

  // проверка - rentGame() работает правильно с разными возрастами
  @ParameterizedTest
  @CsvSource({
      "8, 10, true",
      "8, 8, true",
      "8, 7, false",
      "10, 5, false"
  })
  void rentGame_variousAges_returnsExpected(int minAge, int customerAge, boolean expected) {
    BoardGame game = new BoardGame("Test", minAge, 100);
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
