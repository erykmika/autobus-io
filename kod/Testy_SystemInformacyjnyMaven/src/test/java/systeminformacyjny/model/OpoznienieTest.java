/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package systeminformacyjny.model;

import SystemInformacyjnyLinii.Dane;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import java.util.IllegalFormatCodePointException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author erykm
 */
public class OpoznienieTest {
    
    public OpoznienieTest() {
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
     * Test of getWartosc method, of class Opoznienie.
     */
    @Test
    public void testGetWartosc() {
        System.out.println("getWartosc");
        Opoznienie instance = new Opoznienie();
        int expResult = 0;
        int result = instance.getWartosc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWartosc method, of class Opoznienie.
     */
    @Test
    public void testSetWartosc() {
        System.out.println("setWartosc");
        int wartosc = 0;
        Opoznienie instance = new Opoznienie();
        instance.setWartosc(wartosc);
        assertEquals(wartosc, instance.getWartosc());
    }
    
    @ParameterizedTest
    @CsvSource({"10", "11", "12", "13", "14"})
    public void testSetWartoscCsv(int liczba) {
        System.out.println("setWartoscCsv");
        int wartosc = liczba;
        Opoznienie instance = new Opoznienie();
        instance.setWartosc(wartosc);
        assertEquals(wartosc, instance.getWartosc());
    }
    
}
