package caretaker;

import java.util.ArrayList;
import commandV2.CommandEnregistrableV2;
import memento.*;

/**
 *Enregistreur de la version 2
 *L�enregistreur a le r�le de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class EnregistreurV2Impl implements EnregistreurV2 {

	private ArrayList<Memento> listeCommandes = new ArrayList<Memento>();

	/**
	 * Renvoie la liste des mementos du Caretaker
	 * @return listeCommandes liste des mementos du Caretaker
	 */
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
				break;        
			case "memento.MementoColler":
				/*Appel de la commande Coller*/
				MementoColler mementoColler=(MementoColler) savedCmd;
				mementoColler.getSavedCommand().restaurerDepuisMemento(mementoColler);
				break;        
			case "memento.MementoSaisir":
				/*Appel de la commande Saisir*/
				MementoSaisir mementoSaisir=(MementoSaisir) savedCmd;
				mementoSaisir.getSavedCommand().restaurerDepuisMemento(mementoSaisir);
				break;        
			case "memento.MementoSelectionner":
				/*Appel de la commande Selectionner*/
				MementoSelectionner mementoSelectionner=(MementoSelectionner) savedCmd;
				mementoSelectionner.getSavedCommand().restaurerDepuisMemento(mementoSelectionner);
				break;        
			default:
				/*Affichage d'un message indiquant une commande inconnue*/
			}
		}
	}

	/**
	 * Ajoute un memento � la liste des mementos du caretaker
	 * @param m memento � ajouter
	 */
	public void addMemento(Memento m) { 
		listeCommandes.add(m);
	}

	/**
	 * Retourne un memento du Caretaker
	 * @param index
	 * @return memento de la liste de mementos du caretaker correspondant � l'index plac� en param�tre
	 */
	public Memento getMemento(int index){
		return listeCommandes.get(index);
	}

	/**
	 * enregistre la commande dans un memento
	 * @param cmdASauver commande � sauvegarder dans le memento
	 */
	@Override
	public void enregistrer(CommandEnregistrableV2 cmdASauver) {
		this.addMemento(cmdASauver.sauverDansMemento());
	}
}
