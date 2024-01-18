package systeminformacyjny.kontroler;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import systeminformacyjny.model.Przystanek;
import systeminformacyjny.model.Uzytkownik;
import systeminformacyjny.model.Linia;
import systeminformacyjny.model.RozkladJazdyPrzystanku;
import systeminformacyjny.model.RozkladJazdyLinii;
import systeminformacyjny.model.RozkladJazdyKursu;
import systeminformacyjny.model.Trasa;
import systeminformacyjny.model.Kurs;
import systeminformacyjny.model.Opoznienie;
import systeminformacyjny.model.Utrudnienie;

public class Aplikacja {

    private List<Przystanek> przystanki = new ArrayList<>();
    private List<Linia> linie = new ArrayList<>();
    private List<Uzytkownik> uzytkownicy = new ArrayList<>();

    public List<Przystanek> getPrzystanki() {
        return przystanki;
    }

    public void setPrzystanki(List<Przystanek> przystanki) {
        this.przystanki = przystanki;
    }

    public List<Uzytkownik> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(List<Uzytkownik> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public List<Linia> getLinie() {
        return linie;
    }

    public void setLinie(List<Linia> linie) {
        this.linie = linie;
    }

    // Metody przypadkow uzycia
    public RozkladJazdyPrzystanku pobierzRozkladJazdyPrzystanku(String nazwaPrzystanku) {
        for (Przystanek przystanek : przystanki) {
            String nazwa = przystanek.getNazwa();
            if (nazwaPrzystanku.equals(nazwa)) {
                RozkladJazdyPrzystanku rozkladJazdy = przystanek.getRozkladJazdy();
                return rozkladJazdy;

            }
        }
        return null;
    }

    public RozkladJazdyLinii pobierzRozkladJazdyLinii(int idLinii) {
        for (Linia linia : linie) {
            int id = linia.getId();
            if (idLinii == id) {
                RozkladJazdyLinii rozkladJazdy = linia.getRozkladJazdy();
                return rozkladJazdy;

            }
        }
        return null;
    }

    public boolean wyszukajUzytkownika(String email, String haslo) {
        for (Uzytkownik uzytkownik : uzytkownicy) {
            String email1 = uzytkownik.getEmail();
            String haslo1 = uzytkownik.getHaslo();
            if (email.equals(email1) && haslo.equals(haslo1)) {
                return true;
            }
        }
        return false;
    }

    public List<Trasa> wyznaczTrase(String przystanekPoczatkowy, String przystanekDocelowy) {
        List<Trasa> listaTras = new ArrayList<>();

        String nazwa1 = null;
        String nazwa2 = null;

        for (Linia linia : linie) {
            // Lista obiektow Przystanek
            List<Przystanek> przystanki = linia.getPrzystanki();
            // Lista nazw przystankow
            List<String> nazwyPrzystankow = linia.getPrzystanki()
                    .stream()
                    .map(Przystanek::getNazwa)
                    .collect(Collectors.toList());

            for (Przystanek przystanek1 : przystanki) {
                nazwa1 = przystanek1.getNazwa();

                if (przystanekPoczatkowy.equals(nazwa1)) {
                    int idxPoczatkowy = nazwyPrzystankow.indexOf(przystanekPoczatkowy);
                    for (Przystanek przystanek2 : przystanki) {

                        nazwa2 = przystanek2.getNazwa();
                        if (przystanekDocelowy.equals(nazwa2)) {

                            int idxKoncowy = nazwyPrzystankow.indexOf(przystanekDocelowy);

                            if (idxPoczatkowy < idxKoncowy) {

                                List<Kurs> kursy = linia.getKursy();
                                int indeks = nazwyPrzystankow.indexOf(przystanekPoczatkowy);
                                for (Kurs kurs : kursy) {
                                    Trasa trasa = new Trasa();
                                    RozkladJazdyKursu rozkladJazdy = kurs.getRozkladJazdy();
                                    List<Integer> godziny = rozkladJazdy.getGodziny();
                                    int godzinaOdjazdu = godziny.get(indeks);
                                    trasa.setKurs(kurs);
                                    trasa.setGodzinaOdjazdu(godzinaOdjazdu);
                                    listaTras.add(trasa);
                                }

                            }
                        }
                    }
                }
            }
        }
        return listaTras;
    }

    public void aktualizujOpoznienie(int idLinii, int idKursu, int nowaWartosc) {
        for (Linia linia : linie) {
            int idLinii1 = linia.getId();
            if (idLinii == idLinii1) {
                List<Kurs> kursy = linia.getKursy();
                for (Kurs kurs : kursy) {
                    int idKursu1 = kurs.getIdKursu();
                    if (idKursu == idKursu1) {
                        Opoznienie opoznienie = kurs.getOpoznienie();
                        opoznienie.setWartosc(nowaWartosc);
                        return;
                    }
                }
            }
        }
    }

    public void dodajUtrudnienie(int idLinii, int idKursu, String daneUtrudnienia) {
        for (Linia linia : linie) {
            int idLinii1 = linia.getId();
            if (idLinii == idLinii1) {
                List<Kurs> kursy = linia.getKursy();
                for (Kurs kurs : kursy) {
                    int idKursu1 = kurs.getIdKursu();
                    if (idKursu == idKursu1) {
                        List<Utrudnienie> utrudnienia = kurs.getUtrudnienia();
                        Utrudnienie utrudnienie = new Utrudnienie();
                        utrudnienie.setDaneUtrudnienia(daneUtrudnienia);
                        utrudnienia.add(utrudnienie);
                        return;
                    }
                }
            }
        }
    }

    public void modyfikujUtrudnienie(int idLinii, int idKursu, int indeksUtrudnienia, String noweDane) {
        for (Linia linia : linie) {
            int idLinii1 = linia.getId();
            if (idLinii == idLinii1) {
                List<Kurs> kursy = linia.getKursy();
                for (Kurs kurs : kursy) {
                    int idKursu1 = kurs.getIdKursu();
                    if (idKursu == idKursu1) {
                        List<Utrudnienie> utrudnienia = kurs.getUtrudnienia();
                        Utrudnienie utrudnienie = utrudnienia.get(indeksUtrudnienia);
                        utrudnienie.setDaneUtrudnienia(noweDane);
                        return;
                    }
                }
            }
        }
    }

    public void usunUtrudnienie(int idLinii, int idKursu, int indeksUtrudnienia) {
        for (Linia linia : linie) {
            int idLinii1 = linia.getId();
            if (idLinii == idLinii1) {
                List<Kurs> kursy = linia.getKursy();
                for (Kurs kurs : kursy) {
                    int idKursu1 = kurs.getIdKursu();
                    if (idKursu == idKursu1) {
                        List<Utrudnienie> utrudnienia = kurs.getUtrudnienia();
                        utrudnienia.remove(indeksUtrudnienia);
                        return;
                    }
                }
            }
        }
    }

    // Metode main wykorzystano do recznego testowania kodu klas
    public static void main(String[] args) {
        Aplikacja aplikacja = new Aplikacja();

        Linia linia = new Linia();
        linia.setId(1);
        aplikacja.linie.add(linia);

        Przystanek przystanek1 = new Przystanek();
        przystanek1.setNazwa("Zielona");
        aplikacja.przystanki.add(przystanek1);

        Kurs kurs = new Kurs();
        linia.getKursy().add(kurs);

        kurs.setIdKursu(1);
        RozkladJazdyLinii rozkladLinii = new RozkladJazdyLinii();
        linia.setRozkladJazdy(rozkladLinii);

        RozkladJazdyKursu rozkladKursu = new RozkladJazdyKursu();
        kurs.setRozkladJazdy(rozkladKursu);

        Opoznienie opoznienie = new Opoznienie();
        kurs.setOpoznienie(opoznienie);

        Utrudnienie utrudnienie = new Utrudnienie();
        kurs.getUtrudnienia().add(utrudnienie);

        RozkladJazdyLinii pobranyRozkladLinii = aplikacja.pobierzRozkladJazdyLinii(1);
        if (pobranyRozkladLinii != null) {
            System.out.println("Pobrano rozkład jazdy linii");
        } else {
            System.out.println("Nie znaleziono rozkładu jazdy linii");
        }

        boolean czyZalogowany = aplikacja.wyszukajUzytkownika("przyklad@pwr.edu.pl", "123");
        if (czyZalogowany) {
            System.out.println("Użytkownik zalogowany");
        } else {
            System.out.println("Błąd logowania");
        }

        List<Trasa> listaTras = aplikacja.wyznaczTrase("Zielona", "Niebieska");
        if (!listaTras.isEmpty()) {
            System.out.println("Znaleziono trasę");
        } else {
            System.out.println("Nie znaleziono trasy");
        }

        aplikacja.aktualizujOpoznienie(1, 1, 30);
        System.out.println("Zaktualizowano opóźnienie");

        aplikacja.dodajUtrudnienie(1, 1, "Nowe utrudnienie");
        System.out.println("Dodano utrudnienie");

        aplikacja.modyfikujUtrudnienie(1, 1, 0, "Nowe dane utrudnienia");
        System.out.println("Zmodyfikowano utrudnienie");

        aplikacja.usunUtrudnienie(1, 1, 0);
        System.out.println("Usunięto utrudnienie");

        RozkladJazdyPrzystanku rozkladJazdyPrzystanku = new RozkladJazdyPrzystanku();
        List<Integer> godziny = new ArrayList<>();
        godziny.add(8);
        godziny.add(12);
        godziny.add(16);
        rozkladJazdyPrzystanku.setGodziny(godziny);

        Linia linia1 = new Linia();
        Linia linia2 = new Linia();
        rozkladJazdyPrzystanku.getLinie().add(linia1);
        rozkladJazdyPrzystanku.getLinie().add(linia2);

        przystanek1.setRozkladJazdy(rozkladJazdyPrzystanku);

        List<Integer> pobraneGodziny = przystanek1.getRozkladJazdy().getGodziny();
        System.out.println("Pobrano godziny");
        List<Linia> pobraneLinie = przystanek1.getRozkladJazdy().getLinie();
        System.out.println("Pobrano linie");
    }
}
