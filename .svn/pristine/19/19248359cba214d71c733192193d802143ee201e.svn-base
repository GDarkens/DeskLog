package tests.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import GUI.BottomPanel;
import org.junit.jupiter.api.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;
import static Screenshot.ImageDissimilarity.getDifferencePercent;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class JUnitTesting {

    final static String SCREENSHOT_SAVE_LOCATION = ".//SavedScreenshots//";
    final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd'_'HH.mm.ss");
    Date currentDate = new Date();
    Font font = new Font("Arial Black", Font.BOLD, 30);
    BufferedImage img1;
    BufferedImage img2;

    {
        try {
            img1 = ImageIO.read(new File(".\\SavedScreenshots\\2019.11.25_14.55.18.jpg"));
            img2 = ImageIO.read(new File(".\\SavedScreenshots\\2019.11.25_14.55.23.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) throws ParseException, IOException {
        testDateFormatter();
        testIncorrectFormat();
        testSaveScreenshotDir();
        testSameFiles();
        testGetDifferencePercent();
        testGetDifferencePercentWrong();
        testCorrectNumOfPhotos();
        testButtonFunctionality();
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
    public void testSameFiles() throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SCREENSHOT_SAVE_LOCATION + ".jpg"));
        BufferedImage afterImage = ImageIO.read(new File(SCREENSHOT_SAVE_LOCATION +
                dateFormatter.format(currentDate) +
                ".jpg"));
        assertEquals(originalImage, afterImage);
    }

    @Test // test to see whether two image sizes are equal in pixel size
    public void testGetDifferencePercent() throws IOException {
        assertEquals(getDifferencePercent(img1, img2), 12.984627032397322, 0);
    }

    @Test // test that wrong answer is expected from pixel sizes
    public void testGetDifferencePercentWrong() throws IOException {
        double expectedValue = 0.0033333333333;
        double getResult = getDifferencePercent(img1, img2);
        boolean wrongAnswer = expectedValue == getResult;
        assertFalse(wrongAnswer);
    }

    @Test //test to see if there are same number of jng files in SavedScreenshot
    public void testCorrectNumOfPhotos() {
        File f = new File("..\\SavedScreenshots\\");
        int numOfFiles = 0;
        for (File file : f.listFiles()) {
            if (file.isFile() &&
                    (file.getName().endsWith(".jpg"))) {
                numOfFiles++;
            }
        }
        int totalFiles = 10;
        if (totalFiles == numOfFiles)
        System.out.println("Number of files: " + numOfFiles);
    }

    @Test //supposed to test whether a block of code works
    public void testButtonFunctionality()  {
        BottomPanel panel = (BottomPanel) new JPanel();
        JButton button =  new JButton();
        panel.add(button);
        button.addActionListener((ActionListener) this);

    }

    @Test
    void testCreateButtonIcons() {
        BottomPanel bP = new BottomPanel();
        String pathTest1 = "./src/GUI/images/grapefruit-slice-332-332.jpg";
        String pathTest2 = "./src/GUI/images/pexels-photo-414612.jpeg";
        try {
            bP.createButtonIcons(pathTest1, pathTest2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



