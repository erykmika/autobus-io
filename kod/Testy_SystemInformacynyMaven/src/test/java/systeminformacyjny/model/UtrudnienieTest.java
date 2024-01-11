/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package systeminformacyjny.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author erykm
 */
public class UtrudnienieTest {
    
    public UtrudnienieTest() {
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
     * Test of getDaneUtrudnienia method, of class Utrudnienie.
     */
    @Test
    public void testGetDaneUtrudnienia() {
        System.out.println("getDaneUtrudnienia");
        Utrudnienie instance = new Utrudnienie();
        String expResult = "";
        String result = instance.getDaneUtrudnienia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDaneUtrudnienia method, of class Utrudnienie.
     */
    @Test
    public void testSetDaneUtrudnienia() {
        System.out.println("setDaneUtrudnienia");
        String daneUtrudnienia = "";
        Utrudnienie instance = new Utrudnienie();
        instance.setDaneUtrudnienia(daneUtrudnienia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
