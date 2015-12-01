package command;


/**
 *Interface Commande dans le Design Pattern Command. Cette interface est commune aux commandes concr�tes. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public interface Command {
   
	/**
	 * Ex�cution de la commande
	 */
	void execute();
}