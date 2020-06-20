package jsonClasses;

import dataStructures.Sofer;
import org.json.simple.JSONArray;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JSONEditProfileTest {
    private JSONEditProfile e=new JSONEditProfile();

    @Test
    public void testWriteDriver() {
        ArrayList<Sofer> soferi=new ArrayList<Sofer>();
        soferi.add(new Sofer("catalin","botean"));
        soferi.add(new Sofer("cosmin","marsavina"));
        JSONEditProfile.writeDriver("src/test/resources/drivers.json",soferi);
        JSONArray list=JSONFile.readFromFiles("src/test/resources/drivers.json");
        assertEquals(2,list.size());
    }

    ExpectedException rule=ExpectedException.none();
    @Test
    public void testWriteIOException() {
        ArrayList <Sofer> soferi=new ArrayList<Sofer>();
        rule.expect(IOException.class);
        JSONEditProfile.writeDriver("src/test/resources/files.json",soferi);
    }

    @Test
    public void testGetDriver() {
        ArrayList <Sofer> soferi=JSONEditProfile.getDriver();
        assertEquals(4,soferi.size());
    }

    @Test
    public void testGetSofer(){
        Sofer s=JSONEditProfile.getSofer("adi");
        assertEquals(true,s.equals(new Sofer("adi","brisan")));
    }

    ExpectedException ruleNull=ExpectedException.none();
    @Test
    public void testGetNull(){
        ruleNull.expect(NullPointerException.class);
        Sofer s=JSONEditProfile.getSofer("catalin");
    }
}