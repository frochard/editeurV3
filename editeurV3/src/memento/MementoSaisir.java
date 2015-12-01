package memento;

import commandV2.CommandEnregistrableV2;
import commandV2.SaisirEnregistrableV2;

public class MementoSaisir implements Memento {

	private SaisirEnregistrableV2 savedCommand;
	private String savedTxt;

	/**
	 * 
	 * @param savedCommand Commande enregistrable à sauvegarder dans un memento
	 */
	public MementoSaisir(SaisirEnregistrableV2 savedCommand, String savedTxt) {
		this.savedCommand = savedCommand;
		this.savedTxt = savedTxt;
	}

	public void setSavedCommand(CommandEnregistrableV2 savedCommand){
		this.savedCommand= (SaisirEnregistrableV2) savedCommand;
	}
   
	public SaisirEnregistrableV2 getSavedCommand(){
	   return savedCommand;
	}

	public String getSavedTxt() {
		return savedTxt;
	}

	public void setSavedTxt(String savedTxt) {
		this.savedTxt = savedTxt;
	}

	

}