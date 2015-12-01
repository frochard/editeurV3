package memento;

import commandV3.MoteurEditionEnregistrable;
import receiver.*;

public class MementoMoteurEdition implements Memento {
	
	private String savedStringBuffer;
	private int savedDebutSelection;
	private int savedLongueurSelection;
	
	public MementoMoteurEdition(String savedStringBuffer, int savedDebutSelection, int savedLongueurSelection) {
		super();
		this.savedStringBuffer = savedStringBuffer;
		this.savedDebutSelection = savedDebutSelection;
		this.savedLongueurSelection = savedLongueurSelection;
	}

	public String getSavedStringBuffer() {
		return savedStringBuffer;
	}

	public int getSavedDebutSelection() {
		return savedDebutSelection;
	}

	public void setSavedDebutSelection(int savedDebutSelection) {
		this.savedDebutSelection = savedDebutSelection;
	}

	public int getSavedLongueurSelection() {
		return savedLongueurSelection;
	}

	public void setSavedLongueurSelection(int savedLongueurSelection) {
		this.savedLongueurSelection = savedLongueurSelection;
	}

	public void setSavedStringBuffer(String savedStringBuffer) {
		this.savedStringBuffer = savedStringBuffer;
	}
}