package dataStructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComandaEfectuataTest {

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
    private final String numeSofer = "nume";
    private final String parolaSofer = "parola";
    private final String review = "review";
    private final String reviewCopy = "blabla";
    private final String masina = "alfa";
    private final String numar = "tm100aba";
    private final String cnp = "0582";
    private final int pret = 20;
    private final int distanta = 10;
    private String fullDate;
    private Date realDate;

    @Before
    public void initialize() throws Exception {
        client = new Client(nume,parola);
        client.setTelefon(telefon);
        client.setAdresa(adresa);
        client.setCNP(CNP);
        sofer = new Sofer(numeSofer,parolaSofer);
        sofer.setMasina(masina);
        sofer.setNumarInmatriculare(numar);
        sofer.setCNP(cnp);
        ce = new ComandaEfectuata(client,an,luna,zi,ora,minut,secunda,locatie,destinatie,sofer,
                pret,distanta,review);
        fullDate = an + "/" + luna + "/" + zi + "/" + ora + "/" + minut + "/" + secunda;
    }

    @Test
    public void getPret() throws Exception {
        assertEquals(ce.getPret(),pret);
    }

    @Test
    public void getDistanta() throws Exception {
        assertEquals(ce.getDistanta(),distanta);
    }

    @Test
    public void getUsernameSofer() throws Exception {
        assertEquals(ce.getUsernameSofer(),sofer.getUsername());
        assertEquals(new ComandaEfectuata(null,0,0,0,0,0,0,
                "","",null,0,0).getUsernameSofer(),"");
    }

    @Test
    public void getCNPSofer() throws Exception {
        assertEquals(ce.getCNPSofer(),sofer.getCNP());
    }

    @Test
    public void getNumarInmatriculare() throws Exception {
        assertEquals(ce.getNumarInmatriculare(),sofer.getNumarInmatriculare());
    }

    @Test
    public void getMasina() throws Exception {
        assertEquals(ce.getMasina(),sofer.getMasina());
    }

    @Test
    public void setReview() throws Exception {
        ce.setReview(reviewCopy);
        assertEquals(ce.getReview(),reviewCopy);
    }

    @Test
    public void getReview() throws Exception {
        assertEquals(ce.getReview(),review);
    }

    @Test
    public void getFullDate() throws Exception {
        assertEquals(ce.getFullDate(),fullDate);
    }

    @Test
    public void getSofer() throws Exception {
        assertEquals(ce.getSofer(),sofer);
    }

    @Test
    public void addChar() throws Exception {
        assertEquals(ce.addChar("str",'Z',2),"stZr");
    }

    @Test
    public void parseDateTime() throws Exception {
        assertTrue(ce.parseDateTime("20001231235959") instanceof Date);
        assertEquals(ce.parseDateTime("121212"),null);
    }

}