package zadanie_8;

import java.util.ArrayList;

public class Playlist {
  private String playlistName;

  // хранение списка песен
  private ArrayList<String> songList;


  public Playlist(String playlistName) {
    this.playlistName = playlistName;
    this.songList = new ArrayList<>();
    System.out.println("Создан новый плейлист: " + playlistName);
  }

  // добавление песни
  public void addSong(String songName) {
    songList.add(songName);
    System.out.println("Добавлена песня: \"" + songName + "\" в плейлист \"" + playlistName + "\"");
  }

  // удаление песни
  public boolean removeSong(int i) {
    if (i >= 0 && i < songList.size()) {
      String removedSong = songList.get(i); // название удаляемой песни
      songList.remove(i);
      System.out.println("Удалена песня: \"" + removedSong + "\" (индекс " + i + ")");
      return true;
    } else {
      System.out.println("Ошибка удаления: индекс " + i + " вне границ списка (песен в списке: " + songList.size() + ")");
      return false;
    }
  }

  // обновление песни
  public boolean updateSong(int i, String newSong) {
    if (i >= 0 && i < songList.size()) {
      String oldSong = songList.get(i);  // "старая" песня
      songList.set(i, newSong);
      System.out.println("Обновлена песня: \"" + oldSong + "\" → \"" + newSong + "\" (индекс " + i + ")");
      return true;
    } else {
      System.out.println("Ошибка обновления: индекс " + i + " вне границ списка (песен в списке: " + songList.size() + ")");
      return false;
    }
  }

  // получение песни
  public String getSong(int i) {
    if (i >= 0 && i < songList.size()) {
      String foundSong = songList.get(i);
      System.out.println("Получена песня по индексу " + i + ": \"" + foundSong + "\"");
      return foundSong;
    } else {
      System.out.println("Ошибка получения: индекс " + i + " вне границ списка (песен в списке: " + songList.size() + ")");
      return null;
    }
  }

  // Переопределяем метод toString для корректного отображения плейлиста в консоли
  @Override
  public String toString() {
    if (songList.isEmpty()) {
      return "Плейлист \"" + playlistName + "\" [пусто]";
    }

    // строка с содержимым плейлиста
    StringBuilder result = new StringBuilder();
    result.append("Плейлист \"").append(playlistName).append("\" [Количество песен: ");
    result.append(songList.size()).append("]:\n");

    for (int i = 0; i < songList.size(); i++) {
      result.append("  ").append(i + 1).append(". ").append(songList.get(i));
      if (i < songList.size() - 1) {
        result.append("\n");
      }
    }

    return result.toString();
  }
}

