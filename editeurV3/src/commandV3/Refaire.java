package commandV3;

import caretaker.*;
import command.Command;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l’exécution de l’opération Defaire par l'enregistreurV3(receiver). 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V3 - 02/12/2015
 */
public class Refaire implements Command {

	private EnregistreurV3Impl receiver;
	private MoteurEditionEnregistrable moteur;
	
	/**
	 * Constructeur 
	 * @param receiver Enregistreur de la commande
	 * @param moteur moteur à défaire
	 */
	public Refaire(EnregistreurV3Impl receiver, MoteurEditionEnregistrable moteur) {
		this.receiver = receiver;
		this.moteur = moteur;
	}

	/**
	 * Exécution de la commande concrete dans le receiver (enregistreur)
	 */
	@Override
	public void execute() {
		receiver.refaire(moteur);
	}

}
