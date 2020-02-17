package ba.unsa.etf.rpr;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VandrednaRezervacija extends Rezervacija {
    private LocalDate datum;

    public VandrednaRezervacija(String sala, String naziv, LocalTime datum1, LocalTime datum2, LocalDate datum3) throws NeispravanFormatRezervacije {
        super(sala, naziv, datum1, datum2);
        datum = datum3;
    }

    public LocalDate getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return  getNazivSale()+" - "+ getPredavac()+" (vandredna) - početak: "+getPocetak().format(formatter1)+ ", kraj: "+
                getKraj().format(formatter1)+
                ", na dan " + getDatum().format(formatter2);
    }
}
