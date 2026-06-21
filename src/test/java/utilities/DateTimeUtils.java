package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private static LocalDateTime currentDateTime = LocalDateTime.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static String formattedDateTime = currentDateTime.format(formatter);

    public static String getDateTime(){
        return formattedDateTime.replace(":","_");
    }
}
