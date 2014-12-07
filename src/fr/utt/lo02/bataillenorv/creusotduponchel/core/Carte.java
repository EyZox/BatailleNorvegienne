package fr.utt.lo02.bataillenorv.creusotduponchel.core;
public class Carte {
	private int valeur;

	public Carte(int valeur) {
		this.valeur = valeur;
	}
	
	public boolean peutEtreJoueeSur(Carte carte){
		if(carte.valeur == 7) {
			return this.valeur<=carte.getValeur();
		}
		return this.valeur>=carte.getValeur();
	}
	
	public int getValeur(){
		return this.valeur;
	}

	@Override
	public String toString() {
		return valeur+"";
	}
	
	
}
