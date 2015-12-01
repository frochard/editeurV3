package commandV3;

import caretaker.EnregistreurV3Impl;
import command.*;
import receiver.*;

public class CollerEnregistrableV3 extends Coller implements CommandEnregistrableV3 {

	private EnregistreurV3Impl enregistreur;
	
	public CollerEnregistrableV3(MoteurEditionImpl receiver, EnregistreurV3Impl enregistreur) {
		super(receiver);
		this.enregistreur=enregistreur;
	}

	@Override
	public void execute() {
		//On exécute la commande V1
		super.execute();
		//On supprime le contenu de la pile refaire
		enregistreur.viderPileRefaire();
		//On enregistre le moteur
		MoteurEditionEnregistrable m = (MoteurEditionEnregistrable) this.receiver;
		enregistreur.enregistrer(m);
	}
}
