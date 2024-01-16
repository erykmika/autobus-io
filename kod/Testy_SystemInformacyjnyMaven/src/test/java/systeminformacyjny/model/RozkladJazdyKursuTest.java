/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package systeminformacyjny.model;

import SystemInformacyjnyLinii.Dane;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;
import java.util.stream.IntStream;

/**
 *
 * @author erykm
 */
@Tag("Entity")
public class RozkladJazdyKursuTest implements TestExecutionExceptionHandler {

    Dane dane;

    // Obsluga wyjatku - ustawienie pustej listy godzin
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof IllegalArgumentException) {
            System.out.println("Wyjatek!");
        } else {
            throw throwable;
        }
    }

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
        List<Integer> expResult = Dane.godziny.get(0);
        List<Integer> result = instance.getGodziny();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGodziny method, of class RozkladJazdyKursu.
     */
    @Test
    public void testSetGodziny() {
        System.out.println("setGodziny");
        List<Integer> godziny = Dane.godziny.get(1);
        RozkladJazdyKursu instance = Dane.rozklady[1];
        instance.setGodziny(godziny);
        assertEquals(godziny, Dane.rozklady[1].getGodziny());
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void testMethodSource(RozkladJazdyKursu rozklady, List<Integer> godziny) {
        System.out.println("testMethodSource");
        assertEquals(godziny, rozklady.getGodziny());
    }

    static public Stream<Arguments> provideArguments() {
        return IntStream.range(0, Dane.rozklady.length)
                .mapToObj(index -> arguments(Dane.rozklady[index], Dane.godziny.get(index)));
    }
    
    @Test
    @ExtendWith(RozkladJazdyKursuTest.class)
    public void testIfThrowsException()
    {
        System.out.println("testIfThrowsException");
        List<Integer> pustaLista = new ArrayList<>();
        Dane.rozklady[0].setGodziny(pustaLista);
    }
    
    @ParameterizedTest
    @CsvSource({"3", "2", "0", "1"})
    public void testGetGodzinyCsv(int liczba) {
        System.out.println("getWartoscCsv");
        assertEquals(Dane.rozklady[liczba].getGodziny(), Dane.godziny.get(liczba));
    }
}
