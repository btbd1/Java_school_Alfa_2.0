package zadanie_8;

public class Winamp {
    public static void main(String[] args) {
      System.out.println("=== ЗАПУСК ПЛЕЙЛИСТА ===\n");

      // Создаем объект Playlist с названием "Любимые треки"
      Playlist myPlaylist = new Playlist("Любимые треки");
      System.out.println();

      // Добавляем песни в плейлист
      System.out.println("Добавляю песни...");
      myPlaylist.addSong("Bohemian Rhapsody - Queen");
      myPlaylist.addSong("Stairway to Heaven - Led Zeppelin");
      myPlaylist.addSong("Imagine - John Lennon");
      myPlaylist.addSong("Hotel California - Eagles");
      System.out.println();

      // Получаем песню по индексу
      System.out.println("Получаю песню по индексу...");
      myPlaylist.getSong(1);
      System.out.println();

      // Обновляем песню по индексу
      System.out.println("Обновляю песню...");
      myPlaylist.updateSong(2, "Smells Like Teen Spirit - Nirvana");
      System.out.println();

      // Удаляем песню по индексу
      System.out.println("Удаляю песню...");
      myPlaylist.removeSong(0);
      System.out.println();

      // Вывод плейлиста в консоль
      System.out.println("=== ПЛЕЙЛИСТ СФОРМИРОВАН ===");
      System.out.println(myPlaylist);

    }

}
