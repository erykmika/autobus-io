package model;

import java.util.ArrayList;
import java.util.List;

public class Uzytkownik {
    private String email;
    private String haslo;
    private boolean czyZalogowany;
    private List<Linia> listaUlubionychLinii = new ArrayList<>();
    private List<Przystanek> listaUlubionychPrzystankow = new ArrayList<>();
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public boolean getCzyZalogowany() {
        return czyZalogowany;
    }

    public void setCzyZalogowany(boolean czyZalogowany) {
        this.czyZalogowany = czyZalogowany;
    }

    public List<Linia> getListaUlubionychLinii() {
        return listaUlubionychLinii;
    }

    public void setListaUlubionychLinii(List<Linia> listaUlubionychLinii) {
        this.listaUlubionychLinii = listaUlubionychLinii;
    }

    public List<Przystanek> getListaUlubionychPrzystankow() {
        return listaUlubionychPrzystankow;
    }

    public void setListaUlubionychPrzystankow(List<Przystanek> listaUlubionychPrzystankow) {
        this.listaUlubionychPrzystankow = listaUlubionychPrzystankow;
    }
}
