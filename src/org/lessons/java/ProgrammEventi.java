package org.lessons.java;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    //costruttore
    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    //metodo che aggiunge alla lista un Evento
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    //N eventi che sono presenti nel programma
    public int getNumeroEventi() {
        return eventi.size();
    }

    //metodo che svuota lista Eventi
    public void svuotaEventi() {
        eventi.clear();
    }

    public void programma(){
        for (Evento evento : eventi) {
            System.out.println("\n" + evento.getData() + "-" + evento.getTitolo());
        }
    }
}
