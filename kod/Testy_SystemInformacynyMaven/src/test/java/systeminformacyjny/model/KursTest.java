/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package systeminformacyjny.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import mockit.Expectations;
import mockit.VerificationsInOrder;
import mockit.Mocked;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 *
 * @author erykm
 */
public class KursTest {
    
    public KursTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getIdKursu method, of class Kurs.
     */
    @Test
    public void testGetIdKursu() {
        System.out.println("getIdKursu");
        Kurs instance = new Kurs();
        int expResult = 0;
        int result = instance.getIdKursu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdKursu method, of class Kurs.
     */
    @Test
    public void testSetIdKursu() {
        System.out.println("setIdKursu");
        int idKursu = 0;
        Kurs instance = new Kurs();
        instance.setIdKursu(idKursu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpoznienie method, of class Kurs.
     */
    @Test
    public void testGetOpoznienie() {
        System.out.println("getOpoznienie");
        Kurs instance = new Kurs();
        Opoznienie expResult = null;
        Opoznienie result = instance.getOpoznienie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOpoznienie method, of class Kurs.
     */
    @Test
    public void testSetOpoznienie() {
        System.out.println("setOpoznienie");
        Opoznienie opoznienie = null;
        Kurs instance = new Kurs();
        instance.setOpoznienie(opoznienie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtrudnienia method, of class Kurs.
     */
    @Test
    public void testGetUtrudnienia() {
        System.out.println("getUtrudnienia");
        Kurs instance = new Kurs();
        List<Utrudnienie> expResult = null;
        List<Utrudnienie> result = instance.getUtrudnienia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtrudnienia method, of class Kurs.
     */
    @Test
    public void testSetUtrudnienia() {
        System.out.println("setUtrudnienia");
        List<Utrudnienie> utrudnienia = null;
        Kurs instance = new Kurs();
        instance.setUtrudnienia(utrudnienia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRozkladJazdy method, of class Kurs.
     */
    @Test
    public void testGetRozkladJazdy() {
        System.out.println("getRozkladJazdy");
        Kurs instance = new Kurs();
        RozkladJazdyKursu expResult = null;
        RozkladJazdyKursu result = instance.getRozkladJazdy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRozkladJazdy method, of class Kurs.
     */
    @Test
    public void testSetRozkladJazdy() {
        System.out.println("setRozkladJazdy");
        RozkladJazdyKursu rozkladJazdy = null;
        Kurs instance = new Kurs();
        instance.setRozkladJazdy(rozkladJazdy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
