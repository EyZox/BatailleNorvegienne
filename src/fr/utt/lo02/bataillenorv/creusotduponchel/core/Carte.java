package fr.utt.lo02.bataillenorv.creusotduponchel.core;
public class Carte {
	private int valeur;

	public Carte(int valeur) {
		this.valeur = valeur;
	}
	
	public boolean peutEtreJoueeSur(Carte carte){
		if(this.valeur==2)
			return true;
		else return this.valeur>=carte.getValeur();
	}
	
	public int getValeur(){
		return this.valeur;
	}
}
