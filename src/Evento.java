import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento implements Comparable<Evento>{
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    //Costruttore

    public Evento(String titolo, LocalDate data, int postiTotali){
        this.titolo = titolo;
        
        try {
            if(data.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("La data selezionata è già passata.");
            }else{
                this.data = data;
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        
        try {
            if(postiTotali < 0){
                throw new IllegalArgumentException("I posti totali non possono essere negativi.");
            }else{
                this.postiTotali = postiTotali;
            }
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        
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

    public void setData(LocalDate data) {
        try {
            if(data.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("La data selezionata è già passata.");
            }else{
                this.data = data;
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    //Metodi custom

    public static LocalDate convertiInput(String inputData){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(inputData, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inserita non valida. Usa il formato GG/MM/AAAA.");
        }
    }

    public void prenota(){
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data dell'evento scelto è già passata.");
        }else if(postiPrenotati == postiTotali){
            throw new IllegalArgumentException("Non ci sono più posti disponibili");
        }else{
            postiPrenotati++;
        }
    }

    public void disdici(){
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("la data dell'evento scelto è già passata.");
        }else if(postiPrenotati == 0){
            throw new IllegalArgumentException("Non ci sono prenotazioni per questo evento.");
        }else{
            postiPrenotati--;
        }
    }

    public String formattaData(LocalDate data){
        return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
    }

    //@Override

    @Override
    public String toString(){
        return "Data: " + formattaData(data) + "\nTitolo: " + getTitolo();
    }

    @Override
    public int compareTo(Evento altroEvento) {
        return this.data.compareTo(altroEvento.getData());
    }

    
}
