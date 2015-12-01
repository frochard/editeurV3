
package receiver;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class TestMoteurEditionImpl {

	private MoteurEditionImpl  testMoteur;

	@Before
	public void setUp() throws Exception {

		//Instanciation de l'objet utilis� pour les tests
		testMoteur = new MoteurEditionImpl(new Buffer(new StringBuffer()), new PressePapier(""), new Selection(0,0)) ;
	}

	/**
	 * Test sur le contenu du buffer apr�s Couper
	 * */
	@Test
	public void testCouper1() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0,4);
		testMoteur.couper();
		//m�thodes de test
		assertEquals(" est un test.",testMoteur.getBuffer().getContenu().toString());
	}
	
	/**
	 * Test sur le contenu du presse papier apr�s Couper
	 * */
	@Test
	public void testCouper2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0,4);
		testMoteur.couper();
		//m�thodes de test
		assertEquals("Ceci",testMoteur.getPressePapier().getContenu().toString());
	}

	/**
	 * Test sur la position du curseur apr�s couper
	 * */
	@Test
	public void testCouper3() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0,4);
		testMoteur.couper();
		//m�thodes de test
		assertEquals(0,testMoteur.getSelection().getLongueurSelection());
	}

	/**
	 * Test sur le contenu du buffer apr�s Copier
	 * */
	@Test
	public void testCopier() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0,4);
		testMoteur.copier();
		//m�thodes de test
		assertEquals("Ceci est un test.",testMoteur.getBuffer().getContenu().toString());
	}

	/**
	 * Test sur le contenu du presse papier apr�s Copier
	 * */
	@Test
	public void testCopier2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0,4);
		testMoteur.copier();
		//m�thodes de test
		assertEquals("Ceci",testMoteur.getPressePapier().getContenu().toString());
	}

	/**
	 * Test sur le contenu du buffer apr�s Coller
	 * */
	@Test
	public void testColler() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Initialisation du presse papier
		testMoteur.getPressePapier().setContenu("super ");
		//Test de la m�thode
		testMoteur.selectionner(12, 0);
		testMoteur.coller();
		//m�thodes de test
		assertEquals("Ceci est un super test.",testMoteur.getBuffer().getContenu().toString());
	}

	/**
	 * Test sur la position du curseur apr�s Coller
	 * */
	@Test
	public void testColler2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Initialisation du presse papier
		testMoteur.getPressePapier().setContenu("super ");
		//Test de la m�thode
		testMoteur.selectionner(12, 0);
		testMoteur.coller();
		//m�thodes de test
		assertEquals(18,testMoteur.getSelection().getDebutSelection());
	}

	/**
	 * Test Coller si presse papier vide
	 * */
	@Test
	public void testColler3() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Initialisation du presse papier
		testMoteur.getPressePapier().setContenu("");
		//Test de la m�thode
		testMoteur.selectionner(12, 0);
		testMoteur.coller();
		//m�thodes de test
		assertEquals("Ceci est un test.",testMoteur.getBuffer().getContenu().toString());
	}

	/**
	 * Test sur le d�but de la selection apr�s Selectionner
	 * */
	@Test
	public void testSelectionner() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la methode
		testMoteur.selectionner(1, 2);
		//m�thodes de test
		assertEquals(testMoteur.getSelection().getDebutSelection(),1);
	}

	/**
	 * Test sur la longueur de la selection apr�s Selectionner
	 * */
	@Test
	public void testSelectionner2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(1, 2);
		//m�thodes de test
		assertEquals(testMoteur.getSelection().getLongueurSelection(),2);
	}


	/**
	 * Test sur le contenu du buffer apr�s Saisir
	 * */
	@Test
	public void testSaisir() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0, 0);
		testMoteur.saisir("test : ");
		//m�thodes de test
		assertEquals("test : Ceci est un test.",testMoteur.getBuffer().getContenu().toString());
	}

	/**
	 * Test sur le d�but de la selection apr�s Saisir
	 * */
	@Test
	public void testSaisir2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(0, 0);
		testMoteur.saisir("test : ");
		//m�thodes de test
		assertEquals(7,testMoteur.getSelection().getDebutSelection());
	}

	/**
	 * Test sur le contenu du buffer apres supression avant
	 * */
	@Test
	public void testSuppressionAvant1() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,1);
		testMoteur.suppressionAvant();
		//m�thodes de test
		assertEquals("Cei est un test.",testMoteur.getBuffer().getContenu().toString());
	}
	
	/**
	 * Test sur le contenu du buffer apres supression avant
	 * */
	@Test
	public void testSuppressionAvant2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,0);
		testMoteur.suppressionAvant();
		//m�thodes de test
		assertEquals("Cei est un test.",testMoteur.getBuffer().getContenu().toString());
	}
	
	/**
	 * Test sur le debut selection
	 * */
	@Test
	public void testSuppressionAvant3() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,0);
		testMoteur.suppressionAvant();
		//m�thodes de test
		assertEquals(2,testMoteur.getSelection().getDebutSelection());
	}
	
	/**
	 * Test sur le debut selection
	 * */
	@Test
	public void testSuppressionAvant4() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,3);
		testMoteur.suppressionAvant();
		//m�thodes de test
		assertEquals(2,testMoteur.getSelection().getDebutSelection());
	}
	
	/**
	 * Test sur la longueur de la selection
	 * */
	@Test
	public void testSuppressionAvant5() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(6,3);
		testMoteur.suppressionAvant();
		//m�thodes de test
		assertEquals(0,testMoteur.getSelection().getLongueurSelection());
	}
	
	/**
	 * Test sur la longueur de la selection
	 * */
	@Test
	public void testSuppressionAvant6() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(6,0);
		testMoteur.suppressionAvant();
		//m�thodes de test
		assertEquals(0,testMoteur.getSelection().getLongueurSelection());
	}
	
	/**
	 * Test sur le contenu du buffer apres supression arriere
	 * */
	@Test
	public void testSuppressionArriere1() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,1);
		testMoteur.suppressionArriere();
		//m�thodes de test
		assertEquals("Cei est un test.",testMoteur.getBuffer().getContenu().toString());
	}
	
	/**
	 * Test sur le contenu du buffer apres supression arriere
	 * */
	@Test
	public void testSuppressionArriere2() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,0);
		testMoteur.suppressionArriere();
		//m�thodes de test
		assertEquals("Cci est un test.",testMoteur.getBuffer().getContenu().toString());
	}
	
	/**
	 * Test sur le debut selection
	 * */
	@Test
	public void testSuppressionArriere3() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,0);
		testMoteur.suppressionArriere();
		//m�thodes de test
		assertEquals(1,testMoteur.getSelection().getDebutSelection());
	}
	
	/**
	 * Test sur le debut selection
	 * */
	@Test
	public void testSuppressionArriere4() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(2,3);
		testMoteur.suppressionArriere();
		//m�thodes de test
		assertEquals(2,testMoteur.getSelection().getDebutSelection());
	}
	
	/**
	 * Test sur la longueur de la selection
	 * */
	@Test
	public void testSuppressionArriere5() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(6,3);
		testMoteur.suppressionArriere();
		//m�thodes de test
		assertEquals(0,testMoteur.getSelection().getLongueurSelection());
	}
	
	/**
	 * Test sur la longueur de la selection
	 * */
	@Test
	public void testSuppressionArriere6() {
		//Initialisation du buffer
		String str = "Ceci est un test.";
		StringBuffer strbuf = new StringBuffer(str);
		testMoteur.getBuffer().setContenu(strbuf);
		//Test de la m�thode
		testMoteur.selectionner(6,0);
		testMoteur.suppressionArriere();
		//m�thodes de test
		assertEquals(0,testMoteur.getSelection().getLongueurSelection());
	}
	

}



