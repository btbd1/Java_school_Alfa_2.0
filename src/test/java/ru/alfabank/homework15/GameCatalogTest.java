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

  // создание нового объекта для теста
  @BeforeEach
  void init() {
    rental = new GameRental();
  }

  // проверка - каталог создается пустым
  @Test
  void constructor_createsEmptyCatalog() {
    assertNotNull(rental);
  }

  // проверка - можно добавить игру в каталог
  @Test
  void addGame_withValidGame_addsGameToCatalog() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);
  }

  // проверка - findGame() находит игру по названию, если она существует
  @Test
  void findGameByName_existingGame_returnsGame() {
    BoardGame game = new BoardGame("Monopoly", 8, 100);
    rental.addGame(game);

    BoardGame found = rental.findGame("Monopoly");

    assertNotNull(found);
    assertEquals("Monopoly", found.getName());
  }

  // проверка - при добавлении null вылетает исключение
  @Test
  void addGame_withNull_throwsException() {
    assertThrows(IllegalArgumentException.class,
        () -> rental.addGame(null));
  }

  // проверка - нельзя добавить игру с дублирующимся названием
  @Test
  void addGame_duplicateName_throwsException() {
    BoardGame game1 = new BoardGame("Monopoly", 8, 100);
    BoardGame game2 = new BoardGame("Monopoly", 10, 150);

    rental.addGame(game1);

    assertThrows(IllegalArgumentException.class,
        () -> rental.addGame(game2));
  }

  // проверка - findGame() возвращает null, если игра не найдена
  @Test
  void findGame_nonExistingGame_returnsNull() {
    BoardGame found = rental.findGame("Несуществующая игра");
    assertNull(found);
  }
}
