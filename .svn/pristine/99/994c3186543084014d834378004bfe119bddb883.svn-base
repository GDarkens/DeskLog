package windowLog;
import org.junit.jupiter.api.Test;
import windowLog.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TextLog_Test {


    @Test
    public void testCreateContent(){

        String applicationsContent = (TextLog.applicationContent).toString();
        String applicationsRunning = windowLogger.returnOpenWindows().toString();
        System.out.println(applicationsContent +" "+ applicationsRunning);

        if(!applicationsContent.equals("[]")) {
            if (applicationsContent.equals(applicationsRunning)) System.out.println("True");
            else System.out.println("False");
        }else{
            System.out.println("windowLogger not running");
        }
    }


}
