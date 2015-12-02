/***********************************************************************
 * Module:  Editeur.java
 * Author:  21000155
 * Purpose: Defines the Class Editeur
 ***********************************************************************/
package client;

import caretaker.*;
import command.*;
import commandV2.*;
import commandV3.*;
import invoker.*;
import receiver.*;

/**
 *Client dans le Design Pattern Commande
 *L’éditeur configure l’invoker (Ihm) en créant et configurant les commandes concrètes. 
 *@author Sanaa Mairouch / Frédéric Rochard
 *@version V3 - 30/11/2015
 */
public class Editeur{
	
	private Ihm ihm;
	private MoteurEditionEnregistrable moteurEditionEnregistrable;
	//Enregistreurs
	private EnregistreurV2Impl enregistreurV2;
	private EnregistreurV3Impl enregistreurV3;
	//Déclaration des commandes
	private Coller cmdColler;
	private Copier cmdCopier;
	private Couper cmdCouper;
	private Saisir cmdSaisir;
	private Selectionner cmdSelectionner;
	private SuppressionArriere cmdSuppressionArriere;
	private SuppressionAvant cmdSuppressionAvant;
	private CollerEnregistrableV2 cmdCollerEnregistrableV2;
	private CopierEnregistrableV2 cmdCopierEnregistrableV2;
	private CouperEnregistrableV2 cmdCouperEnregistrableV2;
	private SaisirEnregistrableV2 cmdSaisirEnregistrableV2;
	private SelectionnerEnregistrableV2 cmdSelectionnerEnregistrableV2;
	private CollerEnregistrableV3 cmdCollerEnregistrableV3;
	private CouperEnregistrableV3 cmdCouperEnregistrableV3;
	private SaisirEnregistrableV3 cmdSaisirEnregistrableV3;
	private Demarrer cmdDemarrer;
	private Arreter cmdArreter;
	private Rejouer cmdRejouer;
	private Defaire cmdDefaire;
	private Refaire cmdRefaire;

	/**
	 * retourne l'IHM de l'éditeur
	 * @return ihm ihm de l'éditeur 
	 */
	public Ihm getIhm() {
		return ihm;
	}

	/**
	 * retourne le moteur d'édition de l'éditeur
	 * @return moteurEdition moteur d'édition de l'éditeur
	 */
	public MoteurEditionEnregistrable getMoteurEditionEnregistrable() {
		return moteurEditionEnregistrable;
	}

	/**
	 * retourne l'enregistreur de la V2 de l'éditeur
	 * @return enregistreurV2 enregistreur de la V2 de l'éditeur
	 */
	public EnregistreurV2Impl getEnregistreurV2() {
		return enregistreurV2;
	}

	/**
	 * retourne l'enregistreur de la V3 de l'éditeur
	 * @return enregistreurV3 enregistreur de la V3 de l'éditeur
	 */
	public EnregistreurV3Impl getEnregistreurV3() {
		return enregistreurV3;
	}

	/**
	 * Constructeur d'Editeur
	 */
	public Editeur() {
		//Création de l'enregistreur de commandes de la V2
		this.enregistreurV2=new EnregistreurV2Impl();
		//Création de l'enregistreur de commandes de la V3
		this.enregistreurV3=new EnregistreurV3Impl();
		//Création de l'IHM
		this.ihm = new Ihm();
		this.moteurEditionEnregistrable=new MoteurEditionEnregistrable(new Buffer(new StringBuffer("")),new PressePapier(""),new Selection(0,0),enregistreurV3);
		//Ajout des commandes
		cmdColler=new Coller(moteurEditionEnregistrable);
		cmdCopier=new Copier(moteurEditionEnregistrable);
		cmdCouper=new Couper(moteurEditionEnregistrable);
		cmdSaisir=new Saisir(moteurEditionEnregistrable,ihm);
		cmdSelectionner=new Selectionner(moteurEditionEnregistrable,ihm);
		cmdSuppressionArriere=new SuppressionArriere(moteurEditionEnregistrable);
		cmdSuppressionAvant=new SuppressionAvant(moteurEditionEnregistrable);
		cmdCollerEnregistrableV2=new CollerEnregistrableV2(moteurEditionEnregistrable,enregistreurV2);
		cmdCopierEnregistrableV2=new CopierEnregistrableV2(moteurEditionEnregistrable,enregistreurV2);
		cmdCouperEnregistrableV2=new CouperEnregistrableV2(moteurEditionEnregistrable,enregistreurV2);
		cmdSaisirEnregistrableV2=new SaisirEnregistrableV2(moteurEditionEnregistrable,ihm,enregistreurV2);
		cmdSelectionnerEnregistrableV2=new SelectionnerEnregistrableV2(moteurEditionEnregistrable,ihm,enregistreurV2);
		cmdCollerEnregistrableV3=new CollerEnregistrableV3(moteurEditionEnregistrable,enregistreurV3);
		cmdCouperEnregistrableV3=new CouperEnregistrableV3(moteurEditionEnregistrable,enregistreurV3);
		cmdSaisirEnregistrableV3=new SaisirEnregistrableV3(moteurEditionEnregistrable,ihm,enregistreurV3);
		cmdDemarrer = new Demarrer(enregistreurV2);
		cmdArreter = new Arreter(enregistreurV2);
		cmdRejouer = new Rejouer(enregistreurV2);
		cmdDefaire = new Defaire(enregistreurV3,moteurEditionEnregistrable);
		cmdRefaire = new Refaire(enregistreurV3,moteurEditionEnregistrable);
		//Ajout des commandes à l'ihm
		this.ihm.setCmdColler(cmdColler);
		this.ihm.setCmdCopier(cmdCopier);
		this.ihm.setCmdCouper(cmdCouper);
		this.ihm.setCmdSaisir(cmdSaisir);
		this.ihm.setCmdSelectionner(cmdSelectionner);
		this.ihm.setCmdSuppressionArriere(cmdSuppressionArriere);
		this.ihm.setCmdSuppressionAvant(cmdSuppressionAvant);
		this.ihm.setCmdCollerEnregistrableV2(cmdCollerEnregistrableV2);
		this.ihm.setCmdCopierEnregistrableV2(cmdCopierEnregistrableV2);
		this.ihm.setCmdCouperEnregistrableV2(cmdCouperEnregistrableV2);
		this.ihm.setCmdSaisirEnregistrableV2(cmdSaisirEnregistrableV2);
		this.ihm.setCmdSelectionnerEnregistrableV2(cmdSelectionnerEnregistrableV2);
		this.ihm.setCmdCollerEnregistrableV3(cmdCollerEnregistrableV3);
		this.ihm.setCmdCouperEnregistrableV3(cmdCouperEnregistrableV3);
		this.ihm.setCmdSaisirEnregistrableV3(cmdSaisirEnregistrableV3);
		this.ihm.setCmdDemarrer(cmdDemarrer);
		this.ihm.setCmdArreter(cmdArreter);
		this.ihm.setCmdRejouer(cmdRejouer);
		this.ihm.setCmdDefaire(cmdDefaire);
		this.ihm.setCmdRefaire(cmdRefaire);
		//Ajout d'un observer
		this.moteurEditionEnregistrable.addObserver(this.ihm);
	}
	
	public static void main(String [] arg){
		new Editeur();
	}
}