package graphicalUserInterface.driverPage;

import dataStructures.Sofer;
import graphicalUserInterface.AutentificationGUI;
import jsonClasses.JSONFile;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverPageTest {
    private static DriverPage dp=new DriverPage(new Sofer("adi","brisan"));

    @BeforeClass
    public static void beforeClass() throws Exception {
        dp.getFrame().setVisible(false);
    }

    @Test
    public void testEdit() {
        dp.getEdit().doClick();
        assertEquals(true,dp.isB4());
    }

    @Test
    public void testAdd() {
        dp.getAdd().doClick();
        assertEquals(true,dp.isB3());
    }

    @Test
    public void testList() {
        dp.getList().doClick();
        assertEquals(true,dp.isB2());
    }

    @Test
    public void testInapoi() {
        try {
            new JSONFile();
        }catch(Exception e){
            e.printStackTrace();
        };
        new AutentificationGUI();
        dp.getInapoi().doClick();
        assertEquals(true,dp.isB1());
    }
}