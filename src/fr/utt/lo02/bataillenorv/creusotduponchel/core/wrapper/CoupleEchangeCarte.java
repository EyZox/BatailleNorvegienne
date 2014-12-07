package fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
/**
 * Permet de définir un couple de 2 cartes a échanger
 * @author Alexandre
 *
 */
public class CoupleEchangeCarte {
	private Carte main;
	private Carte visible;
	
	public CoupleEchangeCarte(Carte main, Carte visible) {
		this.main = main;
		this.visible = visible;
	}

	/**
	 * Retourne la carte de la main a échanger
	 * @return
	 */
	public Carte getMain() {
		return main;
	}

	/**
	 * Definis la carte de la main a echanger
	 * @param main
	 */
	public void setMain(Carte main) {
		this.main = main;
	}

	/**
	 * Retourne la carte visible a echanger
	 * @return
	 */
	public Carte getVisible() {
		return visible;
	}

	/**
	 * Definis la carte visible a echanger
	 * @param visible
	 */
	public void setVisible(Carte visible) {
		this.visible = visible;
	}
	
	
}
