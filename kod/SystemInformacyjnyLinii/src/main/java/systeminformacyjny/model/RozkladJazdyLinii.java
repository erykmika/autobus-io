package systeminformacyjny.model;

import java.util.ArrayList;
import java.util.List;

public class RozkladJazdyLinii {
    private Linia linia;
    private List<RozkladJazdyKursu> rozkladyKursow = new ArrayList<>();
    
    public Linia getLinia() {
        return linia;
    }

    public void setLinia(Linia linia) {
        this.linia = linia;
    }

    public List<RozkladJazdyKursu> getRozkladyKursow() {
        return rozkladyKursow;
    }

    public void setRozkladyKursow(List<RozkladJazdyKursu> rozkladyKursow) {
        this.rozkladyKursow = rozkladyKursow;
    }
}
