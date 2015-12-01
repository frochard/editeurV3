package commandV2;

import caretaker.EnregistreurV2Impl;
import command.*;
import invoker.*;
import memento.*;
import receiver.*;

public class SaisirEnregistrableV2 extends Saisir implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;

	public SaisirEnregistrableV2(MoteurEditionImpl receiver, Ihm invocator,EnregistreurV2Impl enregistreur) {
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
		MementoSaisir m = new MementoSaisir(this,invocator.getText());
		return m;
	}

	@Override
	/**
	 * Cette m�thode restaure la commande enregistrable depuis un memento
	 */
	public void restaurerDepuisMemento(Memento m) {
		MementoSaisir mRestored = (MementoSaisir) m;
		receiver.saisir(mRestored.getSavedTxt());
	}

}
