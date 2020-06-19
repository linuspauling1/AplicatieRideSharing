package dataStructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    private Client client;
    private Client copy;
    private String string;
    private final String user = "ion";
    private final String parola = "parolevici";
    private final String CNP = "123";
    private final String altCNP = "1234";
    private final String adresa = "adresa";
    private final String altaAdresa = "altaAdresa";
    private final String telefon = "0123";
    private final String altTelefon = "01235";
    private final String alfanumeric = "ab33jjj";

    @Before
    public void initializeClient(){
        client = new Client(user,parola);
        copy = new Client(user,parola);
        string = "Client { " + user + " } ";
        client.setCNP(CNP);
        client.setAdresa(adresa);
        client.setTelefon(telefon);
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals(client.getUsername(),user);
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals(client.getPassword(),parola);
    }

    @Test
    public void getCNP() throws Exception {
        assertEquals(client.getCNP(),CNP);
    }

    @Test
    public void setCNP() throws Exception {
        client.setCNP(altCNP);
        assertNotEquals(client.getCNP(),CNP);
        client.setCNP(CNP);
    }

    @Test
    public void testIsNumeric1() throws Exception {
        assertEquals(client.isNumeric(user),false);
    }

    @Test
    public void testIsNumeric2() throws Exception {
        assertEquals(client.isNumeric(CNP),true);
    }

    @Test
    public void setTelefon() throws Exception {
        client.setTelefon(altTelefon);
        assertNotEquals(client.getTelefon(),telefon);
        client.setTelefon(telefon);
    }

    @Test
    public void setAdresa() throws Exception {
        client.setAdresa(altaAdresa);
        assertNotEquals(client.getAdresa(),adresa);
        client.setTelefon(adresa);
    }

    @Test
    public void getAdresa() throws Exception {
        assertEquals(client.getAdresa(),adresa);
    }

    @Test
    public void getTelefon() throws Exception {
        assertEquals(client.getTelefon(),telefon);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(client.toString(),string);
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(client,copy);
    }
}