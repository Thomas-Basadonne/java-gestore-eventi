package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getFormattedData() {
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getFormattedOra() {
        return ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }


    public String getFormattedPrezzo() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##€");
        return decimalFormat.format(prezzo.setScale(2));
    }


    @Override
    public String toString() {
        return getFormattedData() + " " + getFormattedOra() + " - " + getTitolo() + " - " + getFormattedPrezzo();
    }
}
