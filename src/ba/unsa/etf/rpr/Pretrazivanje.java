package ba.unsa.etf.rpr;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface Pretrazivanje{
    public List<Rezervacija> filtrirajPoKriteriju(Predicate<Rezervacija> f);
    public  List<Rezervacija>dajRezervacijeZaDan(LocalDateTime datum);
    public List<Rezervacija>dajSortiraneRezervacije();
    public List<Rezervacija>dajSortiraneRezervacije(BiFunction<Rezervacija,Rezervacija,Integer> f);
    public Set<Rezervacija> dajSortiranePoTipu();
    public boolean daLin(LocalDateTime datum);
    public boolean daLiSamSlobodan(LocalDateTime datum1, LocalDateTime datum2);
}
