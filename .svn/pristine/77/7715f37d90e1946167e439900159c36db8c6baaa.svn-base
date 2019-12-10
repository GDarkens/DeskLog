package VideoCreator;

import org.jcodec.api.awt.AWTSequenceEncoder;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Rational;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*class called in the main*/
public class VideoCreator {
    private final String VIDEO_OUTPUT_FILENAME;
    private final String SCREENSHOT_PATH;
    private final String IMAGE_EXTENSION;

    public VideoCreator(String videoOutputFilename, String screenshotPath, String imageExtension) {

        VIDEO_OUTPUT_FILENAME = videoOutputFilename;
        SCREENSHOT_PATH = screenshotPath;
        IMAGE_EXTENSION = imageExtension;

    }

    public void generateVideoBySequenceImages() {

        try {
            FileChannelWrapper outputLocation = NIOUtils.writableFileChannel(VIDEO_OUTPUT_FILENAME);

            AWTSequenceEncoder encoder = new AWTSequenceEncoder(outputLocation, Rational.R(25, 30));

            Path directoryPath = Paths.get(new File(SCREENSHOT_PATH).toURI());

            if (Files.isDirectory(directoryPath)) {
                DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath, "*." + IMAGE_EXTENSION);

                List<File> filesList = new ArrayList<>();
                for (Path path : stream) {
                    filesList.add(path.toFile());
                }
                File[] files = new File[filesList.size()];
                filesList.toArray(files);

                sortByNumber(files);

                for (File img : files) {
                    System.out.println("The image that is encodes is : " + img.getName());
                    BufferedImage image = ImageIO.read(img);
                    // Encode the image
                    encoder.encodeImage(image);
                }
            }

           encoder.finish();
            System.out.println("Video encoding is now complete");
        }

        catch (Exception e) {
            System.out.println("The video could not be exported!!");
        }
    }

    static void sortByNumber(File[] files) {
        Arrays.sort(files, new Comparator<File>() {

            @Override
            public int compare(File file1, File file2) {
                int date1 = extractNumber(file1.getName());
                int date2 = extractNumber(file2.getName());
                return date1 - date2;
            }
            private int extractNumber(String name) {
                int final_number;
                try {
                    int file1_number = name.lastIndexOf('_')+1;
                    int file2_number = name.lastIndexOf('.');
                    String number = name.substring(file1_number, file2_number);
                    final_number = Integer.parseInt(number);
                }
                catch(Exception e) {
                    final_number = 0;
                }
                return final_number;
            }
        });

    }
}
