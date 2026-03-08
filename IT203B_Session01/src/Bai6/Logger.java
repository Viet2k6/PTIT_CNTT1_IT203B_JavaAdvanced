package Bai6;
import java.time.LocalDate;
class Logger {
    public static void logError(String message) {
        System.out.println("[ERROR] " + LocalDate.now() + " : " + message);
    }
}
