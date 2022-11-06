package ba.unsa.etf.rpr;

public class MeđunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;

    public MeđunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return broj;
    }

    @Override
    public int hashCode() {
        return broj.hashCode();
    }
}
