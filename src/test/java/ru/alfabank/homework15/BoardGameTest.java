package test.java.ru.alfabank.homework15;

import main.java.ru.alfabank.homework15.BoardGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BoardGameTest {

  // проверка передаваемых значений при создании новой игры
  @Test
  void constructor_withValidArguments_createsGame() {
    // arrange & act
    BoardGame game = new BoardGame("Monopoly", 8, 100);

    // assert
    assertNotNull(game);
    assertEquals("Monopoly", game.getName());
    assertEquals(8, game.getMinAge());
    assertEquals(100, game.getRentalCost());
    assertFalse(game.isRented());
  }

  // проверка - при имени = null выбрасывается исключение
  @Test
  void constructor_withNullName_throwsException() {
    IllegalArgumentException ex = assertThrows(
        IllegalArgumentException.class,
        () -> new BoardGame(null, 8, 100)
    );
    assertTrue(ex.getMessage().toLowerCase().contains("название"));
  }

  // проверка - при пустом имени выбрасывается исключение
  @Test
  void constructor_withEmptyName_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> new BoardGame("", 8, 100));
  }

  // проверка - при имени из пробелов выбрасывается исключение
  @Test
  void constructor_withBlankName_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> new BoardGame("   ", 8, 100));
  }

  // проверка - при отрицательном возрасте выбрасывается исключение
  @Test
  void constructor_withNegativeMinAge_throwsException() {
    IllegalArgumentException ex = assertThrows(
        IllegalArgumentException.class,
        () -> new BoardGame("Monopoly", -5, 100)
    );
    assertTrue(ex.getMessage().toLowerCase().contains("возраст") ||
        ex.getMessage().toLowerCase().contains("age"));
  }

  // проверка - при нулевой стоимости выбрасывается исключение
  @Test
  void constructor_withZeroRentalCost_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> new BoardGame("Monopoly", 8, 0));
  }

  // проверка - при отрицательной стоимости выбрасывается исключение
  @Test
  void constructor_withNegativeRentalCost_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> new BoardGame("Monopoly", 8, -10));
  }

  // проверка - CanBeRentedBy() возвращает true для подходящего возраста
  @Test
  void canBeRentedBy_withAgeGreaterThanMinAge_returnsTrue() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    assertTrue(game.canBeRentedBy(10));
  }

  // проверка - canBeRentedBy() возвращает true для возраста равного ограничению
  @Test
  void canBeRentedBy_withAgeEqualToMinAge_returnsTrue() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    assertTrue(game.canBeRentedBy(8));
  }

  // проверка - canBeRentedBy() возвращает false для недостаточного возраста
  @Test
  void canBeRentedBy_withAgeLessThanMinAge_returnsFalse() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    assertFalse(game.canBeRentedBy(6));
  }

  // проверка - canBeRentedBy() работает правильно с разными возрастами
  @ParameterizedTest
  @CsvSource({
      "8, 8, true",
      "8, 10, true",
      "8, 7, false",
      "8, 0, false",
      "8, 100, true"
  })
  void canBeRentedBy_variousAges_returnsExpected(int minAge, int clientAge, boolean expected) {
    BoardGame game = new BoardGame("Test", minAge, 100);
    assertEquals(expected, game.canBeRentedBy(clientAge));
  }

  // проверка - setRented() меняет статус аренды
  @Test
  void setRented_changesRentedStatus() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    assertFalse(game.isRented());

    game.setRented(true);
    assertTrue(game.isRented());

    game.setRented(false);
    assertFalse(game.isRented());
  }
}
