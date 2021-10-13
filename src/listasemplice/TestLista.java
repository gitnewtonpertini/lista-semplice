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
    	
        lista.inserisciInTesta(new Nodo("alce"));
        lista.inserisciInTesta(new Nodo("tasso"));
        lista.inserisciInTesta(new Nodo("daino"));
        lista.inserisciInTesta(new Nodo("lupo"));
        lista.inserisciInTesta(new Nodo("orso"));
        System.out.println("----- INSERIMENTO IN TESTA");
        System.out.println(lista.visualizzaLista());

        lista.inserisciInCoda(new Nodo("lince"), true);
        lista.inserisciInCoda(new Nodo("martora"), true);
        lista.inserisciInCoda(new Nodo("cervo"), false);
        lista.inserisciInCoda(new Nodo("scoiattolo"), false);
        System.out.println("----- INSERIMENTO IN CODA");
        System.out.println(lista.visualizzaLista());

        System.out.println("----- RICERCA NODO PER POSIZIONE");
        System.out.println("Posizione 5: " + lista.cercaNodo(0).visualizzaNodo());
        System.out.println(lista.visualizzaLista());

        System.out.println("----- INSERIMENTO IN POSIZIONE");
        System.out.println(lista.visualizzaLista());
        lista.inserisciInPosizione(new Nodo("ghiro"), 5-1);
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
        
        // Ricerca del massimo (ricorsiva)
        System.out.println("----- RICERCA MASSIMO (RICORSIVA)");
        System.out.println(lista.visualizzaLista());
        System.out.println("Massimo: " + lista.cercaMassimoRicorsiva(lista.getTesta().getInfo(), lista.getTesta()));              

        // Shuffle: scambio nodi
        System.out.println("----- SHUFFLE: SCAMBIO NODI");
        System.out.println(lista.visualizzaLista());
        lista.shuffle(2,6);
        System.out.println(lista.visualizzaLista());
        
        // Ricerca sottolista
        System.out.println("----- VERIFICA SOTTOLISTA");
    	Lista sottoLista = new Lista();
    	sottoLista.inserisciInTesta(new Nodo("alcex"));
    	//sottoLista.inserisciInTesta(new Nodo("ghiro"));
    	//sottoLista.inserisciInTesta(new Nodo("tasso"));
        System.out.println(lista.visualizzaLista());
        System.out.println(sottoLista.visualizzaLista());

        Nodo start = lista.cercaNodo(sottoLista.getTesta().getInfo());
        if (start != null) {
        	System.out.println(start.getSuccessivo().visualizzaNodo());
        	System.out.println(lista.isSottolista(start.getSuccessivo(), sottoLista.getTesta()));
        }
        // Merge liste
        System.out.println("----- MERGE LISTE");
    	Lista l1 = new Lista();
        l1.inserisciInCoda(new Nodo("aaa"), true);
        l1.inserisciInCoda(new Nodo("bbb"), true);
        l1.inserisciInCoda(new Nodo("ccc"), true);
        l1.inserisciInCoda(new Nodo("lll"), true);
        l1.inserisciInCoda(new Nodo("mmm"), true);
        
    	Lista l2 = new Lista();
        l2.inserisciInCoda(new Nodo("fff"), true);
        l2.inserisciInCoda(new Nodo("ggg"), true);
        l2.inserisciInCoda(new Nodo("hhh"), true);
        
        System.out.println(l1.visualizzaLista());
        System.out.println(l2.visualizzaLista());
        System.out.println(Lista.visualizzaLista2(Lista.merge(l1.getTesta(), l2.getTesta())));

    }
    
}
