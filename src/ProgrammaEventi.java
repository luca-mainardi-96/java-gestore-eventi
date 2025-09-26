import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

public class ProgrammaEventi {

    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo){
        this.titolo = titolo;
        eventi = new ArrayList<Evento>();
    }
    
    public String getTitolo(){
        return titolo;
    }

    public List<Evento> getLista(){
        return eventi;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public void aggiungiEvento(Evento e){
        eventi.add(e);
    }

    public ProgrammaEventi listaEventi(LocalDate data){
        ProgrammaEventi eventiPerData;
        
        List<Evento> eventiPerDataLista = new ArrayList<>();
        for(Evento e : eventi){
            if(e.getData().equals(data)){
                eventiPerDataLista.add(e);
            }
        }

        if(eventiPerDataLista.isEmpty()){
            eventiPerData = new ProgrammaEventi("Nessun evento in data " + data);
        } else {
            eventiPerData = new ProgrammaEventi("Eventi in data " + data);
            for(Evento e : eventiPerDataLista){
                eventiPerData.aggiungiEvento(e);
            }
        }

        return eventiPerData;
    }


    public int numeroElementi(){
        return eventi.size();
    }

    public void svuotaLista(){
        eventi.clear();
    }

    public String stampaLista(ProgrammaEventi programma){ 

        ProgrammaEventi eventiOrdinati = new ProgrammaEventi(programma.getTitolo());
        for( int i = 0; i < programma.getLista().size(); i++){
            eventiOrdinati.getLista().add(programma.getLista().get(i));
        }

        Collections.sort(eventiOrdinati.getLista());

        String stampa = eventiOrdinati.getTitolo() + "\n";

        for (Evento e : eventiOrdinati.getLista()){
            stampa += "Data: " + e.formattaData(e.getData()) + " - Titolo: " + e.getTitolo();
        }

        return stampa;

    }

    

}
