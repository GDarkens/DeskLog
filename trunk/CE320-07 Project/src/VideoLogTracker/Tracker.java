package VideoLogTracker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tracker {

    public static void main(String[] args) {
        Tracker tracker = new Tracker("text.json");
        try {
            tracker.writeToJson("87654", "./src/VideoLogTracker");
            tracker.writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject jsonObject;
    private static JSONArray jsonArray;
    private static String filename;

    public Tracker(String JSONfilename) {
        jsonObject = new JSONObject();
        jsonArray = new JSONArray();
        filename = JSONfilename;
        try {
            if (!readFile(JSONfilename)){
                System.out.println("JSON does not exist, a new file will be created.");
            }
        } catch (IOException ignored) {}
    }

    public void writeToJson( String filename, String location) throws Exception {

        if (!jsonObject.has(location))
        {
            JSONArray array = new JSONArray();
            array.put(filename);
            jsonObject.put(location, array);
            writeToFile();
            return;
        }

        JSONArray array = (JSONArray) jsonObject.get(location);
        if (!array.toList().contains(filename)) {
            array.put(filename);
            writeToFile();
        }

    }

    protected void writeToFile() throws IOException {
        Files.write(Paths.get(filename), jsonObject.toString().getBytes());
    }

    protected boolean readFile(String fileLocation) throws IOException {

        File file = new File(fileLocation);
        if (!file.exists()) return false;
        Scanner sc = new Scanner(file);
        StringBuilder b = new StringBuilder();

        while (sc.hasNextLine()) b.append(sc.next());
        try {
            jsonObject = new JSONObject(b.toString());
        }catch (JSONException e)
        {
            System.out.println("JSON is broken, starting fresh");
            return false;
        }
        return true;
    }

    public void removeFile(String location , String filename)
    {
        JSONArray array = jsonObject.getJSONArray(location);
        for (int i = 0; i < array.length(); i++){
            if (array.get(i).equals(filename))
            {
                array.remove(i);
                i--;
            }
        }
        if (array.isEmpty())
        {
            jsonObject.remove(location);
        }
        jsonObject.remove(location);
        jsonObject.put(location, array);
    }

    public Set<String> getLocations(){return jsonObject.keySet();}
    public JSONArray getFilenames(String key){return jsonObject.getJSONArray(key);}
}



