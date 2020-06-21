package graphicalUserInterface.customerPage;

import dataStructures.Client;
import dataStructures.ComandaNepreluata;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CommandGUITest {
    private Client c=new Client("dana","bosoanca");

    @Test
    public void testCalculeazaTimp() {
        ComandaNepreluata cn=new ComandaNepreluata(c, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+1,Calendar.getInstance().get(Calendar.HOUR),Calendar.getInstance().get(Calendar.MINUTE),Calendar.getInstance().get(Calendar.SECOND),"a","b");
        int t=CommandGUI.calculeazaTimpRamas(cn);
        assertEquals(true,t>0);
    }

    @Test
    public void testVerificaData() {
        ComandaNepreluata cn=new ComandaNepreluata(c, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+1,Calendar.getInstance().get(Calendar.HOUR),Calendar.getInstance().get(Calendar.MINUTE),Calendar.getInstance().get(Calendar.SECOND),"a","b");
        assertEquals(true,CommandGUI.verificaData(cn));
    }
}