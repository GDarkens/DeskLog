package Screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class imageManipulation {
    public static boolean timestamp(File sourceImage, Font font, String saveLocation)throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStampMessage = dateTimeFormatter.format(currentTime);

        BufferedImage image = ImageIO.read(sourceImage);
        BufferedImage imageToBeWrittenTo = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = (Graphics2D) imageToBeWrittenTo.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        graphics.setColor(Color.GREEN);
        graphics.setFont(font);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(timeStampMessage, graphics);

        int textcentreX = ((int) (rect.getWidth()*1.5));
        int textcentreY = (int) (rect.getHeight()*1.5);
        graphics.drawString(timeStampMessage, (image.getWidth()-(textcentreX)), textcentreY);
        ImageIO.write(imageToBeWrittenTo, "jpg", new File(saveLocation + sourceImage.getName()));
        
        System.out.println("Image successfully saved.");
        return true;
    }

    public static boolean timestamp(File sourceImage)throws IOException {
        return timestamp(sourceImage, new Font("Arial Black", Font.BOLD, 30), ScreenshotMain.SCREENSHOT_SAVE_LOCATION);
}
}
