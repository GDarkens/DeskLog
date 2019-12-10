package VideoCreator;

import Screenshot.ScreenshotMain;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoCreator_Tests {


    @Test
    public void testOutputVideo()
    {

        for (int i = 0; i < 2; i++) ScreenshotMain.screenshotHandler("./src/tests");
        VideoCreator videoCreator = new VideoCreator("./src/tests/outputVideo.mp4", "./src/tests/SavedScreenshots", "jpg");
        videoCreator.generateVideoBySequenceImages();
        File video = new File("./src/tests/outputVideo.mp4");
        assertTrue(video.exists());
    }

    @Test
    public void testSortFunction()
    {
        File file1 = new File("./src/tests/12345");
        File file2 = new File("./src/tests/23456");
        try {
            file1.createNewFile();
            file2.createNewFile();

            List<File> fileList = new ArrayList<>();
            fileList.add(file1);
            fileList.add(file2);

            File[] files = new File[fileList.size()];
            fileList.toArray(files);


            VideoCreator.sortByNumber(files);

            assertTrue(Integer.parseInt(files[0].getName()) < Integer.parseInt(files[1].getName()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testScreenshotsAreNotDeleted()
    {
        for (int i = 0; i < 5; i++) ScreenshotMain.screenshotHandler("./src/tests");
        VideoCreator videoCreator = new VideoCreator("./src/tests/outputVideo.mp4", "./src/tests/SavedScreenshots", "jpg");
        videoCreator.generateVideoBySequenceImages();
        File file = new File("./src/tests/SavedScreenshots");
        if(file.isDirectory()) assertTrue(Objects.requireNonNull(file.list()).length > 0);
    }
}
