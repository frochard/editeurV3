package commandV2;

import memento.Memento;

/**
 *Interface Commande dans le Design Pattern Command. Cette interface est commune aux commandes concr�tes de la V2. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public interface CommandEnregistrableV2{

	/**
	 * Sauve la commande dans un memento
	 * @return m memento contenant la commande
	 */
	public Memento sauverDansMemento();

	/**
	 * restaure une commande stock�e dans un memento
	 * @param m memento contenant la commande � restaurer
	 */
	void restaurerDepuisMemento(Memento m);
}
