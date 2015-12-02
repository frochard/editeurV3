package memento;

import commandV2.CouperEnregistrableV2;

/**
 *Memento concret utilis� dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoCouper implements Memento {

	private CouperEnregistrableV2 savedCommand;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable � sauvegarder dans un memento
	 */
	public MementoCouper(CouperEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegard�e dans le memento
	 */
	public void setSavedCommand(CouperEnregistrableV2 savedCommand){
		this.savedCommand= savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegard�e dans le memento
	 * @return savedCommand commande sauvegard�e dans le memento
	 */
	public CouperEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}
}