package graphicalUserInterface.driverPage;

import dataStructures.Sofer;
import org.junit.Test;

import static org.junit.Assert.*;

public class VizualizareComenziTest {
    private Sofer s=  new Sofer("adi","brisan");
    private VizualizareComenzi c=new VizualizareComenzi(s);

    @Test
    public void test() {
        new DriverPage(s);
        c.getBtnNewButton().doClick();
        assertEquals(true,c.isB());
    }
}