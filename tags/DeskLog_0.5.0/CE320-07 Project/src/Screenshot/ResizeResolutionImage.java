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


    public Image resizeImage(Image screenshotImage, String outputImagesource, int newWidth, int newHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphic = resizedImage.createGraphics();
        graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphic.drawImage(screenshotImage, 0, 0, newWidth, newHeight, null);
        graphic.dispose();
        ImageIO.write(resizedImage, "jpg", new File(outputImagesource));
        return resizedImage;

    }
}


