package commandV2;

import caretaker.EnregistreurV2Impl;
import command.SuppressionAvant;
import memento.Memento;
import receiver.MoteurEditionImpl;

public class SuppressionAvantEnregistrableV2 extends SuppressionAvant implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	public SuppressionAvantEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	@Override
	public void execute() {
		//Ex�cute la commande couper
		super.execute();
		//Ajoute la commande dans la liste ordonn�e de memento du caretaker Enregistreur
		
   }

	@Override
	public Memento sauverDansMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void restaurerDepuisMemento(Memento memento) {
		// TODO Auto-generated method stub
		
	}

}
