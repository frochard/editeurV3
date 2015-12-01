/***********************************************************************
 * Module:  Selectionner.java
 * Author:  21000155
 * Purpose: Defines the Class Selectionner
 ***********************************************************************/
package command;

import invoker.*;
import receiver.*;

/**
 *Commande concrete dans le Design Pattern Commande. Elle Provoque l�ex�cution de l�op�ration Selectionner par le moteur d��dition (receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class Selectionner implements Command {
	
	protected MoteurEditionImpl receiver ;
	protected Ihm	invocator;
	
	/**
	 * retourne le moteur d'�dition de la commande Selectionner
	 * @return receiver moteur d'�dition de la commande Selectionner
	 */
	public MoteurEditionImpl getReceiver() {
		return receiver;
	}

	/**
	 * Constructeur de la classe Selectionner
	 * @param receiver moteur d'�dition de la commande Selectionner
	 */
	public Selectionner(MoteurEditionImpl receiver, Ihm	invocator) {
		this.receiver = receiver;
		this.invocator = invocator;
	}

	/**
	 * Ex�cution de la commande : Appel de l'op�ration correspondante dans le receiver.
	 */
	@Override
	public void execute() {
		//Appel de la commande s�lectionner
		int debut=invocator.getSelectionDebut();
		int longueur=invocator.getSelectionLongueur();
		receiver.selectionner(debut, longueur);
   }

}