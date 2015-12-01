package client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caretaker.*;
import command.*;
import commandV2.*;
import commandV3.*;
import invoker.*;
import receiver.*;

public class TestEditeur {

	private Editeur testEditeur;
	
	@Before
	public void setUp() throws Exception {
		//Instanciation de l'objet utilisé pour les tests
		testEditeur = new Editeur();
	}


	
	/**
	 * Test de l'enregistreur pour la commande défaire
	 */
	@Test
	public void testDefaire() {
		//Initialisation du buffer
		String str = "";
		StringBuffer strbuf = new StringBuffer(str);
		testEditeur.getMoteurEditionEnregistrable().getBuffer().setContenu(strbuf);
		Command cmdToExecute;
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(0);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(0);
		cmdToExecute= new Selectionner(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setText("Ceci est un test.");
		testEditeur.getIhm().setText("Ceci est un test.");
		cmdToExecute = new SaisirEnregistrableV3(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm(),testEditeur.getEnregistreurV3());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(0);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(4);
		cmdToExecute= new Selectionner(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Appel de la commande couper enregistrable
		cmdToExecute = new CouperEnregistrableV3(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getEnregistreurV3());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(13);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(0);
		cmdToExecute = new Selectionner(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm());
		cmdToExecute.execute();
		cmdToExecute = new CollerEnregistrableV3(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getEnregistreurV3());
		cmdToExecute.execute();
		//Defaire l'enregistrement
		testEditeur.getEnregistreurV3().defaire(testEditeur.getMoteurEditionEnregistrable());
		//méthodes de test
		assertEquals(" est un test.", testEditeur.getMoteurEditionEnregistrable().getBuffer().getContenu().toString());
	}

	
	
	/**
	 * Test de l'enregistreur pour la commande défaire
	 */
	@Test
	public void testRefaire() {
		//Initialisation du buffer
		String str = "";
		StringBuffer strbuf = new StringBuffer(str);
		testEditeur.getMoteurEditionEnregistrable().getBuffer().setContenu(strbuf);
		Command cmdToExecute;
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(0);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(0);
		cmdToExecute= new Selectionner(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setText("Ceci est un test.");
		testEditeur.getIhm().setText("Ceci est un test.");
		cmdToExecute = new SaisirEnregistrableV3(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm(),testEditeur.getEnregistreurV3());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(0);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(4);
		cmdToExecute= new Selectionner(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm());
		cmdToExecute.execute();
		//Appel de la commande couper enregistrable
		cmdToExecute = new CouperEnregistrableV3(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getEnregistreurV3());
		cmdToExecute.execute();
		//Positionnement du curseur dans la zone de texte
		testEditeur.getIhm().getZoneTxt().setSelectionStart(13);
		testEditeur.getIhm().getZoneTxt().setSelectionEnd(0);
		cmdToExecute = new Selectionner(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getIhm());
		cmdToExecute.execute();
		cmdToExecute = new CollerEnregistrableV3(testEditeur.getMoteurEditionEnregistrable(),testEditeur.getEnregistreurV3());
		cmdToExecute.execute();
		//Defaire l'enregistrement
		testEditeur.getEnregistreurV3().defaire(testEditeur.getMoteurEditionEnregistrable());
		//Refaire l'enregistrement
		testEditeur.getEnregistreurV3().refaire(testEditeur.getMoteurEditionEnregistrable());
		//méthodes de test
		assertEquals(" est un test.Ceci", testEditeur.getMoteurEditionEnregistrable().getBuffer().getContenu().toString());
	}

}