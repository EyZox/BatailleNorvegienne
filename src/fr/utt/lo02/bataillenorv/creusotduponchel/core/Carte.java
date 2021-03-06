package fr.utt.lo02.bataillenorv.creusotduponchel.core;

/**
 * Classe repr�sentant une carte
 * @author Alexandre
 *
 */
public class Carte implements Comparable<Carte>{
	private int valeur;

	public Carte(int valeur) {
		this.valeur = valeur;
	}
	/**
	 * Retourne true si la carte pass� en parametre peut �tre pos� par dessus la carte
	 * @param carte la carte a placer au dessus
	 * @return true si possible, false si impossible
	 */
	public boolean accept(Carte carte) {
		return carte.bypass() || this.valeur<=carte.getValeur();
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
	
	/**
	 * Retourne faux dans cette classe. Methode surcharg�e dans la classe CarteDeux
	 * @return faux 
	 */
	protected boolean bypass() {
		return false;
	}
	
	public void onPlaced(Jeu jeu, int nb) {}
	
	@Override
	public int compareTo(Carte o) {
		if(this.equals(o)) return 0;
		if(this instanceof CarteAs) return 1;
		
		if(this instanceof CarteDeux) {
			if(o instanceof CarteAs) return -1;
			else return 1;
		}
		
		if(o instanceof CarteAs || o instanceof CarteDeux) return -1; 
		return valeur-o.valeur;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Carte) {
			return this.valeur == ((Carte)obj).valeur;
		}else {
			return false;
		}
	}
	
	
	
}
