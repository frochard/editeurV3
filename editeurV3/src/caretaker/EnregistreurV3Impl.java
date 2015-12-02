package caretaker;

import java.util.Stack;

import commandV3.MoteurEditionEnregistrable;
import memento.*;
import receiver.*;

/**
 *Enregistreur de la version 3
 *L�enregistreur a le r�le de Caretaker dans le design pattern Memento. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V3 - 30/11/2015
 */
public class EnregistreurV3Impl implements EnregistreurV3 {

	private Stack<Memento> pileDefaire;
	private Stack<Memento> pileRefaire;

	/**
	 * renvoie la pile defaire de l'enregistreur
	 * @return pileDefaire pile d�faire de l'enregistreur
	 */
	public Stack<Memento> getPileDefaire() {
		return pileDefaire;
	}

	/**
	 * renvoie la pile refaire de l'enregistreur
	 * @return pileRefaire pile refaire de l'enregistreur
	 */
	public Stack<Memento> getPileRefaire() {
		return pileRefaire;
	}

	/**
	 * Constructeur de l'enregistreur. cr�e 2 piles vides
	 */
	public EnregistreurV3Impl() {
		super();
		this.pileDefaire = new Stack<Memento>();
		this.pileRefaire = new Stack<Memento>();
	}

	/**
	 * Constructeur de l'enregistreur. cr�e 2 piles vides
	 * @param pileDefaire pile d�faire
	 * @param pileRefaire pile refaire
	 */
	public EnregistreurV3Impl(Stack<Memento> pileDefaire, Stack<Memento> pileRefaire) {
		super();
		this.pileDefaire = pileDefaire;
		this.pileRefaire = pileRefaire;
	}

	/**
	 * Vide la pile refaire
	 */
	public void viderPileRefaire() {
		this.pileRefaire.clear();
	}

	/**
	 * Enregistre l'�tat du moteur dans un memento
	 * @param etatASauver etat du moteur � sauvegarder
	 */
	@Override
	public void enregistrer(MoteurEditionEnregistrable etatASauver) {
		this.addMemento(etatASauver.sauverDansMemento());
	}

	/**
	 * Ajoute un memento � la liste des mementos
	 * @param m memento � ajouter � la liste de memento du caretaker
	 */
	@Override
	public void addMemento(Memento m) {
		this.pileDefaire.add(m);
	}

	/**
	 * Retourne un memento du Caretaker
	 * @param index index dans la liste de memento du caretaker
	 * @return memento de la liste de mementos du caretaker correspondant � l'index plac� en param�tre
	 */
	@Override
	public Memento getMemento(int index){
		return this.pileDefaire.get(index);
	}

	/**
	 * retablit le moteur � l'�tat pr�c�dent la derni�re commande
	 * @param moteur moteur � modifier
	 */
	@Override
	public void defaire(MoteurEditionEnregistrable moteur) {
		// Test si la pile defaire est vide
		if (this.pileDefaire.empty()){
			System.out.println("La pile d�faire est vide");
			moteur.setBuffer(new Buffer(new StringBuffer("")));
			moteur.setPressePapier(new PressePapier(""));
			moteur.setSelection(new Selection(0,0));
			//mise � jour de l'observer (l'IHM)
			moteur.majObserver();
		}else{
			//On retire l'�tat du haut de la pile d�faire et on le met au dessus de la pile refaire
			Memento etatMoteur=this.pileDefaire.pop();
			this.pileRefaire.push(etatMoteur);
			if (this.pileDefaire.empty()){
				moteur.setBuffer(new Buffer(new StringBuffer("")));
				moteur.setPressePapier(new PressePapier(""));
				moteur.setSelection(new Selection(0,0));
				//mise � jour de l'observer (l'IHM)
				moteur.majObserver();
			}else{
				//On r�cup�re le memento en haut de la pile defaire
				MementoMoteurEdition mementoArejouer=(MementoMoteurEdition) this.pileDefaire.peek();
				moteur.restaurerDepuisMemento(mementoArejouer);
			}
		}
	}

	/**
	 * retablit le moteur � l'�tat pr�c�dent la derni�re commande d�faite
	 * @param moteur moteur � modifier
	 */
	@Override
	public void refaire(MoteurEditionEnregistrable moteur) {
		// Test si la pile refaire est vide
		if (this.pileRefaire.empty()){
			System.out.println("La pile refaire est vide");
		}else{
			//On r�cup�re le memento en haut de la pile refaire
			MementoMoteurEdition mementoArejouer=(MementoMoteurEdition) this.pileRefaire.peek();
			moteur.restaurerDepuisMemento(mementoArejouer);
			//On retire l'�tat du haut de la pile refaire et on le met au dessus de la pile d�faire
			Memento etatMoteur=this.pileRefaire.pop();
			this.pileDefaire.push(etatMoteur);
		}
	}
}