import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        new Main();

        List<WindowInfo> windowList = new ArrayList<>();

        User32.instance.EnumWindows(new WndEnumProc() {
            @Override
            public boolean callback(int hWnd, int lParam) {

                if (User32.instance.IsWindowVisible(hWnd)) {
                    User32.instance.GetWindowRect(hWnd);


                    byte[] buffer = new byte[1024];
                    User32.instance.GetWindowTextA(hWnd, buffer, buffer.length);
                    String title = Native.toString(buffer);

                    if (!title.equals("")) {
                        windowList.add(new WindowInfo(hWnd, title));
                    }

                }
                return true;
            }
        }, 0);

        for (WindowInfo w : windowList) {
            System.out.println(w);
        }
    }

    public interface WndEnumProc extends StdCallLibrary.StdCallCallback {
        boolean callback(int hWnd, int lParam);
    }

    public interface User32 extends StdCallLibrary {
        User32 instance = (User32) Native.loadLibrary ("user32", User32.class);

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