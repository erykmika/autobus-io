package systeminformacyjny.model;

public class Trasa {
    private int godzinaOdjazdu;
    private Kurs kurs;
    
    public int getGodzinaOdjazdu() {
        return godzinaOdjazdu;
    }

    public void setGodzinaOdjazdu(int godzinaOdjazdu) {
        this.godzinaOdjazdu = godzinaOdjazdu;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
}
