
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    System.out.println("Inserisci il titolo dell'evento: ");
    String titolo = scan.nextLine();

    System.out.println("Inserisci il giorno dell'evento: ");
    int giorno = scan.nextInt();
    if(giorno <= 0 || giorno > 31){
        throw new IllegalArgumentException("Il giorno inserito non è valido");
    }

    System.out.println("Inserisci il mese dell'evento: ");
    int mese = scan.nextInt();
    if(mese <= 0 || mese > 12){
        throw new IllegalArgumentException("Il mese inserito non è valido.");
    }

    System.out.println("Inserisci l'anno dell'evento: ");
    int anno = scan.nextInt();
    if(anno <(LocalDate.now().getYear())){
        throw new IllegalArgumentException("L'anno inserito non è valido.");
    }

    LocalDate data = LocalDate.of(anno, mese, giorno);

    System.out.println("Inserisci il numero massimo di posti: ");
    int numeroPosti = scan.nextInt();

    Evento e = new Evento(titolo, data, numeroPosti);

    System.out.println("Evento: " + e.getTitolo() + "\nNumero posti totali: " + e.getPostiTotali() +"\nNumero posti disponibili: " + (e.getPostiTotali() - e.getPostiPrenotati()));

}

}
