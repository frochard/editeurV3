package commandV3;

import caretaker.EnregistreurV3Impl;
import command.*;
import invoker.Ihm;
import receiver.*;

public class SaisirEnregistrableV3 extends Saisir implements CommandEnregistrableV3 {

	private EnregistreurV3Impl enregistreur;
	
	public SaisirEnregistrableV3(MoteurEditionImpl receiver, Ihm invocator,EnregistreurV3Impl enregistreur) {
		super(receiver,invocator);
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
