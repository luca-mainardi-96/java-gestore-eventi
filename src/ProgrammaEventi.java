import java.util.List;
import java.util.ArrayList;

public class ProgrammaEventi {

    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo){
        this.titolo = titolo;
        List<Evento> eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento e){
        eventi.add(e);
    }

    public void svuotaLista(){
        eventi.clear();
    }

}
