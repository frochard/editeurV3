package commandV3;

import caretaker.*;
import memento.*;
import receiver.*;

public class MoteurEditionEnregistrable extends MoteurEditionImpl implements CommandEnregistrableV3 {

	private EnregistreurV3Impl enregistreur;
	
	public MoteurEditionEnregistrable(Buffer buffer, PressePapier pressePapier, Selection selection, EnregistreurV3Impl enregistreur) {
		super(buffer, pressePapier, selection);
		this.enregistreur=enregistreur;
	}

	/**
	 * Cette m�thode sauvegarde la commande enregistrable dans un memento
	 * @return m Memento sauvegard�
	 */
	public Memento sauverDansMemento() {
		String txtBuffer=this.getBuffer().getContenu().toString();
		int debutSelection = this.getSelection().getDebutSelection();
		int longueurSelection = this.getSelection().getLongueurSelection();
		MementoMoteurEdition m = new MementoMoteurEdition(txtBuffer,debutSelection,longueurSelection);
		return m;
	}

	/**
	 * Cette m�thode restaure la commande enregistrable depuis un memento
	 * @param m Memento � restaurer
	 */
	public void restaurerDepuisMemento(Memento m) {
		MementoMoteurEdition mRestored = (MementoMoteurEdition) m;
		this.setBuffer(new Buffer(new StringBuffer(mRestored.getSavedStringBuffer())));
		this.setSelection(new Selection(mRestored.getSavedDebutSelection(),mRestored.getSavedLongueurSelection()));
		//mise � jour de l'observer (l'IHM)
		this.majObserver();
	}
}