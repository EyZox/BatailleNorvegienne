package fr.utt.lo02.bataillenorv.creusotduponchel.swing.strategie.impl;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;

public class ControllerStrategie {
	
	private Integer input;
	private Joueur joueur;
	private boolean waitInputAnswer, waitJoueur;
	
	public int getInput() {
		input = null;
		waitInputAnswer = true;
		while(input==null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
	
	public void setInput(int i) {
		if(waitInputAnswer) input = i;
		waitInputAnswer = false;
	}
	
	public void setInput(Joueur joueur) {
		if(waitJoueur) this.joueur = joueur;
		waitJoueur = false;
	}
	
	public Joueur getJoueur() {
		joueur = null;
		waitJoueur = true;
		while(joueur==null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return joueur;
	}
}
