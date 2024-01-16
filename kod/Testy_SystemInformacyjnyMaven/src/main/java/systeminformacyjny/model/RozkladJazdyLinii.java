package systeminformacyjny.model;

import java.util.ArrayList;
import java.util.List;

public class RozkladJazdyLinii {
    private List<RozkladJazdyKursu> rozkladyKursow = new ArrayList<>();

    public List<RozkladJazdyKursu> getRozkladyKursow() {
        return rozkladyKursow;
    }

    public void setRozkladyKursow(List<RozkladJazdyKursu> rozkladyKursow) {
        this.rozkladyKursow = rozkladyKursow;
    }
}
