
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
   
    private LocalTime ora;
    private double prezzo;

    //Costruttore

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

    //Getters

    public LocalTime getOra() {
        return ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getDataOra(){
        return "Data: " + formattaData(getData()) + " Ora: " +getOra();
    }

    public String getPrezzoFormattato(){
        return "Prezzo: " + getPrezzo() + " €";
    }

    //Setters

    public void setOra(LocalTime ora) {
        this.ora = ora;
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
    
    //@Override

    @Override
    public String toString(){
        return getDataOra() + "\nTitolo: " + getTitolo() + "\n" +getPrezzoFormattato();
    }
    
}
