package model;

import model.RozkladJazdyPrzystanku;


public class Przystanek {
    private String nazwa;
    private RozkladJazdyPrzystanku rozkladJazdy;
    
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public RozkladJazdyPrzystanku getRozkladJazdy() {
        return rozkladJazdy;
    }

    public void setRozkladJazdy(RozkladJazdyPrzystanku rozkladJazdy) {
        this.rozkladJazdy = rozkladJazdy;
    }
    
}
