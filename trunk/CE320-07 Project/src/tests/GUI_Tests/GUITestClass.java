package tests.GUI_Tests;
import GUI.BottomPanel;
import GUI.Frame;
import GUI.MiddlePanel;
import GUI.TopPanel;
import junit.framework.TestCase;
import javax.swing.*;
import static org.jcodec.common.Assert.assertEquals;


public class GUITestClass extends TestCase {

    private MiddlePanel middlePanel = new MiddlePanel();

    private TestCase test = new GUITestClass(){
        public void runTest(){
            testAdd();
        }
    };


    public void testAdd(){
        assertEquals("GUI Frame rate slider is enabled", 1, this.middlePanel.frameRateSlider.getValue());
    }

    public void setUp() throws Exception {
        // create a panel without a Person
        Frame guiFrame = new Frame();

        BottomPanel bottomPanel = new BottomPanel();
        middlePanel = new MiddlePanel();
        TopPanel topPanel = new TopPanel();
        test.run();
    }

    private Frame guiFrame;

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