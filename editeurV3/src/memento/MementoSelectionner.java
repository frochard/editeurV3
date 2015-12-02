package memento;

import commandV2.*;

/**
 *Memento concret utilis� dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoSelectionner implements Memento {

	private SelectionnerEnregistrableV2 savedCommand;
	private int savedDebut;
	private int savedLongueur;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable � sauvegarder dans un memento
	 * @param savedDebut Position du d�but de la s�lection � sauvegarder dans un memento
	 * @param savedLongueur Longueur de la s�lection � sauvegarder dans un memento
	 */
	public MementoSelectionner(SelectionnerEnregistrableV2 savedCommand, int savedDebut, int savedLongueur) {
		this.savedCommand = savedCommand;
		this.savedDebut = savedDebut;
		this.savedLongueur = savedLongueur;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegard�e dans le memento
	 */
	public void setSavedCommand(CommandEnregistrableV2 savedCommand){
		this.savedCommand= (SelectionnerEnregistrableV2) savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegard�e dans le memento
	 * @return savedCommand commande sauvegard�e dans le memento
	 */
	public SelectionnerEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	/**
	 * renvoie le d�but de la s�lection de la commande sauvegard�e dans le memento
	 * @return savedDebut d�but de la s�lection de la commande sauvegard�e 
	 */
	public int getSavedDebut() {
		return savedDebut;
	}

	/**
	 * sauvegarde le d�but de la s�lection de la commande 
	 * @param savedDebut d�but de la s�lection de la commande 
	 */
	public void setSavedDebut(int savedDebut) {
		this.savedDebut = savedDebut;
	}

	/**
	 * renvoie la longueur de la s�lection de la commande sauvegard�e dans le memento
	 * @return savedLongueur longueur de la s�lection de la commande sauvegard�e 
	 */
	public int getSavedLongueur() {
		return savedLongueur;
	}

	/**
	 * sauvegarde la longueur de la s�lection de la commande 
	 * @param savedLongueur longueur de la s�lection de la commande 
	 */
	public void setSavedLongueur(int savedLongueur) {
		this.savedLongueur = savedLongueur;
	}
}