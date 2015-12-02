package caretaker;


import commandV3.MoteurEditionEnregistrable;
import memento.*;
import receiver.MoteurEdition;

/**
 *Enregistreur de la version 3
 *L�enregistreur a le r�le de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V3 - 30/11/2015
 */
public interface EnregistreurV3 {
	/**
	 * D�fait la derni�re commande
	 */
	public void defaire(MoteurEditionEnregistrable moteur);
	
	/**
	 * Refait la derni�re commande d�faite
	 */
	public void refaire(MoteurEditionEnregistrable moteur);
	
	/**
	 * enregistre l'�tat du moteur dans un memento
	 * @param etatASauver �tat du moteur � sauver
	 */
	public void enregistrer(MoteurEditionEnregistrable etatASauver);

	/**
	 * ajoute un memento � la liste des mementos de l'enregistreur
	 * @param m memento � ajouter
	 */
	public void addMemento(Memento m);

	/**
	 * Retourne un memento du Caretaker
	 * @param index
	 * @return memento de la liste de mementos du caretaker correspondant � l'index plac� en param�tre
	 */
	public Memento getMemento(int index);
}
