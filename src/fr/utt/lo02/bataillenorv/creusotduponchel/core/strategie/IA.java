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
	/**
	 * Choisit une carte parmi les 3 cachées, cette methode est la meme pour toutes les strategies puisque de toutes facons, on n'a pas acces a la velurs de ces cartes
	 * return l indice de la carte cachee a prendre en main (toujours entre 0 et 2 inclus)
	 */
	public int choisirCachee() {
		return (int)(Math.random()*joueur.getNbCachees());
	}
}
