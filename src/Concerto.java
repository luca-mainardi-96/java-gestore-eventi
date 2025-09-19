import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

    private LocalTime ora;
    private double prezzo;

    //Costruttore

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo){

        super(titolo, data, postiTotali);
        
        if(ora.isBefore(LocalTime.now()) && data.isEqual(LocalDate.now())){
            throw new IllegalArgumentException("Non puoi inserire un'orario che è già passato.");
        }else {
            this.ora = ora;
        }
        
        if(prezzo < 0){
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }else{
            this.prezzo = prezzo;
        }

    }

    //Getters

    public LocalTime getOra() {
        return ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    //Setters

    public void setOra(LocalTime ora) {
        if(ora.isBefore(LocalTime.now()) && getData().isEqual(LocalDate.now())){
            throw new IllegalArgumentException("Non puoi inserire un'orario che è già passato.");
        }else{
            this.ora = ora;
        }
    }

    public void setPrezzo(double prezzo) {
         if(prezzo < 0){
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }else{
            this.prezzo = prezzo;
        }
    }

    //Formatter

    public String getDataFormattata() {
        DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getData().format(dataFormattata);
    }

    public String getOraFormattata() {
        DateTimeFormatter oraFormattata = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(oraFormattata);
    }

    public String getPrezzoFormattato() {
        return String.format("%.2f €", getPrezzo());
    }

    //ToString

    @Override
    public String toString(){
        return "Data e ora: " + getDataFormattata() + " - " + getOraFormattata() +  "\nTitolo: " + getTitolo() + "\nPrezzo: " + getPrezzoFormattato();
    }


}
