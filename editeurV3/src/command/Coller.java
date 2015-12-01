/***********************************************************************
 * Module:  Coller.java
 * Author:  21000155
 * Purpose: Defines the Class Coller
 ***********************************************************************/
package command;

import receiver.*;


/**
 *Commande concrete dans le Design Pattern Commande. Elle Provoque l�ex�cution de l�op�ration Coller par le moteur d��dition (receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class Coller implements Command {

	protected MoteurEditionImpl receiver ;

	/**
	 * retourne le moteur d'�dition de la commande Coller
	 * @return receiver moteur d'�dition de la commande Coller
	 */
	public MoteurEditionImpl getReceiver() {
		return receiver;
	}

	/**
	 * Constructeur de la classe Coller
	 * @param receiver moteur d'�dition de la commande Coller
	 */
	public Coller(MoteurEditionImpl receiver) {
		this.receiver = receiver;
	}

	/**
	 * Ex�cution de la commande : Appel de l'op�ration correspondante dans le receiver.
	 */
	@Override
	public void execute() {
		receiver.coller();
	}
}