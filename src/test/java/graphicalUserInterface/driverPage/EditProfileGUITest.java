package graphicalUserInterface.driverPage;

import dataStructures.Sofer;
import jsonClasses.JSONFile;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditProfileGUITest {
    private Sofer s=new Sofer("ion","popescu");
    private EditProfileGUI ed=new EditProfileGUI(s);

    @Test
    public void testInapoi() {
        new DriverPage(new Sofer("ion","popescu"));
        ed.getBtnInapoi().doClick();
        assertEquals(true,ed.isB1());
    }

    @Test
    public void testSalveaza() throws Exception {
        new JSONFile();
        String p="popescu";
        ed.getPasswordField().setText(p);
        try {
            ed.getCnp().setText("1234567891011");
        }
        catch(NumberFormatException e){
            System.out.println();
        }
        ed.getCar().setText("BMW");
        ed.getNri().setText("TM10CBA");
        ed.getBtnSalveazaModificari().doClick();
        assertEquals(true, ed.isB2());
    }


}