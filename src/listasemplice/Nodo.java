/*
 * Gestione di una lista semplice (Corso di Informatica - Formichi - Meini 2)
 * 
 */
package listasemplice;

import java.util.Random;


/**
 *
 * @author Admin
 */
public class Nodo {
    
    // TODO: aggiungere un attributo di tipo int che
    // indichi la posizione del nodo nella lista; attenzione:
    // in caso di cancellazione di un nodo è necessario effettuare
    // una ri-numerazione dei nodi successivi.
    private String info;

    // succ è un riferimento cioè un indirizzo;
    // in c++, la dichiarazione equivalente è: Nodo* succ cioè
    // succ è un puntatore ad istanze di oggetti della classe Nodo,
    // cioè un indirizzo. Quindi sia in Java che in c++ gli elenti della
    // lista sono collegato tra loro mediante indirizzi.
    private Nodo succ;
        
    public Nodo() {
        // TODO: non genera correttamente il valore casuale (CORREGGERE)
        Random rnd = new Random();
        rnd.setSeed(10000);
        this.info = String.valueOf(rnd.nextInt());
        this.succ = null;
    }
    
    public Nodo(String info) {
        this.info = info;
        this.succ = null;
    }
    
    public void setSuccessivo(Nodo succ) {
        this.succ = succ;
    }

    public Nodo getSuccessivo() {
        return this.succ;
    }

    public String visualizzaNodo() {
        return "Info: " + info + "\n\r";
    }

	public String getInfo() {
		return this.info;
	}

    
}
