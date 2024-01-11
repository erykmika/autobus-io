package systeminformacyjny.model;

import java.util.ArrayList;
import java.util.List;

public class RozkladJazdyPrzystanku {
    private List<Integer> godziny = new ArrayList<>();
    private List<Linia> linie = new ArrayList<>();
    
    public List<Integer> getGodziny() {
        return godziny;
    }

    public void setGodziny(List<Integer> godziny) {
        this.godziny = godziny;
    }

    public List<Linia> getLinie() {
        return linie;
    }

    public void setLinie(List<Linia> linie) {
        this.linie = linie;
    }
}
