package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;

/**
 * classe abstraite representant l intelligence artificielle des joueurs non humains
 * @author Alexandre
 *
 */
public abstract class IA extends AbstractStrategie {

	private static int nbIA = 0;
	private int botID;
	
	/**
	 * constructeur
	 */
	public IA() {
		botID = ++nbIA;
	}
	
	/**
	 * @return le nom du joueur non humain
	 */
	public String getNom() {
		return "Bot"+botID;
	}
	

	@Override
	public int choisirCachee() {
		return (int)(Math.random()*joueur.getNbCachees());
	}
}
