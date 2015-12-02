package commandV3;

import caretaker.EnregistreurV3Impl;
import command.*;
import receiver.*;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l�ex�cution de l�op�ration CouperEnregistrableV3 par le moteur d'�dition(receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V3 - 02/12/2015
 */
public class CouperEnregistrableV3 extends Couper implements CommandEnregistrableV3 {

	private EnregistreurV3Impl enregistreur;
	
	/**
	 * Constructeur 
	 * @param receiver Moteur d'�dition de la commande
	 * @param enregistreur Enregistreur de la commande
	 */
	public CouperEnregistrableV3(MoteurEditionImpl receiver, EnregistreurV3Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}

	/**
	 * Ex�cution de la commande concrete dans les receiver (moteur d'�dition et enregistreur)
	 */
	@Override
	public void execute() {
		//On ex�cute la commande V1
		super.execute();		
		//On supprime le contenu de la pile refaire
		enregistreur.viderPileRefaire();
		//On enregistre le moteur
		MoteurEditionEnregistrable m = (MoteurEditionEnregistrable) this.receiver;
		enregistreur.enregistrer(m);
	}
}
