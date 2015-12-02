package memento;

import commandV2.CopierEnregistrableV2;

/**
 *Memento concret utilis� dans le Design Pattern Memento.  
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class MementoCopier implements Memento {

	private CopierEnregistrableV2 savedCommand;

	/**
	 * Constructeur
	 * @param savedCommand Commande enregistrable � sauvegarder dans un memento
	 */
	public MementoCopier(CopierEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	/**
	 * sauvegarde la commande dans le memento
	 * @param savedCommand commande sauvegard�e dans le memento
	 */
	public void setSavedCommand(CopierEnregistrableV2 savedCommand){
		this.savedCommand= savedCommand;
	}
   
	/**
	 * renvoie la commande sauvegard�e dans le memento
	 * @return savedCommand commande sauvegard�e dans le memento
	 */
	public CopierEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}
}