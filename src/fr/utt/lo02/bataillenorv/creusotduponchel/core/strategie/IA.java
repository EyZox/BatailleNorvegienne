package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;

public abstract class IA extends AbstractStrategie {

	private static int nbIA = 0;
	private int botID;
	
	
	public IA() {
		botID = ++nbIA;
	}
	
	
	public String getNom() {
		return "Bot"+botID;
	}
	

	@Override
	public int choisirCachee() {
		return (int)(Math.random()*joueur.getNbCachees());
	}
}
