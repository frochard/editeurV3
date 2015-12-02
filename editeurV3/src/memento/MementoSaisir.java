package memento;

import commandV2.*;

/**
 *Memento concret utilis� dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoSaisir implements Memento {

	private SaisirEnregistrableV2 savedCommand;
	private String savedTxt;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable � sauvegarder dans un memento
	 * @param savedTxt Texte de la commande saisir � sauvegarder dans un memento
	 */
	public MementoSaisir(SaisirEnregistrableV2 savedCommand, String savedTxt) {
		this.savedCommand = savedCommand;
		this.savedTxt = savedTxt;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegard�e dans le memento
	 */
	public void setSavedCommand(CommandEnregistrableV2 savedCommand){
		this.savedCommand= (SaisirEnregistrableV2) savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegard�e dans le memento
	 * @return savedCommand commande sauvegard�e dans le memento
	 */
	public SaisirEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	/**
	 * renvoie le texte de la commande saisir sauvegard� dans le memento
	 * @return savedTxt texte de la commande saisir sauvegard� dans le memento
	 */
	public String getSavedTxt() {
		return savedTxt;
	}

	/**
	 * sauvegarde le texte de la commande saisir dans le memento
	 * @param savedTxt texte de la commande saisir � sauvegarder dans le memento
	 */
	public void setSavedTxt(String savedTxt) {
		this.savedTxt = savedTxt;
	}
}