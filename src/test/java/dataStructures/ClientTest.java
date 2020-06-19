package dataStructures;

import Exceptions.CNPException;
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
    public void initializeClient() throws Exception {
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

    @Test(expected = CNPException.class)
    public void setCNP() throws Exception {
        client.setCNP(alfanumeric);
        assertEquals(client.isFlag(),true);
        client.setCNP(altCNP);
        assertNotEquals(client.getCNP(),CNP);
    }

    @Test
    public void testIsNumeric() throws Exception {
        assertEquals(client.isNumeric(alfanumeric),false);
        assertEquals(client.isNumeric(CNP),true);
        assertNotEquals(client.isNumeric(null),true);
    }

    @Test
    public void setTelefon() throws Exception {
        client.setTelefon(altTelefon);
        assertNotEquals(client.getTelefon(),telefon);
    }

    @Test
    public void setAdresa() throws Exception {
        client.setAdresa(altaAdresa);
        assertNotEquals(client.getAdresa(),adresa);
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
        assertNotEquals(client,null);
    }

    @Test
    public void testIsFlag() {
        assertNotNull(client.isFlag());
    }
}