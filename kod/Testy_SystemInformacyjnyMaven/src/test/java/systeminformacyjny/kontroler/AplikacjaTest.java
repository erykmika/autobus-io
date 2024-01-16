/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package systeminformacyjny.kontroler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import systeminformacyjny.model.Linia;
import systeminformacyjny.model.Przystanek;
import systeminformacyjny.model.RozkladJazdyLinii;
import systeminformacyjny.model.RozkladJazdyKursu;
import systeminformacyjny.model.Kurs;
import systeminformacyjny.model.Trasa;
import systeminformacyjny.model.Opoznienie;
import java.util.Arrays;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.junit.jupiter.params.provider.Arguments;


/**
 *
 * @author klaudia
 */

@Tag("Control")
public class AplikacjaTest{
    
private Aplikacja aplikacja;
private Linia liniaTestowa;
private Przystanek przystanek1;
private Przystanek przystanek2;
private Kurs kursTestowy;

    
    public AplikacjaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    aplikacja = new Aplikacja();

    liniaTestowa = new Linia();
    liniaTestowa.setId(1);

    przystanek1 = new Przystanek();
    przystanek1.setNazwa("Zielona");
    przystanek2 = new Przystanek();
    przystanek2.setNazwa("Niebieska");

    liniaTestowa.setPrzystanki(Arrays.asList(przystanek1, przystanek2));


    kursTestowy = new Kurs();
    kursTestowy.setIdKursu(1);
    kursTestowy.setOpoznienie(new Opoznienie());
    kursTestowy.setRozkladJazdy(new RozkladJazdyKursu());
    kursTestowy.getRozkladJazdy().setGodziny(Arrays.asList(8, 10, 12));

    liniaTestowa.setKursy(Arrays.asList(kursTestowy));
    aplikacja.getLinie().add(liniaTestowa);
    aplikacja.getPrzystanki().addAll(Arrays.asList(przystanek1, przystanek2));

    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of pobierzRozkladJazdyLinii method, of class Aplikacja.
     */
    @Order(1)
    @Tag("Rozklady")
    @ParameterizedTest
    @MethodSource("provideDataForPobierzRozkladJazdyLinii")
    void testPobierzRozkladJazdyLinii(int idLinii, RozkladJazdyLinii expectedRozkladJazdy) {
        try {
                   RozkladJazdyLinii result = aplikacja.pobierzRozkladJazdyLinii(idLinii);
                   if (expectedRozkladJazdy == null) {
                       assertNull(result, "Rozkład jazdy linii powinien być null dla ID linii: " + idLinii);
                   } else {
                       assertNotNull(result, "Rozkład jazdy linii nie powinien być null dla ID linii: " + idLinii);
                       assertEquals(expectedRozkladJazdy.getRozkladyKursow().size(), result.getRozkladyKursow().size(), "Nieprawidłowa liczba rozkładów kursów dla linii: " + idLinii);
                       assertTrue(expectedRozkladJazdy.getRozkladyKursow().containsAll(result.getRozkladyKursow()), "Rozkłady kursów nie są zgodne dla linii: " + idLinii);
                   }
               } catch (Exception e) {
                   // Obsługa wyjątków
                     fail("Błąd w teście: " + e.getMessage());
               }
           }

    /**
     * Test of aktualizujOpoznienie method, of class Aplikacja.
     * 
     *  @param idLinii ID linii, dla której będzie aktualizowane opóźnienie.
     *  @param idKursu ID kursu, dla którego będzie aktualizowane opóźnienie.
     *  @param nowaWartoscOpoznienia Nowa wartość opóźnienia, która ma zostać ustawiona.
     */
    @Order(2)
    @ParameterizedTest
    @CsvSource({
        "1, 1, 15",
        "1, 1, 30",
        "1, 1, 0",
        "1, 1, -5"
    })
    public void testAktualizujOpoznienie(int idLinii, int idKursu, int nowaWartoscOpoznienia, TestInfo testInfo) {
        try {
            System.out.println("aktualizujOpoznienie");
            aplikacja.aktualizujOpoznienie(idLinii, idKursu, nowaWartoscOpoznienia);

            Kurs aktualizowanyKurs = liniaTestowa.getKursy().get(0);
            int aktualnaWartoscOpoznienia = aktualizowanyKurs.getOpoznienie().getWartosc();

            assertEquals(nowaWartoscOpoznienia, aktualnaWartoscOpoznienia, "Metoda aktualizujOpoznienie nie działa poprawnie dla danych: " + idLinii + ", " + idKursu + ", " + nowaWartoscOpoznienia);
        } catch (Exception e) {
            // Obsługa wyjątków
            fail("Błąd w teście: " + testInfo.getTestMethod().orElse(null), e);
        }
    }
    
        private static Stream<Arguments> provideDataForPobierzRozkladJazdyLinii() {
        RozkladJazdyLinii rozkladJazdyLinii1 = new RozkladJazdyLinii();

        return Stream.of(
            Arguments.of(1, rozkladJazdyLinii1), // przykładowe dane
            Arguments.of(2, null) // zakładamy, że dla ID 2 nie ma rozkładu
        );
    }

    @ExtendWith(TestExecutionExceptionHandler.class)
    public void handleException(Throwable throwable, TestInfo testInfo, ExtensionContext extensionContext) {
            System.out.println("Wystąpił wyjątek: " + throwable.getMessage());

    }

    /**
     * Test of wyznaczTrase method, of class Aplikacja.
     */
    @Test
    @Tag("Rozklady")
    public void testWyznaczTrase() {
        System.out.println("wyznaczTrase");
        String przystanekPoczatkowy = "Zielona";
        String przystanekKoncowy = "Niebieska";

        // Dodatkowe wydruki do debugowania
        System.out.println("Przystanki w aplikacji: " + aplikacja.getPrzystanki().stream().map(Przystanek::getNazwa).collect(Collectors.toList()));
        System.out.println("Linie w aplikacji: " + aplikacja.getLinie().stream().map(Linia::getId).collect(Collectors.toList()));
        System.out.println("Kursy w linii testowej: " + liniaTestowa.getKursy().stream().map(Kurs::getIdKursu).collect(Collectors.toList()));

        List<Trasa> wynik = aplikacja.wyznaczTrase(przystanekPoczatkowy, przystanekKoncowy);
        
        assertNotNull(wynik, "Wynik nie powinien być null");
        assertFalse(wynik.isEmpty(), "Lista tras nie powinna być pusta");
    }
}
