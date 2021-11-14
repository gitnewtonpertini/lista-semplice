/*
 * Gestione di una lista semplice (Corso di Informatica - Formichi - Meini 2)
 * 
 */
package listasemplice;

/**
 * @author gianfranco
 *
 */
public class Lista {
	private Nodo testa;
	private Nodo coda;
	// In alternativa si potrebbe utilizzare un contatore "statico" cioè
	// dichiarare nella classe Nodo una variabile di tipo static (es. statin int
	// numeroNodi = 0)
	private int numeroNodi;

	Lista() {
		this.testa = null;
		this.coda = null;
		this.numeroNodi = 0;
	}

	Lista(Nodo nodo) {
		this.testa = null;
		this.coda = null;
		this.numeroNodi = 0;
		this.inserisciInTesta(nodo);
	}

	// Metodo rapido di costruzione di una lista di nodi la cui cardinalità
	// viene fornita come parametro (int); l'attributo info verrà valorizzato
	// in modo casuale.
	Lista(int numeroNodi) {
		this.testa = new Nodo();
		this.coda = testa;
		// TODO: gestire una eventuale eccezione derivante da un
		// errore di tipo NullPointerException
		for (int i = 1; i < numeroNodi; i++) {
			// TODO: fare tutto in un'unica riga di codice
			Nodo n = new Nodo();
			this.coda.setSuccessivo(n);
			this.coda = n;
		}
		this.numeroNodi = numeroNodi;
	}

	// Inserimento in testa
	public void inserisciInTesta(Nodo nodo) {
		// I casi sono due:
		// 1. la lista è vuota, cioè this.testa è null
		if (this.testa == null) {
			this.testa = nodo;
			this.coda = nodo;
			this.numeroNodi++;
		}
		// 2. la lista ha almeno un elemento, quindi devo aggiungerlo
		// in testa, ed aggiornare il valore di this.testa
		// TODO: (per casa) se nodo è null verrebbe generata una eccezione,
		// quindi bisogna gestirla (try-catch)
		else {
			nodo.setSuccessivo(this.testa);
			this.testa = nodo;
			this.numeroNodi++;
		}
	}

	// Cerca il nodo corrispondente alla parola chiave restituendo il riferimento
	// al nodo precedente
	public Nodo cercaNodo(String chiave) {
		Nodo p = this.testa;
		Nodo pp = this.testa;
		if (p == null)
			return null;
		while (p != null && !p.getInfo().equals(chiave)) {
			pp = p;
			p = p.getSuccessivo();
		}
		if (p != null)
			return pp;
		else
			return null;
	}

	// Cerca il nodo corrispondente alla parola chiave restituendo il riferimento
	// al nodo precedente
	public Nodo cercaNodoRicorsiva(String chiave, Nodo p) {
		if (p == null)
			return null;
		if (p.getInfo().equals(chiave))
			return p;
		else
			return cercaNodoRicorsiva(chiave, p.getSuccessivo());
	}

	// Cerca il nodo corrispondente alla posizione data
	public Nodo cercaNodo(int pos) {

		int i = 1;
		Nodo p = this.testa;
		// TODO: se la lista è vuota genera eccezione!!
		while (p != null && i < pos) {
			p = p.getSuccessivo();
			i++;
		}
		// p è il nodo (riferimento) corrispondente alla posizione
		// desiderata oppure all'ultimo nodo (potrebbero verificarsi
		// entrambe le situazioni).
		return p;
	}

	// Ricerca ricorsiva del massimo (ordinamento lessicografico)
	String cercaMassimoRicorsiva(String max, Nodo p) {

		if (p == null)
			return max;
		else if (p.getInfo().compareTo(max) > 0)
			max = p.getInfo();
		return cercaMassimoRicorsiva(max, p.getSuccessivo());
	}

	// Inserisce un nodo nella posizione indicata dal parametro
	// se la posizione è un valore minore di zero, allora inserisce in testa
	// se la posizione è maggiore del numero di elementi della lista, allora
	// inserisce in coda.
	public void inserisciInPosizione(Nodo nodo, int pos) {
		if (pos < 0)
			this.inserisciInTesta(nodo);
		else {
			Nodo p = this.cercaNodo(pos);
			// Controllo prima se p è l'ultimo nodo
			// if ( p.getSuccessivo() == null )
			if (p == coda)
				this.inserisciInCoda(nodo, true);
			else {
				nodo.setSuccessivo(p.getSuccessivo());
				p.setSuccessivo(nodo);
			}
		}
	}

	// Inserisce un nuovo nodo in coda alla lista; due modalità:
	// 1. (modo == true) direttamente in coda utilizzando il riferimento alla coda
	// 2. (modo == false) partendo dalla testa della lista
	public void inserisciInCoda(Nodo nodo, boolean modo) {
		// Se modo == true parto dalla coda (1)
		if (modo) {
			if (this.coda == null) {
				testa = coda = nodo;
			} else {
				coda.setSuccessivo(nodo);
				coda = nodo;
			}
			this.numeroNodi++;
		}
		// Se modo == false parto dalla testa (2)
		else {
			// Controllo se la lista è vuota
			if (this.testa == null) {
				this.testa = nodo;
				this.coda = nodo;
				this.numeroNodi++;
			} else {
				Nodo p = this.testa;
				// Allo scopo di uscire dal ciclo con il puntatore all'ultimo elemento della
				// lista (quindi non nullo) la condizione di uscita deve essere: "il successivo
				// del
				// nodo corrente non esiste" cioè: p.getSuccessivo() == null (nel while deve
				// essere invertita)
				while (p.getSuccessivo() != null)
					p = p.getSuccessivo();
				// Aggiungo il nuovo nodo dopo il nodo corrente (il cui riferimento è p)
				p.setSuccessivo(nodo);
				this.coda = nodo;
				this.numeroNodi++;
			}
		}
	}

	// TODO: creare un metodo che riceve come parametro un indice numerico
	// (posizione)
	// e restituisce il nodo (riferimento) della lista che si trova in tale
	// posizione.
	public Nodo getNodo(int pos) {
		return null;
	}

	// TODO: creare una seconda versione del metodo (overloadind) che riceve
	// come parametro un indice intero, che rappresenta l'elemento della
	// lista a partire quale essa deve venir visualizzata.
	public String visualizzaLista() {

		Nodo p = this.testa;
		String str = "";
		int i = 1;
		while (p != null) {
			str += i + "-" + p.getInfo() + " ";
			p = p.getSuccessivo();
			i++;
		}
		return "N.ro nodi: " + this.numeroNodi + "\r\n" + str;
	}

	// Versione ricorsiva
	public String visualizzaListaRicorsiva(Nodo p) {

		if (p == null)
			return "";
		else {
			return p.getInfo() + " " + visualizzaListaRicorsiva(p.getSuccessivo());
		}
	}

	// Eliminazione del nodo di testa
	public void eliminaInTesta() {
		if (this.testa != null) {
			testa = testa.getSuccessivo();
			numeroNodi--;
		}
	}

	// Eliminazione del nodo di coda
	public void eliminaInCoda() {
		Nodo p = this.testa;
		Nodo penultimo = this.testa;
		while (p.getSuccessivo() != null) {
			penultimo = p;
			p = p.getSuccessivo();
		}
		penultimo.setSuccessivo(null);
		this.numeroNodi--;
		// Aggiorno il riferimento alla coda
		this.coda = penultimo;
	}

	public Nodo getTesta() {
		return this.testa;
	}

	// Scambia due nodi di posizione data: h, k
	public void shuffle(int h, int k) {
		Nodo pph, ph, ppk, pk, tpk;

		pph = cercaNodo(h - 1);
		ph = pph.getSuccessivo();
		ppk = cercaNodo(k - 1);
		pk = ppk.getSuccessivo();

		System.out.println(ph.getInfo());
		System.out.println(pk.getInfo());

		pph.setSuccessivo(pk);
		tpk = pk.getSuccessivo();
		pk.setSuccessivo(ph.getSuccessivo());

		ppk.setSuccessivo(ph);
		ph.setSuccessivo(tpk);
	}

	/*
	 * Metodo statico: non opera (non potrebbe!) su proprietà dell'oggetto.
	 * 
	 * L1 e L2 sono due liste istanziate esternamente (nel main). Verifica se una
	 * data lista (L2) è una sottolista di (L1)
	 * 
	 * S(L1(i),L2(j)): boolean {
	 * 		se L2(j) == null
	 * 			return true
	 * 		se L1(i) == null
	 * 			return false
	 * 		
	 * 		return (L1(i) == L2(j)) && S(L1(i+1),L2(j+1)
	 * }
	 */
	public static boolean isSottolista(Nodo pL1, Nodo pL2) {

		if (pL2 == null)
			return true;
		if (pL1 == null)
			return false;

		return pL1.getInfo().equals(pL2.getInfo()) && isSottolista(pL1.getSuccessivo(), pL2.getSuccessivo());
	}

	/*
	 * Esegue il merge di due liste ordinate (ricorsiva) Metodo statico: non opera
	 * (non potrebbe!) su proprietà dell'oggetto, L1 e L2 sono due liste istanziate
	 * esternamente (nel main).
	 * 
	 * M(L1(i),L2(j)): L {
	 * 		se L1(i) == null 
	 * 			return resto di L2 
	 * 		se L2(j) == null
	 * 			return resto di L1
	 * 
	 * 		se L1(i) < L2(j) 
	 * 			return L1(i)+M(L1(i+1),L2(j)) 
	 * 		altrimenti return L2(j)+M(L1(i),L2(j+1)) 
	 * }
	 */
	public static Nodo merge(Nodo pL1, Nodo pL2) {

		if (pL1 == null)
			return pL2;

		if (pL2 == null)
			return pL1;

		if (pL1.getInfo().compareTo(pL2.getInfo()) < 0) {
			pL1.setSuccessivo(merge(pL1.getSuccessivo(), pL2));
			return pL1;
		} else {
			pL2.setSuccessivo(merge(pL1, pL2.getSuccessivo()));
			return pL2;
		}
	}

	public static String visualizzaLista2(Nodo testa) {

		Nodo p = testa;
		String str = "";
		int i = 1;
		while (p != null) {
			str += i + "-" + p.getInfo() + " ";
			p = p.getSuccessivo();
			i++;
		}
		return str;
	}
}
