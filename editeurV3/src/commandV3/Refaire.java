package commandV3;

import caretaker.*;
import command.Command;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l�ex�cution de l�op�ration Defaire par l'enregistreurV3(receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V3 - 02/12/2015
 */
public class Refaire implements Command {

	private EnregistreurV3Impl receiver;
	private MoteurEditionEnregistrable moteur;
	
	/**
	 * Constructeur 
	 * @param receiver Enregistreur de la commande
	 * @param moteur moteur � d�faire
	 */
	public Refaire(EnregistreurV3Impl receiver, MoteurEditionEnregistrable moteur) {
		this.receiver = receiver;
		this.moteur = moteur;
	}

	/**
	 * Ex�cution de la commande concrete dans le receiver (enregistreur)
	 */
	@Override
	public void execute() {
		receiver.refaire(moteur);
	}

}
