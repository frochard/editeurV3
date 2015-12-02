package caretaker;


import commandV3.MoteurEditionEnregistrable;
import memento.*;
import receiver.MoteurEdition;

/**
 *Enregistreur de la version 3
 *L’enregistreur a le rôle de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V3 - 30/11/2015
 */
public interface EnregistreurV3 {
	/**
	 * Défait la dernière commande
	 */
	public void defaire(MoteurEditionEnregistrable moteur);
	
	/**
	 * Refait la dernière commande défaite
	 */
	public void refaire(MoteurEditionEnregistrable moteur);
	
	/**
	 * enregistre l'état du moteur dans un memento
	 * @param etatASauver état du moteur à sauver
	 */
	public void enregistrer(MoteurEditionEnregistrable etatASauver);

	/**
	 * ajoute un memento à la liste des mementos de l'enregistreur
	 * @param m memento à ajouter
	 */
	public void addMemento(Memento m);

	/**
	 * Retourne un memento du Caretaker
	 * @param index
	 * @return memento de la liste de mementos du caretaker correspondant à l'index placé en paramètre
	 */
	public Memento getMemento(int index);
}
