import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        //Creazione istanza

        System.out.println("Inserisci i dati per creare un nuovo evento.");
        System.out.println("Inserisci il titolo.");
        String titolo = scan.nextLine();
        System.out.println("Inserisci la data. (gg/mm/aaaa)");
        String dataString = scan.nextLine();
        LocalDate data = Evento.convertiInput(dataString);
        System.out.println("Inserisci il numero di posti.");
        int postiTotali = scan.nextInt();
        scan.nextLine();

        Evento e1 = new Evento(titolo, data, postiTotali);

        System.out.println("Vuoi fare delle prenotazioni? scegli si o no");
        String sceltaUtente = scan.nextLine().trim();

        //Prenotazioni e disdette

        if (sceltaUtente.equalsIgnoreCase("si")){
            System.out.println("Quante posti vuoi prenotare?");
            int numeroPosti = scan.nextInt();
            scan.nextLine();
            if(numeroPosti <= 0){
                throw new IllegalArgumentException("Il numero di prenotazioni non può essere negativo o pari a zero.");
            }else if(numeroPosti > postiTotali){
                throw new IllegalArgumentException("Il numero di prenotazioni non può essere maggiore del numero di posti disponibili.");
            }else{
                for(int i = 0; i < numeroPosti; i++){
                    e1.prenota();
                }
                System.out.println("Numero posti prenotati: " + e1.getPostiPrenotati() + "\nNUmero posti disponibili: " + (postiTotali - e1.getPostiPrenotati()));
            }
        }else if(sceltaUtente.equalsIgnoreCase("no")){
            System.out.println("Numero posti prenotati: " + e1.getPostiPrenotati() + "\nNUmero posti disponibili: " + (postiTotali - e1.getPostiPrenotati()));
        }else{
            throw new IllegalArgumentException("SCelta non valida");
        }


        System.out.println("Vuoi disdire una o più prenotazioni? scegli si o no");
        String sceltaUtente2 = scan.nextLine();
            if(sceltaUtente2.equalsIgnoreCase("si")){
                System.out.println("Quante prenotazioni vuoi disdire?");
                int numeroPosti = scan.nextInt();
                if(numeroPosti <= 0){
                    throw new IllegalArgumentException("Il numero di prenotazioni da disdire non può essere pari a zero o negativo.");
                }else if(numeroPosti > e1.getPostiPrenotati()){
                    throw new IllegalArgumentException("Non puoi disdire un numero maggiore di posti rispetto a quelli prenotati.");
                }else{
                    for(int i = 0; i <numeroPosti; i++){
                        e1.disdici();
                    }
                    System.out.println("Numero posti prenotati: " + e1.getPostiPrenotati() + "\nNUmero posti disponibili: " + (postiTotali - e1.getPostiPrenotati()));
                }
            }else if(sceltaUtente2.equalsIgnoreCase("no")){
                System.out.println("Numero posti prenotati: " + e1.getPostiPrenotati() + "\nNUmero posti disponibili: " + (postiTotali - e1.getPostiPrenotati()));
            }else{
                throw new IllegalArgumentException("Scelta non valida.");
            }
        System.out.println("\n\nStampa eventi\n");
        
        //Creazione seconda istanza + stampa
        
        Concerto e2 = new Concerto("X", LocalDate.of(2028, 1, 1), 5000, LocalTime.of(19, 30), 50);

        Evento e3 = new Evento("Y", LocalDate.of(2026, 1, 1), 5000);

        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());

        //Stampa istanze dopo modifiche

        System.out.println("\n\nStampa Eventi dopo le modifiche\n");

        e2.setPrezzo(40.50);
        e2.setOra(LocalTime.of(21, 30));

        e3.setTitolo("A");
        e3.setData(LocalDate.of(2027, 1, 13));

        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());

        //Creazione lista e test metodi

        ProgrammaEventi l1 = new ProgrammaEventi("Z");

        l1.aggiungiEvento(e1);
        l1.aggiungiEvento(e2);
        l1.aggiungiEvento(e3);

        System.out.println("\n\nStampa Lista\n");

        System.out.println(l1.stampaLista(l1));

        System.out.println("\n\nStampe parziali\n");

        ProgrammaEventi listaFiltrata = l1.listaEventi(LocalDate.of(2028, 1, 1));
        System.out.println(listaFiltrata.stampaLista(listaFiltrata));

        System.out.println("\n");
        l1.svuotaLista();
        System.out.println(l1.stampaLista(l1));

        scan.close();

    }
}
