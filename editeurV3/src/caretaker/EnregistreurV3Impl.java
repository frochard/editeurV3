package caretaker;

import java.util.Stack;

import commandV3.MoteurEditionEnregistrable;
import memento.*;
import receiver.*;

public class EnregistreurV3Impl implements EnregistreurV3 {

	private Stack<Memento> pileDefaire;
	private Stack<Memento> pileRefaire;

	public Stack<Memento> getPileDefaire() {
		return pileDefaire;
	}

	public Stack<Memento> getPileRefaire() {
		return pileRefaire;
	}

	public EnregistreurV3Impl() {
		super();
		this.pileDefaire = new Stack<Memento>();
		this.pileRefaire = new Stack<Memento>();
	}

	public EnregistreurV3Impl(Stack<Memento> pileDefaire, Stack<Memento> pileRefaire) {
		super();
		this.pileDefaire = pileDefaire;
		this.pileRefaire = pileRefaire;
	}

	public void viderPileRefaire() {
		this.pileRefaire.clear();
	}

	@Override
	public void enregistrer(MoteurEditionEnregistrable etatASauver) {
		System.out.println("++++++++++++++");
		System.out.println("");
		System.out.println(etatASauver.getBuffer().getContenu().toString());
		System.out.println(etatASauver.getBuffer());
		System.out.println("++++++++++++++");
		this.addMemento(etatASauver.sauverDansMemento());
	}

	@Override
	public void addMemento(Memento m) {
		this.pileDefaire.add(m);
	}

	@Override
	public Memento getMemento(int index){
		return this.pileDefaire.get(index);
	}

	@Override
	public void defaire(MoteurEditionEnregistrable moteur) {
		// Test si la pile defaire est vide
		if (this.pileDefaire.empty()){
			System.out.println("La pile défaire est vide");
			moteur.setBuffer(new Buffer(new StringBuffer("")));
			moteur.setPressePapier(new PressePapier(""));
			moteur.setSelection(new Selection(0,0));
			//mise à jour de l'observer (l'IHM)
			moteur.majObserver();
		}else{
			//On retire l'état du haut de la pile défaire et on le met au dessus de la pile refaire
			Memento etatMoteur=this.pileDefaire.pop();
			this.pileRefaire.push(etatMoteur);
			if (this.pileDefaire.empty()){
				moteur.setBuffer(new Buffer(new StringBuffer("")));
				moteur.setPressePapier(new PressePapier(""));
				moteur.setSelection(new Selection(0,0));
				//mise à jour de l'observer (l'IHM)
				moteur.majObserver();
			}else{
				//On récupère le memento en haut de la pile defaire
				MementoMoteurEdition mementoArejouer=(MementoMoteurEdition) this.pileDefaire.peek();
				moteur.restaurerDepuisMemento(mementoArejouer);
			}
		}
	}

	@Override
	public void refaire(MoteurEditionEnregistrable moteur) {
		// Test si la pile refaire est vide
		if (this.pileRefaire.empty()){
			System.out.println("La pile refaire est vide");
		}else{
			//On récupère le memento en haut de la pile refaire
			MementoMoteurEdition mementoArejouer=(MementoMoteurEdition) this.pileRefaire.peek();
			moteur.restaurerDepuisMemento(mementoArejouer);
			//On retire l'état du haut de la pile refaire et on le met au dessus de la pile défaire
			Memento etatMoteur=this.pileRefaire.pop();
			this.pileDefaire.push(etatMoteur);
		}
	}
}