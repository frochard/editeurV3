package memento;

import commandV2.CollerEnregistrableV2;

public class MementoColler implements Memento{

	private CollerEnregistrableV2 savedCommand;

	/**
	 * 
	 * @param savedCommand Commande enregistrable � sauvegarder dans un memento
	 */
	public MementoColler(CollerEnregistrableV2 savedCommand) {
		this.savedCommand = savedCommand;
	}

	public void setSavedCommand(CollerEnregistrableV2 savedCommand){
		this.savedCommand=savedCommand;
	}
   
	public CollerEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}
   
}
