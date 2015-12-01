package command;

import receiver.MoteurEdition;
import receiver.MoteurEditionImpl;

/**
 *Commande concrete dans le Design Pattern Commande. Elle Provoque l�ex�cution de l�op�ration SuppressionArriere par le moteur d��dition (receiver). 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class SuppressionArriere implements Command{

	private MoteurEdition receiver ;
	
	/**
	 * Constructeur de la classe SuppressionArriere
	 * @param receiver moteur d'�dition de la commande SuppressionArriere
	 */
	public SuppressionArriere(MoteurEditionImpl receiver) {
		this.receiver = receiver;
	}

	/**
	 * Ex�cution de la commande : Appel de l'op�ration correspondante dans le receiver.
	 */
	@Override
	public void execute() {
		receiver.suppressionArriere();
   }
}
