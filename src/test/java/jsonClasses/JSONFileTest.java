package jsonClasses;

import dataStructures.Client;
import org.json.simple.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

public class JSONFileTest {
    private static JSONFile jf;

    @BeforeClass
    public static void beforeClass() throws Exception {
        jf=new JSONFile();
    }

    @Test
    public void testReadFromFiles() {
        String path="src/test/resources/customers.json";
        JSONArray list=JSONFile.readFromFiles(path);
        assertEquals(5,list.size());
    }

    ExpectedException rule=ExpectedException.none();
    @Test
    public void testIOException() {
        rule.expect(IOException.class);
        String path="src/test/resources/file.json";
        JSONArray list=JSONFile.readFromFiles(path);
    }

    @Test
    public void testEncryptPassword() {
        String plainPassword="botean";
        assertEquals("W5eacBCfnWQ=",JSONFile.encrypt(plainPassword));
    }

    @Test
    public void testDecryptPassword() {
        String encryptedPassword="W5eacBCfnWQ=";
        assertEquals("botean",JSONFile.decrypt(encryptedPassword));
    }

    @Test
    public void testVerificaCredentiale(){
        String path="src/test/resources/customers.json";
        Client c=new Client("cosmin","marsavina");
        assertEquals(true,JSONFile.verificaCredentiale(path,c));
    }

    @Test
    public void testCredentialeIncorecte(){
        String path="src/test/resources/customers.json";
        Client c=new Client("cosmin","cosmin");
        assertNotEquals(true,JSONFile.verificaCredentiale(path,c));
    }
}