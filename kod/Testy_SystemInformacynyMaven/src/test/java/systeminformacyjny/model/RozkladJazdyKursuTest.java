/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package systeminformacyjny.model;

import SystemInformacyjnyLinii.Dane;
import java.util.List;
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
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;

/**
 *
 * @author erykm
 */
@Tag("Entity") //określenie kategorii testu, zastosowanie - p.2.7.1, 2.7.3
public class RozkladJazdyKursuTest {

    Dane dane;

    public RozkladJazdyKursuTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        dane = new Dane();
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getGodziny method, of class RozkladJazdyKursu.
     */
    @Test
    public void testGetGodziny() {
        System.out.println("getGodziny");
        RozkladJazdyKursu instance = Dane.rozklady[0];
        List<Integer> expResult = Dane.lista2D.get(0);
        List<Integer> result = instance.getGodziny();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGodziny method, of class RozkladJazdyKursu.
     */
    @Test
    public void testSetGodziny() {
        System.out.println("setGodziny");
        List<Integer> godziny = Dane.lista2D.get(1);
        RozkladJazdyKursu instance = Dane.rozklady[1];
        instance.setGodziny(godziny);
        assertEquals(godziny, Dane.rozklady[1].getGodziny());
    }

    /*
    @ParameterizedTest
    @CsvSource({"10", "11", "12", "13", "14"})
    public void testSetGodzinyCsv() {
        System.out.println("setGodziny");
        List<Integer> godziny = Dane.lista2D.get(1);
        RozkladJazdyKursu instance = Dane.rozklady[1];
        instance.setGodziny(godziny);
        assertEquals(godziny, Dane.rozklady[1].getGodziny());
    }
     */
    @ParameterizedTest()
    @MethodSource("provideArguments")
    public void testMethodSource(List<RozkladJazdyKursu> rozklady) {
        assertEquals(expected, Strings.isBlank(input));
    }

    static public Stream<Arguments> provideArguments() {
        return Stream.of(arguments(Dane.rozklady));
    }
}
