
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        //Impostazione dati evento

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
        scan.nextLine();
        if(numeroPosti <= 0){
            throw new IllegalArgumentException("Il numero di posti non può essere negativo.");
        }

        //Creazione istanza

        Evento e = new Evento(titolo, data, numeroPosti);

        //Prenotazione posti

        System.out.println("Vuoi prenotare uno o più posti? (si/no) ");
        String scelta = scan.nextLine();
        if(scelta.equalsIgnoreCase("si")){
            System.out.println("Quanti posti vuoi prenotare? ");
            int sceltaPosti = scan.nextInt();
            scan.nextLine();
                if(sceltaPosti <= 0 || sceltaPosti > (e.getPostiTotali() - e.getPostiPrenotati())){
                    throw new IllegalArgumentException("Il numero di posti non può essere negativo o superiore ai posti disponibili.");
                }else{
                    for(int i=0; i<sceltaPosti; i++){
                        e.prenota();
                    }
                }
        }else if(scelta.equalsIgnoreCase("no")){
            System.out.println("Hai scelto no.");
        }else{
            System.out.println("Scelta non valida.");
        }

        System.out.println("Evento: " + e.getTitolo() + "\nNumero posti totali: " + e.getPostiTotali() + "\nNumero posti disponibili: " + (e.getPostiTotali() - e.getPostiPrenotati()));

        //Disdetta prenotazioni

        System.out.println("Vuoi disdire una o più prenotazioni? (si/no) ");
        String scelta2 = scan.nextLine();
        if(scelta2.equalsIgnoreCase("si")){
            System.out.println("Quante prenotazioni vuoi disdire? ");
            int sceltaPosti2 = scan.nextInt();
            scan.nextLine();
                if(sceltaPosti2 <= 0 || sceltaPosti2 > e.getPostiPrenotati()){
                    throw new IllegalArgumentException("Il numero di posti non può essere negativo o superiore ai posti prenotati.");
                }else{
                    for(int i=0; i<sceltaPosti2; i++){
                        e.disdici();
                    }
                }
        }else if(scelta2.equalsIgnoreCase("no")){
            System.out.println("Hai scelto no.");
        }else{
            System.out.println("Scelta non valida.");
        }

        System.out.println("Evento: " + e.getTitolo() + "\nNumero posti totali: " + e.getPostiTotali() + "\nNumero posti disponibili: " + (e.getPostiTotali() - e.getPostiPrenotati()));

    }

}
