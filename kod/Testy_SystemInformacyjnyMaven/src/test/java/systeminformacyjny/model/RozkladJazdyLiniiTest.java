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
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;
import java.util.stream.IntStream;
/**
 *
 * @author Michal
 */
@Tag("Entity")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RozkladJazdyLiniiTest implements TestExecutionExceptionHandler {
    
    Dane dane;
    
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof IllegalArgumentException) {
            System.out.println("Wyjatek!");
        } else {
            throw throwable;
        }
    }
    
    public RozkladJazdyLiniiTest() {
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
     * Test of getRozkladyKursow method, of class RozkladJazdyLinii.
     */
    
    @Test
    @Order(2)
    public void testGetRozkladyKursow() {
        System.out.println("getRozkladyKursow");
        RozkladJazdyLinii instance = Dane.rozkladyLinia[0];
        List<RozkladJazdyKursu> expResult = Dane.rKurs.get(0);
        List<RozkladJazdyKursu> result = instance.getRozkladyKursow();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setRozkladyKursow method, of class RozkladJazdyLinii.
     */
    
    @Test
    @Order(1)
    public void testSetRozkladyKursow() {
        System.out.println("setRozkladyKursow");
        List<RozkladJazdyKursu> rozkladyKursow = Dane.rKurs.get(1);
        RozkladJazdyLinii instance = Dane.rozkladyLinia[1];
        instance.setRozkladyKursow(rozkladyKursow);
        assertEquals(rozkladyKursow, Dane.rozkladyLinia[1].getRozkladyKursow());
    }
    
    @ParameterizedTest
    @Order(3)
    @MethodSource("provideArguments")
    public void test2GetRozkladyKursow(RozkladJazdyLinii rozkladyLinia, List<Integer> rKurs) {
        System.out.println("testMethodSource");
        assertEquals(rKurs, rozkladyLinia.getRozkladyKursow());
    }

    static public Stream<Arguments> provideArguments() {
        return IntStream.range(0, Dane.rozkladyLinia.length)
                .mapToObj(index -> arguments(Dane.rozkladyLinia[index], Dane.rKurs.get(index)));
    }

    @Test
    @Order(5)
    @ExtendWith(RozkladJazdyLiniiTest.class)
    public void test2SetRozkladyKursow()
    {
        System.out.println("testIfThrowsException");
        List<RozkladJazdyKursu> pustaLista = new ArrayList<>(); 
        Dane.rozkladyLinia[0].setRozkladyKursow(pustaLista);
    }
    
    @ParameterizedTest
    @Order(4)
    @CsvSource({"1", "0"})
    public void test2GetRozkladyKursow(int liczba) {
        System.out.println("getWartoscCsv");
        assertEquals(Dane.rozkladyLinia[liczba].getRozkladyKursow(), Dane.rKurs.get(liczba));
    }
}

