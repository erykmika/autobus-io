/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testyfitnessefixture;

import fit.ColumnFixture;
import systeminformacyjny.model.Kurs;
import systeminformacyjny.model.Linia;
import static testyfitnessefixture.SetUp.aplikacja;

/**
 *
 * @author erykm
 */
public class TestAktualizacjaOpoznienia extends ColumnFixture {

    public int wartoscOpoznienia;
    public int idLinii;
    public int idKursu;

    public void dodajLinie() {
        Linia linia = znajdzLinie();
        if (linia == null) {
            Linia nowaLinia = new Linia();
            nowaLinia.setId(idLinii);
            aplikacja.getLinie().add(nowaLinia);
        }
    }

    public void dodajKurs() {
        Linia linia = znajdzLinie();
        if (linia != null) {
            Kurs kurs = znajdzKurs();
            if (kurs == null) {
                Kurs nowyKurs = new Kurs();
                nowyKurs.setIdKursu(idKursu);
                linia.getKursy().add(nowyKurs);
            }
        }
    }

    public int sprawdzenieOpoznienia() {
        dodajLinie();
        dodajKurs();
        try {
            znajdzKurs().getOpoznienie().setWartosc(wartoscOpoznienia);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        // Jezeli zmieniono opoznienie
        return znajdzKurs().getOpoznienie().getWartosc();
    }

    public Linia znajdzLinie() {
        for (Linia linia : aplikacja.getLinie()) {
            if (linia.getId() == idLinii) {
                return linia;
            }
        }
        return null;
    }

    public Kurs znajdzKurs() {
        for (Linia linia : aplikacja.getLinie()) {
            if (linia.getId() == idLinii) {
                for (Kurs kurs : linia.getKursy()) {
                    if (kurs.getIdKursu() == idKursu) {
                        return kurs;
                    }
                }
            }
        }
        return null;
    }
}
