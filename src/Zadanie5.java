import java.time.Year;
import java.util.Random;

public class Zadanie5 {

  public static void main(String[] args) {

    // протокол ДАШБОРД
    String code = generateAccessCode();
    System.out.println(isValidCode(code, 8));
    logEvent("Server protection activated");
    logEvent("Intrusion attempt detected", true);
    int[] seeds = {42,77,13};
    for (int i : seeds) {
      System.out.println(generateAgentId("AGENT", i));
    }
  }

  // протокол ГЕНЕРАТОР
  public static String generateAccessCode(){
    int firstPart = Year.now().getValue();
    int secondPart = (int) Math.pow(3, 7);
    return firstPart + "-" + secondPart;
  }

  // протокол ВАЛИДАТОР
  private static boolean isValidCode(String code, int minLength){
    return code != null && code.length() >= minLength && code.contains("-");
  }

  // протокол ЛОГГЕР
  public static void logEvent(String message){
    System.out.println("[INFO] {" + message + "}");
  }

  public static void logEvent(String message, boolean isCritical){
    if (isCritical) {
      System.out.println("[CRITICAL] {" + message + "}");
      return;
    }
    logEvent(message);
  }

  // протокол РАНДОМАЙЗЕР
  public static String generateAgentId(String prefix, int seed){
    Random random = new Random(seed);
    int num = random.nextInt(9999 - 1000 + 1) + 1000;
    return "{" + prefix + "}" + "-" + "{" + num + "}";
  }
}
