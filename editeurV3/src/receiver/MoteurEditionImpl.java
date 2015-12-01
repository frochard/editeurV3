package receiver;

import java.util.Observable;
import java.util.Observer;

import invoker.Ihm;

/**
 *Cette classe impl�mente l'interface MoteurEdition du Design Pattern Command
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */

public class MoteurEditionImpl extends Observable implements MoteurEdition {

	private Buffer buffer;
	private PressePapier pressePapier;
	private Selection selection;
	private boolean etat;/*attribut pour le DP Observer*/

	/**
	 * retourne le buffer du moteur d'�dition
	 * @return buffer buffer du moteur d'�dition
	 */
	public Buffer getBuffer() {
		return buffer;
	}

	/**
	 * retourne le presse papier du moteur d'�dition
	 * @return pressePapier presse papier du moteur d'�dition
	 */
	public PressePapier getPressePapier() {
		return pressePapier;
	}

	/**
	 * retourne la s�lection du moteur d'�dition
	 * @return selection relourne la s�lection du moteur d'�dition
	 */
	public Selection getSelection() {
		return selection;
	}

	/**
	 * affecte un buffer au moteur d'�dition
	 * @param buffer buffer � affecter au moteur d'�dition
	 */
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	/**
	 * affecte un presse Papier au moteur d'�dition
	 * @param pressePapier presse Papier � affecter au moteur d'�dition
	 */
	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}

	/**
	 * affecte une s�lection au moteur d'�dition
	 * @param selection s�lection � affecter au moteur d'�dition
	 */
	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	/**
	 * Constructeur du moteur d'�dition
	 * @param buffer buffer du moteur d'�dition
	 * @param pressePapier presse papier du moteur d'�dition
	 * @param selection s�lection du moteur d'�dition
	 */
	public MoteurEditionImpl(Buffer buffer, PressePapier pressePapier, Selection selection) {
		this.buffer = buffer;
		this.pressePapier = pressePapier;
		this.selection = selection;
	}

	/**
	 * M�thode couper : 
	 * - Supprime s�lection du buffer
	 * - Ajout de la s�lection dans le presse papier
	 */
	@Override
	public void couper() throws UnsupportedOperationException{
		int debutSelection= this.selection.getDebutSelection();
		int longueurSelection = this.selection.getLongueurSelection();
		//Recuperation de la cha�ne dans le buffer
		String chaineArecuperer=this.buffer.getContenu().substring(debutSelection, debutSelection+longueurSelection);
		//Affectation de la chaine dans le presse papier
		this.pressePapier.setContenu(chaineArecuperer);
		// Suppression dans le buffer de la chaine coup�e
		this.buffer.getContenu().delete(debutSelection,debutSelection+longueurSelection);
		//Modification de la s�lection
		this.selection.setLongueurSelection(0);
		//Envoi d'une notification � l'IHM
		majObserver();
	}

	/**
	 * M�thode copier : 
	 * - Ajout de la s�lection dans le presse papier
	 */
	@Override
	public void copier() throws UnsupportedOperationException{
		int debutSelection= this.selection.getDebutSelection();
		int longueurSelection = this.selection.getLongueurSelection();
		//Test s'il y a une chaine de s�lectionner
		if (longueurSelection>0){
			//Recuperation de la cha�ne dans le buffer
			String chaineArecuperer=this.buffer.getContenu().substring(debutSelection, debutSelection+longueurSelection);
			//Affectation de la chaine dans le presse papier
			this.pressePapier.setContenu(chaineArecuperer);
		}
	}

	/**
	 * M�thode coller : 
	 * le presse papier est ins�r� dans le buffer � partie du d�but de la s�lection
	 */
	@Override
	public void coller() throws UnsupportedOperationException{
		int debutSelection= this.selection.getDebutSelection();
		//Recuperation de la cha�ne dans le presse papier
		String txtAInserer=this.pressePapier.getContenu();
		//Insertion de la cha�ne dans le buffer
		this.buffer.getContenu().insert(debutSelection,txtAInserer);
		//Modification de la s�lection
		this.selection.setDebutSelection(debutSelection+txtAInserer.length());
		this.selection.setLongueurSelection(0);
		//Envoi d'une notification � l'IHM
		majObserver();
	}

	/** 
	 * M�thode s�lectionner : modifie le d�but et la longueur de la s�lection
	 * @param debut debut de la s�lection
	 * @param longueur longueur de la s�lection
	 */
	@Override
	public void selectionner(int debut, int longueur) throws UnsupportedOperationException{
		//Preconditions
		if (debut<0){
			debut=0;
			//throw new IllegalArgumentException("Le debut de la selection doit etre superieur a 0. ");
		}
		if (longueur<0){
			longueur=0;
			//throw new IllegalArgumentException("La longueur de la selection doit etre superieur a 0. ");
		}
		if (debut>this.buffer.getContenu().length()){
			debut=this.buffer.getContenu().length();
			//throw new IllegalArgumentException("Le debut de la selection doit etre a l'interieur d buffer. ");
		}
		if (debut+longueur>this.buffer.getContenu().length()){
			longueur=0;
			//throw new IllegalArgumentException("La fin de la selection doit etre � l'int�rieur du buffer. ");
		}
		// Mise � jour des attributs
		this.selection.setDebutSelection(debut);
		this.selection.setLongueurSelection(longueur);
	}

	/** 
	 * M�thode saisir : ins�re � partir du d�but de la s�lection le texte pass� en param�tre
	 * @param texte texte � ins�rer dans le buffer
	 */
	@Override
	public void saisir(String texte) throws UnsupportedOperationException{
		int debutSelection= this.selection.getDebutSelection();
		// Insertion du texte saisie dans le buffer
		this.buffer.getContenu().insert(debutSelection, texte);
		//Modification de la s�lection
		this.selection.setDebutSelection(debutSelection+texte.length());
		this.selection.setLongueurSelection(0);
	}
	
	/** 
	* M�thode suppressionAvant : Supprime le caract�re suivant le d�but de la s�lection si la longueur de s�lection est nulle
	* Supprime la s�lection si plusieurs caract�res sont s�lectionn�s
	**/
	@Override
	public void suppressionAvant() throws UnsupportedOperationException{
		// r�cuperation du d�but de la s�lection
		int debutSelection = this.selection.getDebutSelection();
		// r�cuperation de la longueur de la s�lection
		int longueurSelection = this.selection.getLongueurSelection();
		// r�cuperation de la fin de la s�lection
		int finSelection = debutSelection+this.selection.getLongueurSelection();
		// r�cuperation du longueur du buffer
		int longueurBuffer = this.buffer.getContenu().length();
		//Si longueur de la selection = 0
		if(longueurSelection==0){
			// si la s�lection n'est pas a la fin du buffer 
			if(debutSelection<longueurBuffer){
				//suppression du caract�re apr�s la s�lection
				this.buffer.getContenu().delete(debutSelection, finSelection+1);
				//Initialisation de la longueur de s�lection � 0
				this.selection.setLongueurSelection(0);
			}
		}else{
			// si la s�lection n'est pas a la fin du buffer 
			if(debutSelection<longueurBuffer){
				//suppression du caract�re apr�s la s�lection
				this.buffer.getContenu().delete(debutSelection, finSelection);
				//Initialisation de la longueur de s�lection � 0
				this.selection.setLongueurSelection(0);
			}
		}
	}
	
	/***
	* M�thode suppressionArriere : Supprime le caract�re pr�c�dent le d�but de la s�lection si la longueur de s�lection est nulle
	* Supprime la s�lection si plusieurs caract�res sont s�lectionn�s
	 */
	@Override
	public void suppressionArriere() throws UnsupportedOperationException{
		// r�cuperation du d�but de la s�lection
		int debutSelection = this.selection.getDebutSelection();
		// r�cuperation de la fin de la s�lection
		int finSelection = debutSelection+this.selection.getLongueurSelection();
		// r�cuperation de la longueur de la s�lection
		int longueurSelection = this.selection.getLongueurSelection();
		//Test si la longueur de s�lection est > � 0
		if (longueurSelection>0){
			//suppression des caract�res apres la s�lection
			this.buffer.getContenu().delete(debutSelection, finSelection);
			//Initialisation de la longueur de s�lection � 0
			this.selection.setLongueurSelection(0);
		}else{
			// si la s�lection n'est pas a la fin du buffer 
			if(debutSelection>0){
				//suppression du caractere apres la s�lection
				this.buffer.getContenu().deleteCharAt(debutSelection-1);
				//Modification de la s�lection
				this.selection.setDebutSelection(this.selection.getDebutSelection()-1);
			}
		}
	}
	
	/**
	 * envoie une notification � l'observer
	 * @param etat etat de l'observable
	 */
	 public void setEtat(boolean etat){
		this.etat=etat;		
		setChanged();
		notifyObservers(this.etat);		
	 }
	 
	 /**
	  * Ajoute un observer
	  * @param ihm observer � ajouter
	  */
	 public void addObserver(Ihm ihm) {
		this.addObserver((Observer) ihm);
	}
	 
	 /**
	  * Envoi d'une notification � l'IHM (observer)
	  */
	 public void majObserver(){
		this.setChanged();
		this.notifyObservers(this);
	 }
}
