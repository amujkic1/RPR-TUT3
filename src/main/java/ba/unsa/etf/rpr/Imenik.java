package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private HashMap<String,TelefonskiBroj> mapa = new HashMap<>();

    void dodaj(String ime, TelefonskiBroj broj) {
        mapa.put(ime, broj);
    }

    String dajBroj(String ime) throws MojIzuzetak {
        for(Map.Entry<String,TelefonskiBroj> x : mapa.entrySet()){
            if(x.getKey()==ime) return x.getValue().ispisi();
        }
        return null;
    }

    String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj> x : mapa.entrySet()){
            if(x.getValue()==broj) return x.getKey();
        }
        return null;
    }

    String naSlovo(char s){
        String str = "";
        int br=0;
        for(Map.Entry<String,TelefonskiBroj> x : mapa.entrySet()){
            if(x.getKey().charAt(0)=='s'){
                str.concat(br + ". " + x.getKey() + "\n");
                br++;
            }
        }
        return str;
    }

    Set<String> izGrada(Grad g){
        TreeSet<String> skup = new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj> x : mapa.entrySet()){
            if(x.getValue() instanceof FiksniBroj && ((FiksniBroj) x.getValue()).getPozivni().equals(g.pozivniBroj)){
                skup.add(x.getKey());
            }
        }
        return skup;
    }

    Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        TreeSet<TelefonskiBroj> skup = new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj> x : mapa.entrySet()){
            if(x.getValue() instanceof FiksniBroj && ((FiksniBroj) x.getValue()).getPozivni().equals(g.pozivniBroj)){
                skup.add(x.getValue());
            }
        }
        return skup;
    }
}
