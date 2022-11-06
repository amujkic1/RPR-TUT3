package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.Set;

import static ba.unsa.etf.rpr.Grad.*;
import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {

    @Test
    void dodaj() throws MojIzuzetak {
        Imenik imenik = new Imenik();
        imenik.dodaj("John Smith", new MeđunarodniBroj("+1", "23 45-67-89"));
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-456"));
        assertEquals("033/123-456", imenik.dajBroj("Meho Mehic"));
    }

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Pero Peric", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Ivo Ivic", new MobilniBroj(61, "321-645"));
        imenik.dodaj("Jozo Jozic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MeđunarodniBroj("+1", "23 45-67-89"));
        assertEquals("1. Ivo Ivic - 061/321-645", imenik.naSlovo('I').trim());
    }

    @Test
    void izGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MeđunarodniBroj("+1", "23 45-67-89"));
        Set<String> set = imenik.izGrada(SARAJEVO);
        String result = "";
        for (String ime : set) {
            result += ime + ",";
        }
        assertEquals("Ivo Ivic,Meho Mehic,Sara Sarac,", result);
    }

    @Test
    void izGradaBrojevi() throws MojIzuzetak {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MeđunarodniBroj("+1", "23 45-67-89"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(SARAJEVO);
        String result = "";
        for (TelefonskiBroj broj : set) {
            result += broj.ispisi() + ",";
        }
        assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }

    @Test
    public void testMockito(){
        Map<String, String> imenikMock = Mockito.mock(Map.class);
        imenikMock.put("Bosna", "Sarajevo");
        imenikMock.put("Srbija", "Beograd");
        imenikMock.put("Hrvatska", "Zagreb");

        Mockito.verify(imenikMock).put("Bosna", "Sarajevo");
        Mockito.verify(imenikMock).put("Srbija", "Beograd");
        Mockito.verify(imenikMock).put("Hrvatska", "Zagreb");

        Mockito.when(imenikMock.get("Bosna")).thenReturn("Beograd");
        assertEquals("Beograd", imenikMock.get("Bosna"));

        Mockito.when(imenikMock.get("Hrvatska")).thenReturn("Mi smo najjaci");
        assertEquals("Mi smo najjaci", imenikMock.get("Hrvatska"));
    }


}