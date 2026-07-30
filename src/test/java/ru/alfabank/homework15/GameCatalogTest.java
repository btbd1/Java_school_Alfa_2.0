package test.java.ru.alfabank.homework15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.ru.alfabank.homework15.BoardGame;
import main.java.ru.alfabank.homework15.GameRental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameCatalogTest {

  private GameRental rental;

  @BeforeEach
  void init() {
    rental = new GameRental();
  }

  @Test
  void constructor_createsEmptyCatalog() {
    assertNotNull(rental);
  }

  @Test
  void addGame_withValidGame_addsGameToCatalog() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);
  }

  @Test
  void findGameByName_existingGame_returnsGame() {
    BoardGame game = new BoardGame("Monopoly", 8, 100.0);
    rental.addGame(game);

    BoardGame found = rental.findGame("Monopoly");

    assertNotNull(found);
    assertEquals("Monopoly", found.getName());
  }

  @Test
  void addGame_withNull_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> rental.addGame(null));
  }

  @Test
  void addGame_duplicateName_throwsException() {
    BoardGame game1 = new BoardGame("Monopoly", 8, 100.0);
    BoardGame game2 = new BoardGame("Monopoly", 10, 150.0);

    rental.addGame(game1);

    assertThrows(IllegalArgumentException.class,
        () -> rental.addGame(game2));
  }

  @Test
  void findGame_nonExistingGame_returnsNull() {
    BoardGame found = rental.findGame("Несуществующая игра");
    assertNull(found);
  }
}
