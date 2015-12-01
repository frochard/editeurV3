package caretaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import commandV3.MoteurEditionEnregistrable;

public class TestEnregistreurV3 {

	//Instanciation de l'objet à tester
	EnregistreurV3Impl testEnregistreurV3;
	MoteurEditionEnregistrable testmoteur;
	@Before
	public void setUp() throws Exception {
		//Instanciation de l'objet utilisé pour les tests
		testEnregistreurV3 = new EnregistreurV3Impl();
		
	}

	/**
	 * Test si defaire decremente stach defaire et incremente refaire
	 */
	@Test
	public void testEnregistrer() {
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		//méthodes de test
		assertEquals(testEnregistreurV3.getPileDefaire().size(),1);
	}

	/**
	 * Test si defaire decremente stach defaire et incremente refaire
	 */
	@Test
	public void testDefaire() {
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.defaire(testmoteur);
		//méthodes de test
		assertEquals(testEnregistreurV3.getPileDefaire().size(),5);
	}

	/**
	 * Test si refaire decremente stack refaire et incremente defaire
	 */
	@Test
	public void testRefaire() {
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.enregistrer( new MoteurEditionEnregistrable(null, null, null, testEnregistreurV3));
		testEnregistreurV3.defaire(testmoteur);
		testEnregistreurV3.defaire(testmoteur);
		testEnregistreurV3.defaire(testmoteur);
		//méthodes de test
		assertEquals(testEnregistreurV3.getPileRefaire().size(),3);
	}

}
