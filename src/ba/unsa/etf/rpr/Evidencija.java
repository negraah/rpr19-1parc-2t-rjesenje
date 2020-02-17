package ba.unsa.etf.rpr;

import java.util.*;
import java.util.function.Function;

public class Evidencija implements Pretrazivanje {
    private List<Rezervacija> rezervacije = new ArrayList<>();

    public void rezervisi(Rezervacija rezervacija) {
        rezervacije.add(rezervacija);
    }

    public List<Rezervacija> dajSveRezervacije() {
        return rezervacije;
    }

    public void otkaziRezervaciju(Rezervacija rezervacija) {
        rezervacije.remove(rezervacija);
    }

    public void otkaziRezervacije(List<Rezervacija> lista) {
        for (Rezervacija listica : lista) {
            rezervacije.remove(listica);
        }
    }

    public void otkaziRezervacije(Function<Rezervacija, Boolean> f) {
        ArrayList<Rezervacija> zaIzbacit = new ArrayList<>();

        for (Rezervacija rezervacija : rezervacije) {
            if(f.apply(rezervacija)){
               zaIzbacit.add(rezervacija);
            }
        }
        for (Rezervacija r : zaIzbacit) {
            rezervacije.remove(r);
        }


    }

    public List<Rezervacija> dajEvidencijuZaSalu(String naziv) {
        List<Rezervacija> lista = new ArrayList<>();

        for (Rezervacija rezervacija : rezervacije) {
            if(rezervacija.getNazivSale().equals(naziv)){
                lista.add(rezervacija);
            }
        }
        if(lista.size()==0){
            throw new IllegalArgumentException("Za salu "+ naziv +"ne postoje evidentirane rezervacije");
        }
        return lista;
    }

    public Map<String, List<Rezervacija>> dajEvidenciju() {
        Map<String, List<Rezervacija>> mapa = new HashMap<>();

        for (Rezervacija rezervacija : rezervacije) {
            if(mapa.containsKey(rezervacija.getNazivSale())){
                mapa.get((rezervacija.getNazivSale())).add(rezervacija);
            }else{
                mapa.put(rezervacija.getNazivSale(),new ArrayList<>());
                mapa.get((rezervacija.getNazivSale())).add(rezervacija);
            }
        }


        return mapa;
    }

    public void rezervisi(List<Rezervacija> dogadjaji) {
        for (Rezervacija rezervacija : dogadjaji) {
            rezervacije.add(rezervacija);
        }


    }
    @Override
    public String toString() {
        String s = "";
        for (Rezervacija dogadjaj : rezervacije) {
            if (s.equals("") == false) {
                s+="\n";
            }
            s+=dogadjaj;
        }


        return s;
    }
}
