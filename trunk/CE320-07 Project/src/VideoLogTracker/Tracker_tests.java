package VideoLogTracker;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Track;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tracker_tests {
    @Test
    private void testCreateJSONFile()
    {
        Tracker tracker = new Tracker("test.json");
        try {
            tracker.writeToJson("TEST.TEST", "./TEST");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(new File("./test.json").exists());
    }
    @Test
    private void teatFileContains()
    {
        File file = new File("./test.json");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
        }
        StringBuilder b = new StringBuilder();

        while (sc.hasNextLine()) b.append(sc.next());
        try {
            JSONObject jsonObject = new JSONObject(b.toString());
            assertTrue(!jsonObject.isEmpty());
        }catch (JSONException e)
        {
        }
    }
}
