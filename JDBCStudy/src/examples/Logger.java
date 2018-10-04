package examples;

import java.util.Calendar;

/**
 * Singletone Pattern
 * @author 전상일
 *
 */
public class Logger {
   private static Logger logger = new Logger();
   
   private Logger() {}
   
   public static Logger getInstance() {
      return logger;
   }
   
   public void log(String message) {
      Calendar today = Calendar.getInstance();
      String time = String.format("%1$tF %1$tT", today);
      
      System.out.println("["+time+"] " +message);
   }
}
