package ba.unsa.etf.rpr;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Rezervacija {
    private String predavac;
    private String nazivSale;
    private LocalTime pocetak;
    private LocalTime kraj;

    public Rezervacija(String nazivSale, String predavac, LocalTime pocetak, LocalTime kraj) throws NeispravanFormatRezervacije {
        if(pocetak.isAfter(kraj)){
            throw new NeispravanFormatRezervacije("Neispravan format početka i kraja rezervacije");
        }
        this.predavac = predavac;
        this.nazivSale = nazivSale;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Rezervacija() {
    }

    public void setPocetak(LocalTime pocetak) throws NeispravanFormatRezervacije {

        if(pocetak.isAfter(kraj)){
            throw new NeispravanFormatRezervacije("Neispravan format početka i kraja rezervacije");
        }
        this.pocetak=pocetak;
    }

    public void setKraj(LocalTime kraj) throws NeispravanFormatRezervacije {
        if(kraj.isBefore(pocetak)){
            throw new NeispravanFormatRezervacije("Neispravan format početka i kraja rezervacije");
        }
        this.kraj=kraj;
    }

    public void setPredavac(String predavac) {
        this.predavac = predavac;
    }

    public void setNazivSale(String nazivSale) {
        this.nazivSale = nazivSale;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public String getNazivSale() {
        return nazivSale;
    }

    public String getPredavac() {
        return predavac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rezervacija that = (Rezervacija) o;
        return Objects.equals(predavac, that.predavac) &&
                Objects.equals(nazivSale, that.nazivSale) &&
                Objects.equals(pocetak, that.pocetak) &&
                Objects.equals(kraj, that.kraj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predavac, nazivSale, pocetak, kraj);
    }
}
