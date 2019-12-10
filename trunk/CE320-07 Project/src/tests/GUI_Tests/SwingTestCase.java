package tests.GUI_Tests;
import GUI.Frame;
import junit.framework.TestCase;
import javax.swing.*;

public class SwingTestCase extends TestCase {

    private Frame guiFrame;

    @Override
    protected void tearDown() throws Exception {
        if (this.guiFrame != null) {
            this.guiFrame.dispose();
            this.guiFrame = null;
        }
    }

    public JFrame getTestFrame(  ) {
        if (this.guiFrame == null) {
            this.guiFrame = new Frame();
        }

        return this.guiFrame;
    }


}

