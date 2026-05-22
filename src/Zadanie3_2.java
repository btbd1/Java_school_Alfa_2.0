public class Zadanie3_2 {

  public static void main(String[] args) {
    String[] passwords = {"jfgfj123", "1fg50pood", "happypass"};

  for (String password : passwords) {
    boolean res =
        password.length() > 8
        && password.charAt(0) != '1'
        && password.charAt(password.length() - 1) != 'z'
        && !password.contains("qwerty")
        && !password.contains("1234");

    System.out.println("пароль '" + password + "' прошел проверку: " + res);
      }
    }

  }

//Задай массив с тремя любыми паролями (строки).
//Проверь что каждый из паролей:
//длиннее 8 символов
//не начинается с символа 1
//не заканчивается символом z
//не содержит последовательность "1234"
//не содержит последовательность "qwerty"
//Результат проверки выведи на экран в формате: "пароль 'значение_пароля' прошел проверку: true/false"