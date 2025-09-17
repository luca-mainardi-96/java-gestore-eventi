import java.time.LocalDate;

public class Evento {
    
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;
    
    //Costruttore

    public Evento(String titolo, LocalDate data, int postiTotali){
        this.titolo = titolo;

        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data non è valida.");
        }
        this.data = data;
        
        if(postiTotali <= 0){
            throw new IllegalArgumentException("Il numero di posti non può essere negativo o pari a zero.");
        }
        this.postiTotali = postiTotali;

        this.postiPrenotati = 0;
    }

    //Getters

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //Setters

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data non è valida.");
        }
        this.data = data;
    }

    //Metodi custom

    public void prenota(){
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("L'evento che stai cercando di prenotare è già passato.");
        } else if(postiPrenotati >= postiTotali){
            throw new IllegalArgumentException("Posti disponibili esauriti.");
        }else{
            postiPrenotati++;
        }

    }

    public void disdici(){
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("L'evento che stai cercando di disdire è già passato.");
        } else if(postiPrenotati <= 0){
            throw new IllegalArgumentException("L'evento non ha posti prenotati");
        }else{
            postiPrenotati--;
        }
    }

    @Override
    public String toString(){
        return "Titolo evento: " + titolo + "\nData evento: " + data;
    }

}
