package dataStructures;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoferTest {
    private static String name="catalin";
    private static String password="botean";
    private static String numarInmatriculare="TM10ABC";
    private static String masina="BMW";
    private static Sofer sofer=new Sofer(name, password);

    @BeforeClass
    public static void beforeClass() throws Exception {
        sofer.setMasina(masina);
        sofer.setNumarInmatriculare(numarInmatriculare);
    }

    @Test
    public void testEgalitate() {
        assertEquals(true,sofer.equals(new Sofer("catalin","botean")));
    }

    @Test
    public void testNeegalitate() {
        assertEquals(false,sofer.equals(new String("cata")));
    }

    @Test
    public void testToString() {
        String st="Sofer{" +
                "numarInmatriculare='" + numarInmatriculare + '\'' +
                ", masina='" + masina + '\'' +
                '}';;
        assertEquals(st,sofer.toString());
    }

    @Test
    public void testGetUsername() {
        String nume=sofer.getUsername();
        assertEquals(name,nume);
    }

    @Test
    public void testGetPassword(){
        String parola=sofer.getPassword();
        assertEquals(password, parola);
    }

    @Test
    public void testGetNumarInmatriculare(){
        String nrInmatriculare=sofer.getNumarInmatriculare();
        assertEquals(numarInmatriculare,nrInmatriculare);
    }

    @Test
    public void testGetMasina(){
        String car=sofer.getMasina();
        assertEquals(masina,car);
    }

    @Test
    public void testChangeCar() {
        String newCar="Mercedes";
        sofer.setMasina(newCar);
        assertEquals(newCar,sofer.getMasina());
        masina=newCar;
    }

    @Test
    public void testChangeNumarInmatriculare() {
        String newNr="AR10CBA";
        sofer.setNumarInmatriculare(newNr);
        assertEquals(newNr,sofer.getNumarInmatriculare());
        numarInmatriculare=newNr;
    }

}