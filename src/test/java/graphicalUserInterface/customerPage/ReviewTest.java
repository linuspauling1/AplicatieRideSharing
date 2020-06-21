package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import jsonClasses.JSONClient;
import jsonClasses.JSONEditProfile;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ReviewTest {

    private Client client;
    private ComandaEfectuata ce;
    private int an;
    private int luna;
    private int zi;
    private int ora;
    private int minut;
    private int secunda;
    private String locatie;
    private String destinatie;
    private Review recenzie;


    @Before
    public void initialize() throws Exception {
        int an = Calendar.getInstance().get(Calendar.YEAR);
        int luna = Calendar.getInstance().get(Calendar.MONTH);
        int zi = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int ora = Calendar.getInstance().get(Calendar.HOUR);
        int minut = Calendar.getInstance().get(Calendar.MINUTE);
        int secunda = Calendar.getInstance().get(Calendar.SECOND);
        client = JSONClient.getClient().get(2);
        ce = new ComandaEfectuata(client,an,luna,zi,ora,minut,secunda,
                "tm","ar", JSONEditProfile.getDriver().get(0),0,0);
        Parser.createXMLEfectuate(ce,"src/main/resources/completed.xml");
        CustomerGUI cg = new CustomerGUI(client);
        recenzie = new Review(client);
    }

    /*@Test
    public void testReview2() {
        String s = "haha";
        boolean flag = false;
        recenzie.getTextField_1().setText(ce.getFullDate());
        recenzie.getTextField().setText(s);
        recenzie.getBtnNewButton().doClick();
        ArrayList<ComandaEfectuata> ce = Parser.getEfectuate(
                "src/main/resources/completed.xml");
        for(ComandaEfectuata tmp: ce)
            if(tmp.getReview().equals(s))
                flag = true;
        assertTrue(flag);
    }*/

    @Test
    public void testBack() {
        recenzie.getBtnInapoi().doClick();
        assertEquals(recenzie.isFlag1(),true);
    }
}