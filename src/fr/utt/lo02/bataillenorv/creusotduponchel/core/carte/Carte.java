package fr.utt.lo02.bataillenorv.creusotduponchel.core.carte;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;

public class Carte {
	private int valeur;

	public Carte(int valeur) {
		this.valeur = valeur;
	}
	/**
	 * Retourne true si la carte passé en parametre peut être posé par dessus la carte
	 * @param carte la carte a placer au dessus
	 * @return true si possible, false si impossible
	 */
	public boolean accept(Carte carte) {
		return carte.bypass() || this.valeur>=carte.getValeur();
	}
	
	/**
	 * Retourne la valeur de la carte
	 * @return valeur de la carte
	 */
	public int getValeur(){
		return this.valeur;
	}

	@Override
	public String toString() {
		return valeur+"";
	}
	
	protected boolean bypass() {
		return false;
	}
	
	public void onPlaced(Jeu jeu) {}
	
	
}
