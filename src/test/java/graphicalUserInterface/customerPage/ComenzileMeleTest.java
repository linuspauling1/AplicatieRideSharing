package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComenzileMeleTest {

    private static ComenzileMele cm;

    @BeforeClass
    public static void beforeClass() throws Exception {
        cm = new ComenzileMele(new Client("vasile","ion"));
    }

    @Test
    public void testComenzileMele() throws Exception {
        assertTrue(cm.isFlag());
        assertEquals(Parser.getEfectuate("src/main/resources/completed.xml")
                != null,cm.isFlag0());
    }

    @Test
    public void testButton() throws Exception {
        try{
            cm.getBtnInapoi().doClick();
        }catch (NullPointerException e){

        }
        assertTrue(cm.isFlag1());
    }
}