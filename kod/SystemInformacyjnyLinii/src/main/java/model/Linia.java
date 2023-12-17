package model;

import java.util.ArrayList;
import java.util.List;

public class Linia {
    private int id;
    private List<Przystanek> przystanki = new ArrayList<>();
    private List<Kurs> kursy = new ArrayList<>();
    private RozkladJazdyLinii rozkladJazdy;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public List<Przystanek> getPrzystanki() {
        return przystanki;
    }

    public void setPrzystanki(List<Przystanek> przystanki) {
        this.przystanki = przystanki;
    }

    
    public List<Kurs> getKursy() {
        return kursy;
    }

    public void setKursy(List<Kurs> kursy) {
        this.kursy = kursy;
    }

    
    public RozkladJazdyLinii getRozkladJazdy() {
        return rozkladJazdy;
    }

    public void setRozkladJazdy(RozkladJazdyLinii rozkladJazdy) {
        this.rozkladJazdy = rozkladJazdy;
    }
}
