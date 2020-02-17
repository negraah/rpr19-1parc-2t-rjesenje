package ba.unsa.etf.rpr;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PeriodicnaRezervacija extends Rezervacija {
    private int dan;

    public PeriodicnaRezervacija(String naziv, String predavac, LocalTime pocetak, LocalTime kraj, int kojiDan) throws NeispravanFormatRezervacije {
        super(naziv,predavac,pocetak,kraj);

        if(kojiDan>6 || kojiDan<0){
            throw new IllegalArgumentException("Neispravan dan u sedmici");
        }

        this.dan = kojiDan;
    }

    public int getDan() {
        return dan;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        int broj = getDan();
        String naziv="";
        if(broj==0){
            naziv = "ponedjeljka";
        }else if(broj==1){
            naziv = "utorka";
        }else if(broj==2){
            naziv= "srijede";
        }else if(broj==3){
            naziv="četvrtka";
        }else if(broj==4){
            naziv = "petka";
        }else if(broj==5){
            naziv = "subote";
        }else if(broj==6){
            naziv = "nedjelje";
        }

        return getNazivSale()+" - "+ getPredavac()+" (periodična) - početak: "+getPocetak().format(formatter)+ ", kraj: "+
                getKraj().format(formatter)+
                ", svakog " + naziv;

    }
}
