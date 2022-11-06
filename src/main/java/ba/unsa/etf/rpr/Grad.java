package ba.unsa.etf.rpr;

public enum Grad {
    SARAJEVO("033"), ZENICA("032"), TRAVNIK("030"), BIHAC("037"), ORASJE("031"),
    GORAZDE("038"), TUZLA("035"), SIROKI_BRIJEG("039"), LIVNO("034"), BRCKO("049");

    final String pozivniBroj;
    Grad(String pozivni){
        this.pozivniBroj = pozivni;
    }
}