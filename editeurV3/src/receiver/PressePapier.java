package receiver;

/**
 *Presse papier du moteur d'�dition dans le Design Pattern Commande
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class PressePapier {
	private String contenu;

	/**
	 * Constructeur
	 * @param contenu contenu du presse papier
	 */
	public PressePapier(String contenu) {
		this.contenu = contenu;
	}
	
	/**
	 * retourne le contenu du presse papier
	 * @return contenu contenu du presse papier
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * affecte une valeur au contenu du presse papier
	 * @param contenu valeur affect� au contenu du presse papier
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}