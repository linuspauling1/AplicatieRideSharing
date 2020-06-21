package graphicalUserInterface.driverPage;

import DOM.Parser;
import dataStructures.Sofer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ListaComenziTest {

    private ListaComenzi lc;

    @Before
    public void beforeMethod() throws Exception {
        DriverPage dp = new DriverPage(new Sofer("abc","cde"));
        lc = new ListaComenzi(Parser.getNepreluata("src/main/resources/data.xml"));
    }

    @Test
    public void testListaComenzi() throws Exception {
        lc.getTextPane().setText("");
        try{
            lc.getLblNewLabel().doClick();
            assertTrue(lc.isFlag2());
        } catch (NumberFormatException e){

        }
        lc.getBtnInapoi().doClick();
        assertTrue(lc.isFlag1());
    }
}