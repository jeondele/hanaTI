package edwith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class kaka {

	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String formatDateTime = today.format(formatter);

        System.out.println("After : " + formatDateTime);
	}

}
