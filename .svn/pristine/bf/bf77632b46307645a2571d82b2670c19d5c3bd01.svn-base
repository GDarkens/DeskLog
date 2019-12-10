package GUI;

import Screenshot.ScreenshotMain;
import VideoCreator.VideoCreator;
import VideoLogTracker.Tracker;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileBrowser_tests {

    @Test
    void testFileDeletion() throws Exception {
        for (int i = 0; i < 5; i++) ScreenshotMain.screenshotHandler("./src/tests");
        VideoCreator videoCreator = new VideoCreator("./src/tests/outputVideo.mp4", "./src/tests/SavedScreenshots", "jpg");
        videoCreator.generateVideoBySequenceImages();
        File file = new File("./src/tests/SavedScreenshots");
        Tracker tracker = new Tracker("test.json");
        tracker.writeToJson("outputVideo.mp4", "./src/tests");

        FileBrowser fileBrowser = new FileBrowser();

    }

}
