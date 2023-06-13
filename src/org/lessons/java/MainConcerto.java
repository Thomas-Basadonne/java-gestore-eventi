package org.lessons.java;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainConcerto {
    public static void main(String[] args) {
        // Creazione di un oggetto Concerto
        LocalDate data = LocalDate.of(2023, 6, 15);
        LocalTime ora = LocalTime.of(20, 30);
        BigDecimal prezzo = new BigDecimal("25.50");

        Concerto concerto = new Concerto("Concerto di prova", data, 100, ora, prezzo);

        // Stampa delle informazioni sul concerto
        System.out.println("Dettagli concerto:");
        System.out.println("Titolo: " + concerto.getTitolo());
        System.out.println("Numero posti: " + concerto.getPostiTotali());
        System.out.println("Data: " + concerto.getFormattedData());
        System.out.println("Ora: " + concerto.getFormattedOra());
        System.out.println("Prezzo: " + concerto.getFormattedPrezzo());

        // Esempio di modifica del prezzo
        BigDecimal nuovoPrezzo = new BigDecimal("30.00");
        concerto.setPrezzo(nuovoPrezzo);

        // Stampa delle informazioni aggiornate sul concerto
        System.out.println("Nuovi dettagli concerto:");
        System.out.println("Titolo: " + concerto.getTitolo());
        System.out.println("Data: " + concerto.getFormattedData());
        System.out.println("Ora: " + concerto.getFormattedOra());
        System.out.println("Prezzo: " + concerto.getFormattedPrezzo());

        // Stampa delle informazioni aggiornate con metodo toString() richiamando override
        System.out.println("Dettagli concerto:");
        System.out.println(concerto);
    }
}

