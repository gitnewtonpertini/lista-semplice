/*
 * Gestione di una lista semplice (Corso di Informatica - Formichi - Meini 2)
 * 
 */
package listasemplice;

/**
 *
 * @author Admin
 */
public class TestLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	Nodo p;
    	Lista lista = new Lista();
    	
        lista.inserisciInTesta(new Nodo("primo"));
        lista.inserisciInTesta(new Nodo("secondo"));
        lista.inserisciInTesta(new Nodo("terzo"));
        lista.inserisciInTesta(new Nodo("quarto"));
        lista.inserisciInTesta(new Nodo("quinto"));
        System.out.println("----- INSERIMENTO IN TESTA");
        System.out.println(lista.visualizzaLista());

        lista.inserisciInCoda(new Nodo("sesto"), true);
        lista.inserisciInCoda(new Nodo("settimo"), true);
        lista.inserisciInCoda(new Nodo("ottavo"), false);
        lista.inserisciInCoda(new Nodo("nono"), false);
        System.out.println("----- INSERIMENTO IN CODA");
        System.out.println(lista.visualizzaLista());

        System.out.println("----- RICERCA NODO");
        System.out.println("Posizione 5: " + lista.cercaNodo(5).visualizzaNodo());
        System.out.println(lista.visualizzaLista());

        System.out.println("----- INSERIMENTO IN POSIZIONE");
        System.out.println(lista.visualizzaLista());
        lista.inserisciInPosizione(new Nodo("quinto bis"), 5-1);
        System.out.println(lista.visualizzaLista());
        
        
        System.out.println("----- ELIMINAZIONE IN TESTA");
        System.out.println(lista.visualizzaLista());
        lista.eliminaInTesta();
        System.out.println("Dopo eliminazione del nodo in testa: ");
        System.out.println(lista.visualizzaLista());
        
        System.out.println("----- ELIMINAZIONE IN CODA");
        System.out.println(lista.visualizzaLista());
        lista.eliminaInCoda();
        System.out.println("Dopo eliminazione del nodo di coda:");
        System.out.println(lista.visualizzaLista());
        
        // Metodo rapido di costruzione di una lista di N elementi, con valori casuali
        Lista lista2 = new Lista(100);
        //System.out.println(lista2.visualizzaLista());

        // Ricerca nodo per chiave
        System.out.println("----- RICERCA NODO PER CHIAVE");
        System.out.println(lista.visualizzaLista());
        p = lista.cercaNodo("settimo");
        System.out.println(p != null ? "Trovato! " + p.visualizzaNodo() : "Nodo non trovato");
        
        // Ricerca nodo per chiave (ricorsiva)
        System.out.println("----- RICERCA NODO PER CHIAVE (RICORSIVA)");
        System.out.println(lista.visualizzaLista());
        p = lista.cercaNodoRicorsiva("ottavo", lista.getTesta());
        System.out.println(p != null ? "Trovato! " + p.visualizzaNodo() : "Nodo non trovato");
        
        System.out.println("----- VISUALIZZAZIONE RICORSIVA");
        System.out.println(lista.visualizzaListaRicorsiva(lista.getTesta()));
        
    }
    
}
