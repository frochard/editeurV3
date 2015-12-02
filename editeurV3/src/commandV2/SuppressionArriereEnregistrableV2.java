package commandV2;

import caretaker.EnregistreurV2Impl;
import command.SuppressionArriere;
import memento.Memento;
import receiver.MoteurEditionImpl;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l�ex�cution de l�op�ration SuppressionArriereEnregistrableV2 par le moteur d'�dition(receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class SuppressionArriereEnregistrableV2 extends SuppressionArriere implements CommandEnregistrableV2{

	private EnregistreurV2Impl enregistreur;
	
	/**
	 * Constructeur 
	 * @param receiver Moteur d'�dition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public SuppressionArriereEnregistrableV2(MoteurEditionImpl receiver,EnregistreurV2Impl enregistreur) {
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
		
   }

	/**
	* Cette m�thode sauvegarde la commande enregistrable dans un memento et retourne le memento
	* @return m memento contenant la commande sauvegard�e
	*/
	@Override
	public Memento sauverDansMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Cette m�thode restaure la commande enregistrable depuis un memento
	 * @param memento memento � restaurer
	 */
	@Override
	public void restaurerDepuisMemento(Memento memento) {
		// TODO Auto-generated method stub
		
	}

}
