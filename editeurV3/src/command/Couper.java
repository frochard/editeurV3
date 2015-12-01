/***********************************************************************
 * Module:  Couper.java
 * Author:  21000155
 * Purpose: Defines the Class Couper
 ***********************************************************************/
package command;

import receiver.*;

/**
 *Commande concrete dans le Design Pattern Commande. Elle Provoque l�ex�cution de l�op�ration Couper par le moteur d��dition (receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class Couper implements Command {
	
	protected MoteurEditionImpl receiver ;

	/**
	 * retourne le moteur d'�dition de la commande Couper
	 * @return receiver moteur d'�dition de la commande Couper
	 */
	public MoteurEditionImpl getReceiver() {
		return receiver;
	}

	/**
	 * Constructeur de la classe Couper
	 * @param receiver moteur d'�dition de la commande Couper
	 */
	public Couper(MoteurEditionImpl receiver) {
		this.receiver = receiver;
	}

	/**
	 * Ex�cution de la commande : Appel de l'op�ration correspondante dans le receiver.
	 */
	@Override
	public void execute() {
		receiver.couper();
   }
	
}