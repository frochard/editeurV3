package memento;

import commandV3.MoteurEditionEnregistrable;
import receiver.*;

/**
 *Memento concret utilisé dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V3 - 02/12/2015
 */
public class MementoMoteurEdition implements Memento {
	
	private String savedStringBuffer;
	private int savedDebutSelection;
	private int savedLongueurSelection;
	
	/**
	 * Constructeur
	 * @param savedStringBuffer chaine du buffer du moteur
	 * @param savedDebutSelection position de début de sélection du moteur
	 * @param savedLongueurSelection longueur de sélection du moteur
	 * 
	 */
	public MementoMoteurEdition(String savedStringBuffer, int savedDebutSelection, int savedLongueurSelection) {
		super();
		this.savedStringBuffer = savedStringBuffer;
		this.savedDebutSelection = savedDebutSelection;
		this.savedLongueurSelection = savedLongueurSelection;
	}

	/**
	 * renvoie la chaine du buffer sauvegardé
	 * @return savedStringBuffer chaine du buffer sauvegardé
	 */
	public String getSavedStringBuffer() {
		return savedStringBuffer;
	}

	/**
	 * renvoie le debut de la selection du moteur
	 * @return savedDebutSelection debut de la selection du moteur
	 */
	public int getSavedDebutSelection() {
		return savedDebutSelection;
	}

	/**
	 * sauvegarde le début de la selection du moteur
	 * @param savedDebutSelection longueur de la selection du moteur
	 */
	public void setSavedDebutSelection(int savedDebutSelection) {
		this.savedDebutSelection = savedDebutSelection;
	}

	/**
	 * renvoie la longueur de la selection du buffer sauvegardé
	 * @return savedLongueurSelection longueur de la selection du moteur
	 */
	public int getSavedLongueurSelection() {
		return savedLongueurSelection;
	}

	/**
	 * sauvegarde la longueur de la selection du moteur
	 * @param savedLongueurSelection longueur de la selection du moteur
	 */
	public void setSavedLongueurSelection(int savedLongueurSelection) {
		this.savedLongueurSelection = savedLongueurSelection;
	}

	/**
	 * sauvegarde la chaine du buffer
	 * @param savedStringBuffer chaine du buffer à sauvegarder
	 */
	public void setSavedStringBuffer(String savedStringBuffer) {
		this.savedStringBuffer = savedStringBuffer;
	}
}