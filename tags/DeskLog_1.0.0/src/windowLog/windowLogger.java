package windowLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;


public class windowLogger{
    private static String filePath;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");

    static {
        try {
            filePath = new File(".").getCanonicalPath();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path path = Paths.get(filePath, "programLog.txt");

    public static void main() throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        StringBuilder fileOutput = new StringBuilder();


        List<WindowInfo> windowList = returnOpenWindows();

        fileOutput.append("[").append(dateTimeFormatter.format(currentTime)).append("]").append("(");

        for (WindowInfo windowName : windowList){
            fileOutput.append(windowName).append(", ");
        }

        fileOutput.replace(fileOutput.length() - 2, fileOutput.length(), "");
        fileOutput.append(")");

        //Only writes line to file if program list is different
        String newProgramLine = fileOutput.toString().substring(21);
        if(haveProgramsChanged(newProgramLine)){
            Files.write(path, Collections.singleton(fileOutput), StandardOpenOption.APPEND);
        }
    }

    private static Boolean haveProgramsChanged(String newProgramLine) throws IOException {
        /*
        Returns true if currently open window list has changed
         */

        String last = null, store;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()));

        while ((store = bufferedReader.readLine()) != null){
            last = store;
        }

        if (last != null) {
            last = last.substring(21); //Removes the [yyyy/mm/dd HH:hh:ss] at the beginning
        }

        return !newProgramLine.equals(last);
    }


    protected static List<WindowInfo> returnOpenWindows(){
        new windowLogger();

        List<WindowInfo> windowGrabList = new ArrayList<>();

        User32.instance.get().EnumWindows((hWnd, lParam) -> {
            if (User32.instance.get().IsWindowVisible(hWnd)) {
                User32.instance.get().GetWindowRect(hWnd);

                byte[] buffer = new byte[1024];
                User32.instance.get().GetWindowTextA(hWnd, buffer, buffer.length);
                String title = Native.toString(buffer);

                if (!title.equals("")) {
                    windowGrabList.add(new WindowInfo(hWnd, title));
                }

            }
            return true;
        }, 0);
        return windowGrabList;
    }


    public interface WndEnumProc extends StdCallLibrary.StdCallCallback {
        boolean callback(int hWnd, int lParam);
    }

    public interface User32 extends StdCallLibrary {
        ThreadLocal<User32> instance = ThreadLocal.withInitial(() -> Native.loadLibrary("user32", User32.class));

        void EnumWindows(WndEnumProc wndenumproc, int lParam);
        boolean IsWindowVisible(int hWnd);
        void GetWindowRect(int hWnd);
        void GetWindowTextA(int hWnd, byte[] buffer, int bufferLen);
    }

    public static class WindowInfo {
        final int windowHandle;

        final String title;
        WindowInfo(int windowHandle, String title) {
            this.windowHandle = windowHandle;
            this.title = title;
        }

        public String toString() {
            return title;
        }
    }
}