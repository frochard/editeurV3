package caretaker;

import java.util.ArrayList;
import commandV2.CommandEnregistrableV2;
import memento.*;

public class EnregistreurV2Impl implements EnregistreurV2 {

	private ArrayList<Memento> listeCommandes = new ArrayList<Memento>();

	public ArrayList<Memento> getListeCommandes() {
		return listeCommandes;
	}

	/**
	 * m�thode d�marrant l'enregistrement d'une suite de commandes 
	 */
	public void demarrer(){
		//Suppression de tous les mementos pr�c�dent enregistr�s
		this.listeCommandes.clear();
	}

	/**
	 * m�thode arr�tant l'enregistrement d'une suite de commandes
	 */
	public void arreter(){

	}

	/**
	 * m�thode rejouant la suite de commandes enregistr�e
	 */
	public void rejouer(){
		//Variable contnant la classe du memento stock�
		String mementoClasse;
		//R�cup�ration de la commande dans la liste de memento
		for (Memento savedCmd : listeCommandes){
			//R�cup�ration du type de commande
			mementoClasse=savedCmd.getClass().getName();
			System.out.println("Commande no "+savedCmd.hashCode()+" sur "+listeCommandes.size()+"� rejouer : "+mementoClasse);
			switch (mementoClasse){
			case "memento.MementoCopier":
				/*Appel de la commande Copier*/
				MementoCopier mementoCopier=(MementoCopier) savedCmd;
				mementoCopier.getSavedCommand().restaurerDepuisMemento(mementoCopier);
				break;        
			case "memento.MementoCouper":
				/*Appel de la commande Couper*/
				MementoCouper mementoCouper=(MementoCouper) savedCmd;
				mementoCouper.getSavedCommand().restaurerDepuisMemento(mementoCouper);
				System.out.println("couper rejou� :");
				System.out.println("***************");
				System.out.println("Buffer : "+mementoCouper.getSavedCommand().getReceiver().getBuffer().getContenu().toString());
				System.out.println("PressePapier : "+mementoCouper.getSavedCommand().getReceiver().getPressePapier().getContenu());
				System.out.println("debut selection : "+mementoCouper.getSavedCommand().getReceiver().getSelection().getDebutSelection());
				System.out.println("longueur selection : "+mementoCouper.getSavedCommand().getReceiver().getSelection().getLongueurSelection());
				System.out.println("***************");
				//mementoCopier.getSavedCommand().restaurerDepuisMemento(savedCmd);
				break;        
			case "memento.MementoColler":
				/*Appel de la commande Coller*/
				MementoColler mementoColler=(MementoColler) savedCmd;
				mementoColler.getSavedCommand().restaurerDepuisMemento(mementoColler);
				System.out.println("Coller rejou� :");
				System.out.println("***************");
				System.out.println("Buffer : "+mementoColler.getSavedCommand().getReceiver().getBuffer().getContenu().toString());
				System.out.println("PressePapier : "+mementoColler.getSavedCommand().getReceiver().getPressePapier().getContenu());
				System.out.println("debut selection : "+mementoColler.getSavedCommand().getReceiver().getSelection().getDebutSelection());
				System.out.println("longueur selection : "+mementoColler.getSavedCommand().getReceiver().getSelection().getLongueurSelection());
				System.out.println("***************");
				break;        
			case "memento.MementoSaisir":
				/*Appel de la commande Saisir*/
				MementoSaisir mementoSaisir=(MementoSaisir) savedCmd;
				mementoSaisir.getSavedCommand().restaurerDepuisMemento(mementoSaisir);
				System.out.println("Saisir rejou� :");
				System.out.println("***************");
				System.out.println("Buffer : "+mementoSaisir.getSavedCommand().getReceiver().getBuffer().getContenu().toString());
				System.out.println("PressePapier : "+mementoSaisir.getSavedCommand().getReceiver().getPressePapier().getContenu());
				System.out.println("debut selection : "+mementoSaisir.getSavedCommand().getReceiver().getSelection().getDebutSelection());
				System.out.println("longueur selection : "+mementoSaisir.getSavedCommand().getReceiver().getSelection().getLongueurSelection());
				System.out.println("***************");
				break;        
			case "memento.MementoSelectionner":
				/*Appel de la commande Selectionner*/
				MementoSelectionner mementoSelectionner=(MementoSelectionner) savedCmd;
				mementoSelectionner.getSavedCommand().restaurerDepuisMemento(mementoSelectionner);
				break;        
			default:
				/*Affichage d'un message indiquant une commande inconnue*/;

			}
		}
	}

	public void addMemento(Memento m) { 
		listeCommandes.add(m);
	}

	public Memento getMemento(int index){
		return listeCommandes.get(index);
	}

	@Override
	public void enregistrer(CommandEnregistrableV2 cmdASauver) {
		this.addMemento(cmdASauver.sauverDansMemento());
	}
}
