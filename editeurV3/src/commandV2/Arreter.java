package commandV2;

import caretaker.EnregistreurV2Impl;
import command.Command;

/**
 *Commande concrete dans le Design Pattern Command. Elle Provoque l�ex�cution de l�op�ration Arreter par l'enregistreurV2 (receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V2 - 30/11/2015
 */
public class Arreter implements Command {

	private EnregistreurV2Impl receiver;

	/**
	 * Constructeur 
	 * @param receiver Enregistreur de la commande
	 */
	public Arreter(EnregistreurV2Impl receiver) {
		this.receiver = receiver;
	}

	/**
	 * Ex�cution de la commande concrete dans le receiver enregistreur
	 */
	@Override
	public void execute() {
		receiver.arreter();
   }
}
