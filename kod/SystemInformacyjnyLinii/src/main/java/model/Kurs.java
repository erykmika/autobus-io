package model;

import java.util.ArrayList;
import java.util.List;

public class Kurs {
    private int idKursu;
    private Opoznienie opoznienie = new Opoznienie();
    private List<Utrudnienie> utrudnienia = new ArrayList<>();
    private RozkladJazdyKursu rozkladJazdy = new RozkladJazdyKursu();
    
    public int getIdKursu() {
        return idKursu;
    }

    public void setIdKursu(int idKursu) {
        this.idKursu = idKursu;
    }

    public Opoznienie getOpoznienie() {
        return opoznienie;
    }

    public void setOpoznienie(Opoznienie opoznienie) {
        this.opoznienie = opoznienie;
    }

    public List<Utrudnienie> getUtrudnienia() {
        return utrudnienia;
    }

    public void setUtrudnienia(List<Utrudnienie> utrudnienia) {
        this.utrudnienia = utrudnienia;
    }

    public RozkladJazdyKursu getRozkladJazdy() {
        return rozkladJazdy;
    }

    public void setRozkladJazdy(RozkladJazdyKursu rozkladJazdy) {
        this.rozkladJazdy = rozkladJazdy;
    }
}
