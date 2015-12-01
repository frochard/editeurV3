package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Couper;
import memento.*;
import receiver.MoteurEditionImpl;

public class CouperEnregistrableV2 extends Couper implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	public CouperEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	@Override
	public void execute() {
		//Ex�cute la commande couper
		super.execute();
		//Ajoute la commande dans la liste ordonn�e de memento du caretaker Enregistreur
		enregistreur.addMemento(this.sauverDansMemento());
	   }

		@Override
		/**
		 * Cette m�thode sauvegarde la commande enregistrable dans un memento
		 */
		public Memento sauverDansMemento() {
			MementoCouper m = new MementoCouper(this);
			return m;
		}

		@Override
		/**
		 * Cette m�thode restaure la commande enregistrable depuis un memento
		 */
		public void restaurerDepuisMemento(Memento m) {
			MementoCouper mRestored = (MementoCouper) m;
			super.execute();
		}


}
