package systeminformacyjny.model;

import java.util.ArrayList;
import java.util.List;


public class RozkladJazdyKursu {
    private List<Integer> godziny = new ArrayList<>();
    
    public List<Integer> getGodziny() {
        return godziny;
    }
    public void setGodziny(List<Integer> godziny) {
        if(godziny.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.godziny = godziny;
    }
}
