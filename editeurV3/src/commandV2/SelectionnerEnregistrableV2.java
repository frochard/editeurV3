package commandV2;

import caretaker.*;
import command.*;
import invoker.*;
import memento.*;
import receiver.*;

public class SelectionnerEnregistrableV2 extends Selectionner implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	public SelectionnerEnregistrableV2(MoteurEditionImpl receiver, Ihm invocator, EnregistreurV2Impl enregistreur) {
		super(receiver, invocator);
		this.enregistreur=enregistreur;
	}

	@Override
	public void execute() {
		//Ex�cute la commande saisir
		super.execute();
		//Ajoute la commande dans la liste ordonn�e de memento du caretaker Enregistreur
		enregistreur.addMemento(this.sauverDansMemento());
	}

	@Override
	/**
	 * Cette m�thode sauvegarde la commande enregistrable dans un memento
	 */
	public Memento sauverDansMemento() {
		MementoSelectionner m = new MementoSelectionner(this,invocator.getSelectionDebut(),invocator.getSelectionLongueur());
		return m;
	}

	@Override
	/**
	 * Cette m�thode restaure la commande enregistrable depuis un memento
	 */
	public void restaurerDepuisMemento(Memento m) {
		MementoSelectionner mRestored = (MementoSelectionner) m;
		int debut=mRestored.getSavedDebut();
		int longueur=mRestored.getSavedDebut();
		receiver.selectionner(debut, longueur);
		this.getReceiver().majObserver();
	}

}
