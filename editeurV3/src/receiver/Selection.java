package receiver;

/**
 *S�lection du moteur d'�dition dans le Design Pattern Commande
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class Selection {

	// D�claration des attributs
	private int debutSelection;
	private int longueurSelection;

	/**
	 * Constructeur
	 * @param debutSelection position du d�but de la s�lection
	 * @param longueurSelection longueur de la s�lection
	 */
	public Selection(int debutSelection, int longueurSelection) {
		super();
		this.debutSelection = debutSelection;
		this.longueurSelection = longueurSelection;
	}
	
	/**
	 * retourne la position de d�but de la s�lection
	 * @return debutSelection position de d�but de la s�lection
	 */
	public int getDebutSelection() {
		return debutSelection;
	}

	/**
	 * affecte une valeur au d�but de la s�lection
	 * @param debut valeur affect�e au d�but de la s�lection
	 */
	public void setDebutSelection(int debut) {
		this.debutSelection = debut;
	}
	
	/**
	 * retourne la longueur de la s�lection
	 * @return debutSelection longueur de la s�lection
	 */
	public int getLongueurSelection() {
		return longueurSelection;
	}

	/**
	 * affecte une valeur � la longueur de la s�lection
	 * @param debut valeur affect�e � la longueur de la s�lection
	 */
	public void setLongueurSelection(int longueur) {
		this.longueurSelection = longueur;
	}	
}
