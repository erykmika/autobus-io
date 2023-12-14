package systeminformacyjny;

import java.util.List;
import java.util.ArrayList;

import systeminformacyjny.model.Przystanek;
import systeminformacyjny.model.Uzytkownik;
import systeminformacyjny.model.Linia;
import systeminformacyjny.model.RozkladJazdyPrzystanku;
import systeminformacyjny.model.RozkladJazdyLinii;
import systeminformacyjny.model.RozkladJazdyKursu;
import systeminformacyjny.model.Trasa;
import systeminformacyjny.model.Kurs;

class Aplikacja {
    private List<Przystanek> przystanki = new ArrayList<>();
    private List<Linia> linie = new ArrayList<>();
    private List<Uzytkownik> uzytkownicy = new ArrayList<>();
    
    public List<Przystanek> getPrzystanki() {
        return przystanki;
    }

    public void setPrzystanki(List<Przystanek> przystanki) {
        this.przystanki = przystanki;
    }
    
    public RozkladJazdyPrzystanku pobierzRozkladJazdyPrzystanku(String nazwaPrzystanku)
    {
        for(Przystanek przystanek : przystanki)
        {
            String nazwa = przystanek.getNazwa();
            if(nazwaPrzystanku.equals(nazwa)) {
                RozkladJazdyPrzystanku rozkladJazdy = przystanek.getRozkladJazdy();
                return rozkladJazdy;
                
            }
        }
        return null;
    }
    
    public RozkladJazdyLinii pobierzRozkladJazdyLinii (int idLinii)
    {
        for(Linia linia : linie)
        {
            int id  = linia.getId();
            if(idLinii == id) {
                RozkladJazdyLinii rozkladJazdy = linia.getRozkladJazdy();
                return rozkladJazdy;
                
            }
        }
        return null;
    }
    
    public boolean wyszukajUzytkownika(String email, String haslo) {
        for(Uzytkownik uzytkownik : uzytkownicy) {
            String email1 = uzytkownik.getEmail();
            String haslo1 = uzytkownik.getHaslo();
            if(email.equals(email1) && haslo.equals(haslo1)) {
                return true;
            }
        }
        return false;
    }
    
    public List<Trasa> wyznaczTrase(String przystanekPoczatkowy, String przystanekDocelowy) {
        List<Trasa> listaTras = new ArrayList<>();
        
        String nazwa1 = null;
        String nazwa2 = null;
        
        for(Linia linia : linie) {
            List<Przystanek> przystanki = linia.getPrzystanki();
            
            for(Przystanek przystanek1 : przystanki) {
                nazwa1 = przystanek1.getNazwa();
                
                if(przystanekPoczatkowy.equals(nazwa1)) {
                    
                    int idxPoczatkowy = przystanki.indexOf(przystanekPoczatkowy);
                    for(Przystanek przystanek2 : przystanki) {
                        
                        nazwa2 = przystanek2.getNazwa();
                        if(przystanekDocelowy.equals(nazwa1)) {
                            
                            int idxKoncowy = przystanki.indexOf(przystanekDocelowy);
                            if(idxPoczatkowy < idxKoncowy) {
                                
                               List<Kurs> kursy = linia.getKursy();
                               int indeks = przystanki.indexOf(przystanekPoczatkowy);
                               
                                for(Kurs kurs : kursy) {
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
    
    public static void main(String[] args) {
        Aplikacja aplikacja = new Aplikacja();
        System.out.println("Hello World!");
    }
}
