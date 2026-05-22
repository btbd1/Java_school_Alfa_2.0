public class Zadanie4_2 {

  public static void main(String[] args) {

    boolean showOnlyIssues = true;
    boolean needTeamlead = true;

    int numberOfTests = 100;
    int count = 0;
    String test;
    int criticalBugs = 0;
    int passTests = 0;
    int flakyTests = 0;
    int bugTests = 0;

    while (count < numberOfTests) {

      count++;

      if ((count % 3 == 0) && (count % 5 == 0)) {
        test = "Critical!";
        criticalBugs++;
      } else if (count % 3 == 0){
        test = "Flaky";
        flakyTests++;
      } else if (count % 5 == 0) {
        test = "Bug";
        bugTests++;
      } else {
        test = "Pass";
        passTests++;
      }


      if (showOnlyIssues) {
        if (!test.equals("Pass")) {
          System.out.println("Тест #" + (count) + ": " + test);
        }
      } else {
        System.out.println("Тест #" + (count) + ": " + test);
      }

      if (needTeamlead && criticalBugs >= 3) {
        System.out.println("\n🚨 Слишком много критических багов — будим тимлида!\n");
        break;
      }
    }

    System.out.println("\n===== ИТОГИ НОЧНОЙ СМЕНЫ =====");
    System.out.println("Всего тестов: " + (count));
    System.out.println("Pass: " + passTests);
    System.out.println("Flaky: " + flakyTests);
    System.out.println("Bug: " + bugTests);
    System.out.println("Critical: " + criticalBugs);

  }

}
