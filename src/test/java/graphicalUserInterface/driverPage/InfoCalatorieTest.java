package graphicalUserInterface.driverPage;

import dataStructures.Sofer;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InfoCalatorieTest {
    @BeforeClass
    public static void beforeClass() throws Exception {
        DriverPage dp = new DriverPage(new Sofer("blbl","passpass"));
    }

    @Test
    public void testButton() {
        InfoCalatorie ic = new InfoCalatorie(2);
        ic.getBtnNewButton().doClick();
        assertTrue(ic.isFlag());
    }
}