package commandV3;

import caretaker.EnregistreurV3Impl;
import command.Command;

public class Defaire implements Command {

	private EnregistreurV3Impl receiver;
	private MoteurEditionEnregistrable moteur;
	

	public Defaire(EnregistreurV3Impl receiver, MoteurEditionEnregistrable moteur) {
		this.receiver = receiver;
		this.moteur = moteur;
	}
	@Override
	public void execute() {
		receiver.defaire(moteur);
	}

}
