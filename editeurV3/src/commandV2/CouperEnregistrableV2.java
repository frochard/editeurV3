package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Couper;
import memento.*;
import receiver.MoteurEditionImpl;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l�ex�cution de l�op�ration CouperEnregistrableV2 par le moteur d'�dition(receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class CouperEnregistrableV2 extends Couper implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	/**
	 * Constructeur 
	 * @param receiver Moteur d'�dition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public CouperEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}
	
	/**
	 * Ex�cution de la commande concrete dans les receiver (moteur d'�dition et enregistreur)
	 */
	@Override
	public void execute() {
		//Ex�cute la commande couper
		super.execute();
		//Ajoute la commande dans la liste ordonn�e de memento du caretaker Enregistreur
		enregistreur.addMemento(this.sauverDansMemento());
	   }

		/**
		* Cette m�thode sauvegarde la commande enregistrable dans un memento et retourne le memento
		* @return m memento contenant la commande sauvegard�e
		*/
		@Override
		public Memento sauverDansMemento() {
			MementoCouper m = new MementoCouper(this);
			return m;
		}

		/**
		 * Cette m�thode restaure la commande enregistrable depuis un memento
		 * @param m memento � restaurer
		 */
		@Override
		public void restaurerDepuisMemento(Memento m) {
			MementoCouper mRestored = (MementoCouper) m;
			super.execute();
		}
}
