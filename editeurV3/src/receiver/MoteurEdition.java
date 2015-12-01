package receiver;

/**
 *Receiver dans le Design Pattern Command
 *Cette interface r�alise l�action sur demande de la commande concr�te avec une op�ration associ�e. 
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public interface MoteurEdition {

	/**
	 * Op�ration correspondant � la commande concr�te couper
	 */
	void couper();
	
	/**
	 * Op�ration correspondant � la commande concr�te copier
	 */
	void copier();
	
	/**
	 * Op�ration correspondant � la commande concr�te coller
	 */
	void coller();

	/**
	 * Op�ration correspondant � la commande concr�te s�lectionner
	*  @param debut d�but de la s�lection
    * @param longueur longueur de la s�lection
    */
   void selectionner(int debut, int longueur);

   /** 
	 * Op�ration correspondant � la commande concr�te Saisir
	 *     * @param texte texte � saisir dans le buffer
    */
   void saisir(String texte);
   
   /** 
	 * Op�ration correspondant � la commande concr�te suppressionAvant
    */
   void suppressionAvant();
   
   /** 
	 * Op�ration correspondant � la commande concr�te suppressionArriere
    */
   void suppressionArriere();
   
}