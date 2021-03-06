package Screenshot;

import GUI.MiddlePanel;
import org.apache.commons.lang3.time.DateUtils;
import org.jcodec.containers.mp4.SampleOffsetUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.imageio.ImageIO.read;


public class ScreenshotMain {
    public static void main(String[] args) {
        screenshotHandler(SCREENSHOT_SAVE_LOCATION);
    }

    static String SCREENSHOT_SAVE_LOCATION;
    private final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd'_'HH.mm.ss");
    private static String fileNameLocation;
    public static String selectedRes = "1920*1080p: 16:9";
    private static String prevFile;
    private static String formattedDate;
    private static int thresholdVal;

    public static void screenshotHandler(String screenshotLocation) {
        SCREENSHOT_SAVE_LOCATION = screenshotLocation + "/SavedScreenshots/";
        Date currentDate = new Date();
        String[] resValues;

        int sec = MiddlePanel.frameRateSlider.getValue() * -5;
        Date prevDate = DateUtils.addSeconds(currentDate, sec);

        try {
            Robot screenshotRobot = new Robot();
            BufferedImage screenshot = screenshotRobot.createScreenCapture(new Rectangle(SCREEN_SIZE));

            File directory = new File(SCREENSHOT_SAVE_LOCATION);
            if (!directory.exists()) directory.mkdir();

            formattedDate = dateFormatter.format(currentDate);
            fileNameLocation = SCREENSHOT_SAVE_LOCATION + dateFormatter.format(currentDate) + ".jpg";

            ImageIO.write(screenshot, "JPG", new File(SCREENSHOT_SAVE_LOCATION +
                    dateFormatter.format(currentDate) + ".jpg"));

        } catch (AWTException | IOException e) {
            System.out.println("Failed to take and save screenshot \n" + "Stack trace: " + e);
        }

        resizeHandler();
        timestampHandler();

        try {
            String prevFile = SCREENSHOT_SAVE_LOCATION + dateFormatter.format(prevDate) +".jpg";

            thresholdVal = MiddlePanel.thresholdValue;
            boolean thresholdSet = MiddlePanel.dThreshold.isEnabled();
            resValues = getResolutionValue();

            if (thresholdSet) {
                /* Proceed  (to compare screenshots and add a message upon application change)
                if the user has selected to do so */
                if (new File(SCREENSHOT_SAVE_LOCATION).listFiles().length > 1) {
                    /* check if there are more than 1 images in the folder which holds the screenshots
                    this is so that an error isn't thrown when the first image is created, as there isn't
                    any previous image to compare with
                     */
                    BufferedImage img1 = ImageIO.read(new File(fileNameLocation));
                    BufferedImage img2 = ImageIO.read(new File(prevFile));
                    double difference = ImageDissimilarity.getDifferencePercent(img1, img2);

                    if (difference >= thresholdVal) { // this is the percentage difference between the 2 screenshots
                        String message = "User has changed the application";
                        String saveLocation = SCREENSHOT_SAVE_LOCATION + dateFormatter.format(prevDate) + "applicationChanged" + ".jpg";
                        TextToImage.textToImage(message, saveLocation, resValues[0], resValues[1]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void resizeHandler() {
        String[] resValues;
        try {
            ResizeResolutionImage resizedImage = new ResizeResolutionImage();
            BufferedImage selectedScreenshot = read(new File(fileNameLocation));

            resValues = getResolutionValue();

            ImageIcon s = new ImageIcon(resizedImage.resizeImage(selectedScreenshot, fileNameLocation, resValues[0], resValues[1]));

        } catch (IOException e) {
            System.out.println(e.getMessage() + "\nFailed to resize the image");
        }
    }

    private static void timestampHandler(){
        try {
            imageManipulation.timestamp(new File(fileNameLocation), new Font("Arial Black", Font.BOLD, 30), SCREENSHOT_SAVE_LOCATION);
        } catch (IOException e) {
            System.out.println("Failed to timestamp screenshot \n" +
                    "Stack trace:" + e);
        }
    }

    private static String[] getResolutionValue(){
        /* Returns the current width and height of the users images
        Returned as [0] with width and [1] as height value */

        String width, height;
        String[] temp;
        String[] widthHeight;

        widthHeight = selectedRes.split(":");

        temp = widthHeight[0].split("\\*");
        width = temp[0];
        height = temp[1].replace("p", "");
        String s1 = String.valueOf(width);
        String s2 = String.valueOf(height);

        String[] resValues = new String[3];
        resValues[0] = s1;
        resValues[1] = s2;

        return resValues;
    }
}