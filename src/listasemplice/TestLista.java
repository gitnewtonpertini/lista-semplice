/*
 * Esercizio di pag 139-156 del libri di testo (Corso di Informatica -
 * Formichi - Meini 2)
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
        Lista lista = new Lista();
        lista.inserisciInTesta(new Nodo("primo"));
        lista.inserisciInTesta(new Nodo("secondo"));
        lista.inserisciInTesta(new Nodo("terzo"));
        lista.inserisciInTesta(new Nodo("quarto"));
        lista.inserisciInTesta(new Nodo("quinto"));
        lista.inserisciInCoda(new Nodo("sesto"), true);
        lista.inserisciInCoda(new Nodo("settimo"), true);
        lista.inserisciInCoda(new Nodo("ottavo"), false);
        lista.inserisciInCoda(new Nodo("nono"), false);
        System.out.println("Posizione 5: " + lista.cercaNodo(5).visualizzaNodo());
        System.out.println(lista.visualizzaLista());
        // Inserisco in posizione 5
        lista.inserisciInPosizione(new Nodo("quinto bis"), 5-1);
        System.out.println(lista.visualizzaLista());
        lista.eliminaInTesta();
        System.out.println("Dopo eliminazione del nodo in testa");
        System.out.println(lista.visualizzaLista());
        lista.eliminaInCoda();
        System.out.println("Dopo eliminazione del nodo di coda");
        System.out.println(lista.visualizzaLista());
        // Metodo rapido di costruzione di una lista di N elementi, con valori casuali
        Lista lista2 = new Lista(100);
        System.out.println(lista2.visualizzaLista());
    }
    
}
