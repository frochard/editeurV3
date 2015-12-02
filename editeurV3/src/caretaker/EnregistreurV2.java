package caretaker;

import memento.*;
import commandV2.CommandEnregistrableV2;

/**
 *Enregistreur de la version 2
 *L�enregistreur a le r�le de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public interface EnregistreurV2 {

	/**
	 * D�marre un enregistrement
	 */
	public void demarrer();
	
	/**
	 * Arr�te un enregistrement
	 */
	public void arreter();
	
	/**
	 * Rejoue un enregistrement
	 */
	public void rejouer();
	
	/**
	 * enregistre la commande dans un memento
	 * @param cmdASauver commande � sauvegarder dans le memento
	 */
	public void enregistrer(CommandEnregistrableV2 cmdASauver);
	
	/**
	 * Ajoute un memento � la liste des memento
	 * @param m memento � ajouter � l'enregistreur
	 */
	public void addMemento(Memento m);
	
	/**
	 * Retourne un memento du Caretaker
	 * @param index index das la liste de memento du caretaker
	 * @return memento de la liste de mementos du caretaker correspondant � l'index plac� en param�tre
	 */
	public Memento getMemento(int index);
		
}