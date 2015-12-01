package commandV3;

import caretaker.*;
import command.Command;

public class Refaire implements Command {

	private EnregistreurV3Impl receiver;
	private MoteurEditionEnregistrable moteur;
	
	public Refaire(EnregistreurV3Impl receiver, MoteurEditionEnregistrable moteur) {
		this.receiver = receiver;
		this.moteur = moteur;
	}

	@Override
	public void execute() {
		receiver.refaire(moteur);
	}

}
