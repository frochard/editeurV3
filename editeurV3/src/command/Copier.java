/***********************************************************************
 * Module:  Copier.java
 * Author:  21000155
 * Purpose: Defines the Class Copier
 ***********************************************************************/
package command;

import receiver.*;

/**
 *Commande concrete dans le Design Pattern Commande. Elle Provoque l�ex�cution de l�op�ration Copier par le moteur d��dition (receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class Copier implements Command {
	
	private MoteurEditionImpl receiver ;
	
	/**
	 * retourne le moteur d'�dition de la commande Copier
	 * @return receiver moteur d'�dition de la commande Copier
	 */
	public MoteurEditionImpl getReceiver() {
		return receiver;
	}

	/**
	 * Constructeur de la classe copier
	 * @param receiver moteur d'�dition de la commande Copier
	 */
	public Copier(MoteurEditionImpl receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.copier();
   }

}