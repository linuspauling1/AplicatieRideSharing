package dataStructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ComandaNepreluataTest {
//redundante primul test cauzate de before
    private ComandaNepreluata cn;
    private ComandaNepreluata copy;
    private Client client;
    private String string;
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

    @Before
    public void beforeMethods() throws Exception {
        client = new Client(nume,parola);
        client.setTelefon(telefon);
        client.setAdresa(adresa);
        client.setCNP(CNP);
        cn = new ComandaNepreluata(client,an,luna,zi,ora,minut,secunda,locatie,destinatie);
        copy = new ComandaNepreluata(client,an,luna,zi,ora,minut,secunda,locatie,destinatie);
        string = client.toString() + ", de la: " + locatie + ", pentru: " + destinatie;
    }

    @Test
    public void getAdresa() {
        assertEquals(cn.getAdresa(),client.getAdresa());
    }

    @Test
    public void getTelefon() throws Exception {
        assertEquals(cn.getTelefon(),client.getTelefon());
    }

    @Test
    public void getUsernameClient() throws Exception {
        assertEquals(cn.getUsernameClient(),client.getUsername());
    }

    @Test
    public void getCNPClient() throws Exception {
        assertEquals(cn.getCNPClient(),client.getCNP());
    }

    @Test
    public void getAn() throws Exception {
        assertEquals(cn.getAn(),an);
    }

    @Test
    public void getLuna() throws Exception {
        assertEquals(cn.getLuna(),luna);
    }

    @Test
    public void getZi() throws Exception {
        assertEquals(cn.getZi(),zi);
    }

    @Test
    public void getOra() throws Exception {
        assertEquals(cn.getOra(),ora);
    }

    @Test
    public void getMinut() throws Exception {
        assertEquals(cn.getMinut(),minut);
    }

    @Test
    public void getSecunda() throws Exception {
        assertEquals(cn.getSecunda(),secunda);
    }

    @Test
    public void getLocatie() throws Exception {
        assertEquals(cn.getLocatie(),locatie);
    }

    @Test
    public void setLocatie() throws Exception {
        cn.setLocatie(destinatie);
        assertEquals(cn.getLocatie(),destinatie);
    }

    @Test
    public void getDestinatie() throws Exception {
        assertEquals(cn.getDestinatie(),destinatie);
    }

    @Test
    public void setDestinatie() throws Exception {
        cn.setDestinatie(locatie);
        assertEquals(cn.getDestinatie(),locatie);
    }

    @Test
    public void getClient() throws Exception {
        assertEquals(cn.getClient(),client);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(cn.toString(),string);
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(true,cn.equals(copy));
        assertNotEquals(true,cn.equals(null));
        assertNotEquals(true,cn.equals(new ComandaNepreluata(client,
                0,0,0,0,0,0,"","")));
    }

}