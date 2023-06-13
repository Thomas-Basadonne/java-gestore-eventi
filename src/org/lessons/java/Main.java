package org.lessons.java;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiesta di inserimento di un nuovo evento
        System.out.println("Inserisci i dettagli del nuovo evento:");
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Data (formato: AAAA-MM-GG): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr);
        System.out.print("Numero di posti totali: ");
        int postiTotali = scanner.nextInt();
        scanner.nextLine();

        // Creazione dell'evento
        Evento evento;
        try {
            evento = new Evento(titolo, data, postiTotali);
            System.out.println("Evento creato con successo!");
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nella creazione dell'evento: " + e.getMessage());
            return; // Termina il programma se la creazione dell'evento fallisce
        }

        // Richiesta di prenotazioni
        System.out.print("Vuoi effettuare delle prenotazioni? (S/N): ");
        String risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("S")) {
            System.out.print("Quante prenotazioni vuoi effettuare? ");
            int numPrenotazioni = scanner.nextInt();
            scanner.nextLine();

            // Effettua le prenotazioni
            for (int i = 0; i < numPrenotazioni; i++) {
                try {
                    evento.prenota();
                    System.out.println("Prenotazione effettuata con successo.");
                } catch (IllegalStateException e) {
                    System.out.println("Errore nella prenotazione: " + e.getMessage());
                    break; // Interrompe il ciclo se si verifica un errore
                }
            }
        }

        // Stampa il numero di posti prenotati e disponibili
        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        // Richiesta di disdette
        System.out.print("Vuoi effettuare delle disdette? (S/N): ");
        risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("S")) {
            System.out.print("Quanti posti vuoi disdire? ");
            int numDisdette = scanner.nextInt();
            scanner.nextLine();

            // Effettua le disdette
            for (int i = 0; i < numDisdette; i++) {
                try {
                    evento.disdici();
                    System.out.println("Disdetta effettuata con successo.");
                } catch (IllegalStateException e) {
                    System.out.println("Errore nella disdetta: " + e.getMessage());
                    break; // Interrompe il ciclo se si verifica un errore
                }
            }
        }
        scanner.close();

        // Stampa il numero di posti prenotati e disponibili dopo le disdette
        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
    }
}
