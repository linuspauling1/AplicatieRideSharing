package DOM;

import Exceptions.ComandaEfectuataInexistanta;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import dataStructures.ComandaNepreluata;
import dataStructures.Sofer;
import jsonClasses.JSONClient;
import jsonClasses.JSONEditProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {

    private ComandaNepreluata cn;
    private ComandaEfectuata ce;
    private Client client;
    private Sofer sofer;
    private final String nume = "vasile";
    private final String parola = "passworstone";
    private final String adresa = "merelor01";
    private final String telefon = "0123";
    private final String CNP = "2345";
    private final String locatie = "timisoara";
    private final String destinatie = "budapesta";
    private final int an = 2000;
    private final int luna = 12;
    private final int zi = 31;
    private final int ora = 23;
    private final int minut = 59;
    private final int secunda = 59;
    private final int pret = 20;
    private final int distanta = 10;
    private final String review = "review";
    private static int nr1;
    private static int nr2;

    @BeforeClass
    public static void beforeClass() throws Exception {
        nr1 = (int)(Math.random()*2);
        nr2 = (int)(Math.random()*2);
    }

    @Before
    public void beforeMethods() throws Exception {
        client = JSONClient.getClient().get(nr1);//ca exemplu adaugam primul client
        cn = new ComandaNepreluata(client,an,luna,zi,ora,minut,secunda,locatie,destinatie);
        sofer = JSONEditProfile.getDriver().get(nr2);
        ce = new ComandaEfectuata(client,an,luna,zi,ora,minut,secunda,locatie,destinatie,sofer,
                0,distanta,review);
    }

    @Test
    public void citireInformatiiXML() throws Exception {
    }

    @Test
    public void afisareXML() throws Exception {
    }

    @Test
    public void adaugareInformatiiXML() throws Exception {

    }

    @Test
    public void getEfectuate() throws Exception {
    }

    @Test
    public void getNepreluata() throws Exception {
    }

    @Test
    public void citireInformatiiXMLEfectuate() throws Exception {
    }

    @Test
    public void adaugareInformatiiXMLEfectuate() throws Exception {
    }

    @Test(expected = Test.None.class)
    public void createXML() throws Exception {
        Parser.createXML(cn);
        ArrayList<ComandaNepreluata> comenziFinale = Parser.getNepreluata();
        assertEquals(comenziFinale.get(comenziFinale.size() - 1),cn);

    }

    @Test
    public void createXMLEfectuate() throws Exception {
        Parser.createXMLEfectuate(ce);
        ArrayList<ComandaEfectuata> comenziFinale = Parser.getEfectuate();
        assertEquals(comenziFinale.get(comenziFinale.size() - 1),ce);
    }

    @Test(expected = ComandaEfectuataInexistanta.class)
    public void addReview() throws Exception {
        Parser.addReview(client,"","");//testeaza si exceptia
        if(Parser.getEfectuate() != null) {
            ComandaEfectuata cmd = Parser.getEfectuate().get(0);
            String oldReview = cmd.getReview();
            Parser.addReview(cmd.getClient(), cmd.getFullDate(), "<" + cmd.getReview() + ">");
            assertNotEquals(cmd.getReview(), oldReview);
            Parser.addReview(cmd.getClient(), cmd.getFullDate(), oldReview);
            assertEquals(cmd.getReview(), oldReview);
        }
    }

    @Test
    public void delete() throws Exception {
        Parser.delete(cn);
        boolean flag = false;
        ArrayList<ComandaNepreluata> comenziFinale = Parser.getNepreluata();
        for(ComandaNepreluata tmp: comenziFinale){
            if(tmp.equals(cn))
                flag = true;}
        assertFalse(flag);
    }

    @Test
    public void deleteEfectuate() throws Exception {
        Parser.deleteEfectuate(ce);
        boolean flag = false;
        ArrayList<ComandaEfectuata> comenziFinale = Parser.getEfectuate();
        if(comenziFinale != null){
            for(ComandaEfectuata tmp: comenziFinale){
                if(tmp.equals(ce))
                    flag = true;}
        }
    }

    @Test
    public void testConstructor() {
        Parser parser = new Parser();
        assertTrue(parser instanceof Parser);
    }

    @After
    public void afterClass() throws Exception {
        Parser.delete(cn);
        Parser.deleteEfectuate(ce);
    }
}