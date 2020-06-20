package graphicalUserInterface.driverPage;

import dataStructures.Client;
import dataStructures.ComandaNepreluata;
import dataStructures.Sofer;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfoClientTest {
    private InfoClient ic=new InfoClient(new ComandaNepreluata(new Client("catalin","botean"),2020,6,20,21,56,2,"a","b"));
    @Test
    public void testTerminare() {
        ic.getBtnTerminareComanda().doClick();
        assertNotEquals(false,ic.isB1());
    }

    @Test
    public void testInapoi() {
        new DriverPage(new Sofer("adi","sofer"));
        ic.getBtnNewButton().doClick();
        assertEquals(true,ic.isB2());
    }

    @Test
    public void testCautaClient() {
        ic.cautaClient();
        assertEquals(new Client("catalin","botean"),ic.getClient());
    }
}