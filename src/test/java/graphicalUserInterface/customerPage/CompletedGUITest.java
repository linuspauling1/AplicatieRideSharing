package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import jsonClasses.JSONClient;
import jsonClasses.JSONEditProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class CompletedGUITest {

    private CompletedGUI cgui;
    private Client client0;
    private ComandaEfectuata cn0;
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
        client0 = JSONClient.getClient().get(2);
        cn0 = new ComandaEfectuata(client0,an,luna,zi,ora,minut,secunda,
                "tm","ar", JSONEditProfile.getDriver().get(0),0,0);
        Parser.createXMLEfectuate(cn0,"src/main/resources/completed.xml");
        cgui = new CompletedGUI(client0);
        CustomerGUI cg = new CustomerGUI(client0);
    }

    @Test
    public void testCompletedGUITest() throws Exception {
        assertEquals(cgui.getUsernameSofer(),JSONEditProfile.getDriver().get(0).getUsername());
        //assertEquals(cgui.getNumarInmatriculare(),JSONEditProfile.getDriver().get(0).getNumarInmatriculare());
    }

    @Test
    public void testButtons() throws Exception {
        cgui.getBtnInapoi().doClick();
        assertEquals(cgui.isFlagInapoi(),true);

        cgui.getBtnInainte().doClick();
        assertEquals(cgui.isFlagInainte(),true);
    }

    @After
    public void again()  throws Exception {
        Parser.deleteEfectuate("src/main/resources/completed.xml");
    }
}