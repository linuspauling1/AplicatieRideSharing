package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaNepreluata;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComandaNouaTest {
    private Client cl=new Client("dana","bosoanca");
    private ComandaNoua c=new ComandaNoua(cl);

    @Test
    public void testContinuare() {
        c.getTextField().setText("Test");
        c.getTextField_1().setText("Test");
        ArrayList<ComandaNepreluata> cn= Parser.getNepreluata("src/main/resources/data.xml");
        c.getBtnContinuare().doClick();
        assertEquals(cn.size()+1,Parser.getNepreluata("src/main/resources/data.xml").size());
    }

    @Test
    public void testInapoi() {
        new CustomerGUI(cl);
        c.getBtnInapoi().doClick();
        assertEquals(true,c.isB3());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        ArrayList<ComandaNepreluata> cn= Parser.getNepreluata("src/main/resources/data.xml");
        for(ComandaNepreluata tmp:cn){
            if(tmp.getLocatie().equals("Test"))
                Parser.delete(tmp,"src/main/resources/data.xml");
        }
    }
}