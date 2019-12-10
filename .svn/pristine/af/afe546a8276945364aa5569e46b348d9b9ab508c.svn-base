package UnitTesting;
import org.junit.jupiter.api.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class JUnitTesting {

    //static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd");
    SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYY.MM.DD'_'HH.MM.SS");
    final static String SCREENSHOT_SAVE_LOCATION = ".//SavedScreenshots//";
    final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static String fileNameLocation;

    public void main(String[] args) throws ParseException {
        //testIncorrectFormat();
        //testDateFormatter();
        testSaveScreenshotWrongDir();
    }

    @Test
    public void testDateFormatter() {
        try {
        String testDate = "2019.11.11_21.34.01";
        Date date = dateFormatter.parse(testDate);
        dateFormatter.format(date);
        System.out.println(date);
        }
        catch (ParseException e) {
        e.printStackTrace();
        }
    }

    @Test //This test is to test whether an error appears if the date is written incorrectly
    public void testIncorrectFormat() {
        try {
            String testDate = "11.11.2019";
            Date date = dateFormatter.parse(testDate);
            dateFormatter.format(testDate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveScreenshotWrongDir() {
        Date currentDate = new Date();
        try {
            Robot screenshotRobot = new Robot();
            BufferedImage screenshot = screenshotRobot.createScreenCapture(new Rectangle(SCREEN_SIZE));

            //Check if the directory exists, if not create it
            File directory = new File(SCREENSHOT_SAVE_LOCATION);
            if (!directory.exists()) {
                directory.mkdir();
            }
            fileNameLocation = SCREENSHOT_SAVE_LOCATION + dateFormatter.format(currentDate) + ".jpg";

            ImageIO.write(screenshot, "JPG", new File(SCREENSHOT_SAVE_LOCATION +
                    dateFormatter.format(currentDate) +
                    ".jpg"));


        }catch (AWTException | IOException e){
            System.out.println("Failed to take and save screenshot \n" +
                    "Stack trace: " + e);
        }
    }

}
