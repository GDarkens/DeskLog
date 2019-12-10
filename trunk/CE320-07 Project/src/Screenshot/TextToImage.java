package Screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextToImage {
//
    public static void textToImage (String ApplicationName, String pathname, String Width, String Height) throws Exception{
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);// Represents an image with 8-bit RGBA color components packed into integer pixels.
        Graphics2D graphics2d = image.createGraphics();
        Font font = new Font("TimesNewRoman", Font.BOLD, 100);

        if (Integer.parseInt(Width) == 1280){
            font = new Font("TimesNewRoman", Font.BOLD, 70);
        }
        if (Integer.parseInt(Width) == 720){
            font = new Font("TimesNewRoman", Font.BOLD, 45);
        }

        graphics2d.setFont(font);
        FontMetrics fontmetrics = graphics2d.getFontMetrics();
        int width = Integer.parseInt(Width);
        int height = Integer.parseInt(Height);

        graphics2d.dispose();

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2d = image.createGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setFont(font);
        fontmetrics = graphics2d.getFontMetrics();
        graphics2d.setColor(Color.yellow);
        graphics2d.drawString(ApplicationName, 0, fontmetrics.getAscent());
        graphics2d.dispose();
        try {
            ImageIO.write(image, "jpg", new File(pathname));
            // path example: "C:\\whateverLocation\\sample.jpg"
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Application change image successfully saved.");
    }
}
