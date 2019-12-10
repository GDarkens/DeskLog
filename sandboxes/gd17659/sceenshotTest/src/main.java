import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main{
    public static void main(String[] args) {
        takeAndSaveScreenshot();
    }

    final static String SCREENSHOT_SAVE_LOCATION = "E:\\";

    final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd'_'HH.mm.ss");

    public static void takeAndSaveScreenshot(){
        Date currentDate = new Date();
        try {
            Robot screenshotRobot = new Robot();
            BufferedImage screenshot = screenshotRobot.createScreenCapture(new Rectangle(SCREEN_SIZE));

            ImageIO.write(screenshot, "JPG", new File(SCREENSHOT_SAVE_LOCATION +
                    dateFormatter.format(currentDate) +
                    ".jpg"));

        }catch (AWTException | IOException e){
            System.out.println("Failed to take and save screenshot \n" +
                    "Stack trace: " + e);
        }
    }

}
