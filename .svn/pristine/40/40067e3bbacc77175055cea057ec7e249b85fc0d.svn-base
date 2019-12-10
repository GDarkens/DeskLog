package Screenshot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class ResizeResolutionImage{


    public ResizeResolutionImage() {

    }


    public static Image resizeImage(Image screenshotImage, String outputImageSource, String newWidth, String newHeight) throws IOException {
        int newWidthInt = Integer.parseInt(newWidth);
        int newHeightInt = Integer.parseInt(newHeight);
        BufferedImage resizedImage = new BufferedImage(newWidthInt, newHeightInt, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphic = resizedImage.createGraphics();
        graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphic.drawImage(screenshotImage, 0, 0, newWidthInt, newHeightInt, null);
        graphic.dispose();
        System.out.println(newWidth + ", " + newHeight);
        ImageIO.write(resizedImage, "jpg", new File(outputImageSource));
        return resizedImage;
    }
}


