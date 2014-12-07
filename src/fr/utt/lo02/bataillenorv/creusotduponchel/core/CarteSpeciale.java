package fr.utt.lo02.bataillenorv.creusotduponchel.core;
public abstract class CarteSpeciale extends Carte {
	
	public CarteSpeciale(int valeur) {
		super(valeur);
	}
	
	public abstract void effet(Jeu jeu);

}
