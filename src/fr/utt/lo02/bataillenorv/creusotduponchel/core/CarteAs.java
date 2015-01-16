package fr.utt.lo02.bataillenorv.creusotduponchel.core;
/**
 * Classe représentant la carte 1
 * @author Alexandre
 *
 */
public class CarteAs extends Carte {

	public CarteAs() {
		super(1);
	}

	@Override
	public void onPlaced(Jeu jeu, int nb) {
		super.onPlaced(jeu, nb);
		jeu.getTourJeu().setJoueurCourant(jeu.getTourJeu().getJoueurCourant().selectionerJoueur());
		jeu.processCarteJouees(jeu.getTourJeu().getJoueurCourant(),jeu.getTourJeu().getJoueurCourant().poserCartes(this));
	}

	@Override
	public boolean accept(Carte carte) {
		return carte instanceof CarteAs || carte instanceof CarteDeux;
	}

	@Override
	protected boolean bypass() {
		return true;
	}
	
	
	
	

}
