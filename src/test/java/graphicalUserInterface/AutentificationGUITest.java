package graphicalUserInterface;

import jsonClasses.JSONFile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AutentificationGUITest {

    private AutentificationGUI agui;

    @Before
    public void initialize() throws Exception {
        JSONFile jf = new JSONFile();
        agui = new AutentificationGUI();
    }

    @Test
    public void testFlagB() {
        agui.setFlagB(true);
        assertEquals(agui.isFlagB(),true);
    }

    @Test
    public void testFlagVerificaCredentiale1() {
        agui.setFlagVerificaCredentiale1(true);
        assertEquals(agui.isFlagVerificaCredentiale1(),true);
    }

    @Test
    public void testFlagVerificaCredentiale2() {
        agui.setFlagVerificaCredentiale2(true);
        assertEquals(agui.isFlagVerificaCredentiale2(),true);
    }

    @Test
    public void testFlagFunction() {
        agui.setFlagFunction(true);
        assertEquals(agui.isFlagFunction(),false);
    }

    @Test
    public void resetFields() throws Exception {
        agui.resetFields();
        assertEquals(agui.getT1().getText(),"");
        assertEquals(agui.getT2().getText(),"");
    }

    @Test
    public void afiseaza() {
        agui.afiseaza();
        assertEquals(agui.isFlagFunction(),true);
    }

    @Test
    public void testAutentificationGUI1() throws Exception {
        agui.getT1().setText("paul");
        agui.getT2().setText("banu");
        agui.getB().doClick();
        assertEquals(agui.isFlagB(),true);
        assertEquals(agui.isFlagVerificaCredentiale1(),true);
        assertNotEquals(agui.isFlagVerificaCredentiale2(),true);
    }

    @Test
    public void testAutentificationGUI2() {
        agui.getT1().setText("alex");
        agui.getT2().setText("borza");
        agui.getB().doClick();
        assertEquals(agui.isFlagB(),true);
        assertEquals(agui.isFlagVerificaCredentiale1(),false);
        assertNotEquals(agui.isFlagVerificaCredentiale2(),false);
    }

    @Test
    public void testAtutntificationGUI3() {
        agui.getT1().setText("");
        agui.getT2().setText("");
        assertEquals(agui.isFlagVerificaCredentiale1(),false);
        assertEquals(agui.isFlagVerificaCredentiale1(),false);
    }
}