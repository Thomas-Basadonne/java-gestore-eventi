package org.lessons.java;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private final int postiTotali;
    private int postiPrenotati;

    //costruttore
    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    //GETTER E SETTER
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //metodo prenota()
    public void prenota() throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Non è possibile prenotare un evento passato.");
        }
        if (postiPrenotati >= postiTotali) {
            throw new IllegalStateException("Tutti i posti sono stati già prenotati.");
        }
        postiPrenotati++;
    }

    //metodo disdici()
    public void disdici() throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Non è possibile disdire un evento passato.");
        }
        if (postiPrenotati <= 0) {
            throw new IllegalStateException("Non ci sono prenotazioni da disdire.");
        }
        postiPrenotati--;
    }

    //stringa formato "data - titolo"
    @Override
    public String toString() {
        return data.toString() + " - " + titolo;
    }
}
