package Screenshot;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static Screenshot.TextToImage.textToImage;
import static Screenshot.ImageDissimilarity.getDifferencePercent;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextToImageTest {
    BufferedImage img1;
    BufferedImage img2;

    String txt = "Hello World";
    String file1 = "C:\\Users\\User\\Desktop\\University\\CE320 - Extreme Programming\\first.jpg";
    String file2 = "C:\\Users\\User\\Desktop\\University\\CE320 - Extreme Programming\\second.jpg";
    String width = "1920";
    String height = "1080";

    public void main(String[] args) throws ParseException, IOException {
        testGetDifferencePercent();
        testIncorrectFilePath();
        testDimensions();
    }

    //create 2 identical images
    {
        try {
            textToImage(txt, file1, width, height);
            textToImage(txt, file2, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            img1 = ImageIO.read(new File(file1));
            img2 = ImageIO.read(new File(file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test // test to see if the two identical image sizes created by the textToImage function are equal in pixel size
    public void testGetDifferencePercent() throws IOException {
        assertEquals(getDifferencePercent(img1, img2), 0, 0);
    }

    @Test //This test is to test whether an error appears if the path given is incorrect
    public void testIncorrectFilePath() {
        try {
            String testPath = "C:\\Users\\User\\Desktop\\University\\Incorrect\\x.jpg";
            textToImage(txt, testPath, width, height);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid Path");
        }
    }

    @Test // test to see if the dimensions entered are correct
    public void testDimensions() {
        try {
            int width = img1.getWidth();
            int height = img1.getHeight();
            assertEquals(width, 1920, 0);
            assertEquals(height, 1080, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
