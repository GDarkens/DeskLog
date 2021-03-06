package tests;

import org.junit.jupiter.api.Test;
import windowLog.windowLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WindowLog_Tests {
    private static String filePath;
    static {
        try {
            filePath = new File(".").getCanonicalPath();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }private static Path path = Paths.get(filePath, "programLog.txt");


    @Test
    void windowLogDuplicator() throws IOException {
        /*
        Running two program logs back to back
        should result in no additional changes to the
        since no new programs should have been ,made
         */
        int beforeLog, afterLog;

        windowLogger.main();
        beforeLog = countFileLines();
        windowLogger.main();
        afterLog = countFileLines();

        assertEquals(beforeLog, afterLog);
    }

    @Test
    void programChangeCheck() throws IOException, InterruptedException {
        /*
        Running two program logs back to back
        again, but this time introducing a new program
        so that there is a new line added to the log
        file
         */
        int beforeLog, afterLog;

        windowLogger.main();
        beforeLog = countFileLines();

        Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
        Thread.sleep(100);

        windowLogger.main();
        afterLog = countFileLines();

        assertEquals(beforeLog + 1, afterLog);
    }

    private int countFileLines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
        int fileLines = 0;

        while (reader.readLine() != null){
            fileLines++;
        }
        reader.close();

        return fileLines;
    }
}