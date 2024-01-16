package systeminformacyjny.kontroler;

/**
 *
 * @author erykm
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mockit.Capturing;
import org.junit.jupiter.api.Test;
import mockit.Injectable;
import mockit.Tested;
import static org.junit.jupiter.api.Assertions.*;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.VerificationsInOrder;
import org.junit.jupiter.api.Tag;
import systeminformacyjny.model.Kurs;
import systeminformacyjny.model.Linia;
import systeminformacyjny.model.Opoznienie;
import systeminformacyjny.model.Przystanek;
import systeminformacyjny.model.RozkladJazdyKursu;
import systeminformacyjny.model.RozkladJazdyPrzystanku;
import systeminformacyjny.model.Trasa;
import systeminformacyjny.model.Uzytkownik;


@Tag("Control")
public class AplikacjaTest1 {

    @Tested
    Aplikacja aplikacja;

    @Test
    public void testPobierzRozkladJazdyPrzystanku(@Mocked Przystanek przystanek) {
        aplikacja.getPrzystanki().add(przystanek);

        new Expectations() {
            {
                przystanek.getNazwa();
                result = "Zielona";
                przystanek.getRozkladJazdy();
                result = new RozkladJazdyPrzystanku();
            }
        };

        RozkladJazdyPrzystanku rozkladJazdy = aplikacja.pobierzRozkladJazdyPrzystanku("Zielona");
        assertNotNull(rozkladJazdy);
    }

    @Test
    public void testWyszukajUzytkownika(@Injectable Uzytkownik uzytkownik) {
        aplikacja.getUzytkownicy().add(uzytkownik);

        new Expectations() {
            {
                uzytkownik.getEmail();
                result = "przyklad@pwr.edu.pl";
                uzytkownik.getHaslo();
                result = "123";
            }
        };

        assertTrue(aplikacja.wyszukajUzytkownika("przyklad@pwr.edu.pl", "123"));

        new Verifications() {
            {
                uzytkownik.getEmail();
                uzytkownik.getHaslo();
            }
        };
    }

   @Test
    public void testWyznaczTrase(@Capturing Trasa anyTrasa) {
        Aplikacja aplikacja = new Aplikacja();

        // dane wpisane sztywno na potrzeby testu
        Linia liniaTestowa = new Linia();
        liniaTestowa.setId(1);

        Przystanek przystanek1 = new Przystanek();
        przystanek1.setNazwa("Zielona");
        Przystanek przystanek2 = new Przystanek();
        przystanek2.setNazwa("Niebieska");

        liniaTestowa.setPrzystanki(Arrays.asList(przystanek1, przystanek2));

        Kurs kursTestowy = new Kurs();
        kursTestowy.setIdKursu(1);
        kursTestowy.setOpoznienie(new Opoznienie());
        kursTestowy.setRozkladJazdy(new RozkladJazdyKursu());
        kursTestowy.getRozkladJazdy().setGodziny(Arrays.asList(8, 10, 12));

        liniaTestowa.setKursy(Arrays.asList(kursTestowy));
        aplikacja.getLinie().add(liniaTestowa);
        aplikacja.getPrzystanki().addAll(Arrays.asList(przystanek1, przystanek2));

        List<Trasa> trasy = aplikacja.wyznaczTrase("Zielona", "Niebieska");
        assertFalse(trasy.isEmpty());

        new VerificationsInOrder() {{
            // czy utworzono trase
            new Trasa();
        }};
    }


   
    @Test
    public void testAktualizujOpoznienie(@Injectable Linia linia, @Injectable Kurs kurs, @Mocked Opoznienie opoznienie) {
        aplikacja.getLinie().add(linia);

        // mockowanie/symulowanie zachowan linii, kursu
        new Expectations() {{
            linia.getId(); result = 1;
            linia.getKursy(); result = new ArrayList<>(Arrays.asList(kurs));
            kurs.getIdKursu(); result = 1;
            kurs.getOpoznienie(); result = opoznienie;
        }};

        aplikacja.aktualizujOpoznienie(1, 1, 30);

        // czy zmieniono wartosc opoznienia
        new Verifications() {{
            opoznienie.setWartosc(30);
        }};
    }
}
