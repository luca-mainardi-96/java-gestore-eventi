
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
   
    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo){
        super(titolo, data, postiTotali);
        this.ora = ora;
        
        try{
            if(prezzo < 0){
                throw new IllegalArgumentException("IL prezzo non può essere negativo.");
            }else{
                this.prezzo = prezzo;
            }
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
         try{
            if(prezzo < 0){
                throw new IllegalArgumentException("IL prezzo non può essere negativo.");
            }else{
                this.prezzo = prezzo;
            }
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public String getDataOra(){
        return "Data: " + formattaData(getData()) + " Ora: " +getOra();
    }

    public String getPrezzoFormattato(){
        return "Prezzo: " + getPrezzo() + " €";
    }
    
    @Override
    public String toString(){
        return getDataOra() + "\nTitolo: " + getTitolo() + "\n" +getPrezzoFormattato();
    }
    
}
