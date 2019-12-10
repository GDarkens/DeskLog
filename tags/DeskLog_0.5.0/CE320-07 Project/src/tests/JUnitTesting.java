package tests;
import org.junit.jupiter.api.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class JUnitTesting {

    final static String SCREENSHOT_SAVE_LOCATION = ".//SavedScreenshots//";
    final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd'_'HH.mm.ss");
    public static String fileNameLocation;
    Date currentDate = new Date();
    Font font = new Font("Arial Black", Font.BOLD, 30);


    public void main(String[] args) throws ParseException, IOException {
        testIncorrectFormat();
        testDateFormatter();
        testSaveScreenshotDir();
        //afterImage();
        assertEqual();
    }

    public void afterImage() {
        try {
            Image img = ImageIO.read(new File(SCREENSHOT_SAVE_LOCATION +
                    dateFormatter.format(currentDate) +
                    ".jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadBeforeImage() {
        try {
            Image img = ImageIO.read(new File(SCREENSHOT_SAVE_LOCATION + ".jpg"));
            System.out.println(img);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test //This test is to test whether the correct date passes the test successfully
    public void testDateFormatter() {
        try {
            String testDate = "2019.11.11_21.34.01";
            Date date = dateFormatter.parse(testDate);
            dateFormatter.format(date);
            System.out.println(date);
        } catch (ParseException e) {
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
    public void testSaveScreenshotDir() {
        Date currentDate = new Date();
        try {
            Robot screenshotRobot = new Robot();
            BufferedImage screenshot = screenshotRobot.createScreenCapture(new Rectangle(SCREEN_SIZE));

            //Check if the directory exists, if not create it

            ImageIO.write(screenshot, "JPG", new File(SCREENSHOT_SAVE_LOCATION +
                    dateFormatter.format(currentDate) +
                    ".jpg"));

        } catch (AWTException | IOException e) {
            System.out.println("Failed to take and save screenshot \n" +
                    "Stack trace: " + e);
        }
    }

    @Test //Tests that the two files being tested are the 'same'
    public void assertEqual() throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SCREENSHOT_SAVE_LOCATION + ".jpg"));
        BufferedImage afterImage = ImageIO.read(new File(SCREENSHOT_SAVE_LOCATION +
                dateFormatter.format(currentDate) +
                ".jpg"));
        assertEquals(originalImage, afterImage);
    }

    @Test
    private boolean assertEquals(BufferedImage originalImage, BufferedImage afterImage) {
        if (originalImage == afterImage) {
            System.out.println("hi");
            return true;
        }
        return false;
    }
}