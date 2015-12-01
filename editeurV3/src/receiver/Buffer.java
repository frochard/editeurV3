package receiver;
/***********************************************************************
 * Module:  Buffer.java
 * @author:  Sanaa Mairouche / Frederic Rochard
 * @version: v1
 * Purpose: Defines the Class Buffer
 ***********************************************************************/

/**
 *Buffer du moteur d'�dition dans le Design Pattern Command
 *@author Sanaa Mairouch / Fr�d�ric Rochard
 *@version V1 - 30/11/2015
 */
public class Buffer {

	private StringBuffer contenu;

	/** 
	 * Constructeur
	 * @param contenu : StringBuffer � affecter au Buffer
	 * */
	public Buffer(StringBuffer contenu) {
		this.contenu = contenu;
	}
	
	/** 
	 * Getter
	 * @return contenu : retourne le StringBuffer contenu du Buffer
	 * */
	public StringBuffer getContenu() {
		return contenu;
	}

	/** 
	 * Setter
	 * @param contenu : StringBuffer contenu � affecter au Buffer
	 * */
	public void setContenu(StringBuffer contenu) {
		this.contenu = contenu;
	}
}

