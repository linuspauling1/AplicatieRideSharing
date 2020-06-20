package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import dataStructures.ComandaNepreluata;
import jsonClasses.JSONClient;
import jsonClasses.JSONEditProfile;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomerGUITest {

    private CustomerGUI cgui;
    private Client client,client0;
    private ComandaNepreluata cn,cn0;
    private int an;
    private int luna;
    private int zi;
    private int ora;
    private int minut;
    private int secunda;
    private String locatie;
    private String destinatie;


    @Before
    public void initialize() throws Exception {
        int an = Calendar.getInstance().get(Calendar.YEAR);
        int luna = Calendar.getInstance().get(Calendar.MONTH);
        int zi = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int ora = Calendar.getInstance().get(Calendar.HOUR);
        int minut = Calendar.getInstance().get(Calendar.MINUTE);
        int secunda = Calendar.getInstance().get(Calendar.SECOND);
        client = JSONClient.getClient().get(1);
        client0 = JSONClient.getClient().get(2);
        cn0 = new ComandaEfectuata(client0,an,luna,zi,ora,minut,secunda,
                "tm","ar", JSONEditProfile.getDriver().get(0),2,0);
        cn = new ComandaNepreluata(client,an,luna,zi,ora,minut,secunda,
                "tm","ar");
        Parser.createXML(cn,"src/test/resources/data.xml");
        cgui = new CustomerGUI(client);
    }

    @Test
    public void afiseaza() {
        cgui.afiseaza();
        assertEquals(cgui.isFlagFunction(),true);
    }

    @Test
    public void activ() {
        cgui.activ();
        assertEquals(cgui.isFlagFunction0(),true);
    }

    @Test
    public void ascunde() {
        cgui.ascunde();
        assertEquals(cgui.isFlagFunction1(),true);
    }

    @Test
    public void find() {
        assertEquals(cgui.find("src/test/resources/data.xml"),true);
    }

    @Test
    public void check() {
        cgui = new CustomerGUI(client0);
        assertNotEquals(cgui.check("src/test/resources/completed.xml"),true);
    }

    @Test
    public void setOcupat() {
        cgui.setOcupat(client);
        assertEquals(cgui.isFlagFunction2(),true);
    }

    /*@After
    public void afterMethod() throws Exception {
        Parser.delete(cn,"src/test/resources/data.xml");
    }*/
}