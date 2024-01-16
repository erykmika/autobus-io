package systeminformacyjny.model;

import systeminformacyjny.model.RozkladJazdyPrzystanku;


public class Przystanek {
    private String nazwa;
    private RozkladJazdyPrzystanku rozkladJazdy = new RozkladJazdyPrzystanku();
    
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
