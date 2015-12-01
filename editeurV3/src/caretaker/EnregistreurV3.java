package caretaker;


import commandV3.MoteurEditionEnregistrable;
import memento.*;
import receiver.MoteurEdition;

public interface EnregistreurV3 {
	public void defaire(MoteurEditionEnregistrable moteur);
	public void refaire(MoteurEditionEnregistrable moteur);
	public void enregistrer(MoteurEditionEnregistrable etatASauver);
	public void addMemento(Memento m);
	public Memento getMemento(int index);

}
