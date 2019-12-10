package windowLog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;


public class TextLog{
    static String TEXTLOG_SAVE_LOCATION;

    private static String videoLogDate;
    private static String videoLogDateTime;
    public static List<windowLogger.WindowInfo> applicationContent = Collections.emptyList();
    public TextLog(){

    }
    private static void getDateTime(){

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd'_'HH.mm.ss");
        videoLogDateTime = dateFormatter.format(currentTime);
    }
    private static void getDate(){

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        videoLogDate = dateFormatter.format(currentTime);
    }


    //name of the file should be the same as the one of the video log
    private static String createDateFormatDoc(){

        getDate();
        StringBuilder filename = new StringBuilder();
        filename.append(videoLogDate).append(".txt");
        System.out.println(filename);
        return filename.toString();
    }

    public static String createContent(){

        getDateTime();
        String content;
        applicationContent = windowLogger.returnOpenWindows();
        content = "Video Log: " + videoLogDateTime + "\nApplication(s) in use: " + applicationContent +"\n";

        return content;

    }

    public static void createTextLog(String textlogLocation) throws IOException {
        TEXTLOG_SAVE_LOCATION = textlogLocation;

        String textLogDetails = createContent();
        String filename = createDateFormatDoc();
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(TEXTLOG_SAVE_LOCATION+filename));
        writeFile.append(textLogDetails);
        writeFile.close();

    }
    public static void main(){

        try {
            createTextLog(TEXTLOG_SAVE_LOCATION);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
