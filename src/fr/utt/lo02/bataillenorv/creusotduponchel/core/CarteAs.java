package fr.utt.lo02.bataillenorv.creusotduponchel.core;



public class CarteAs extends Carte {

	public CarteAs() {
		super(1);
	}

	@Override
	public void onPlaced(Jeu jeu, int nb) {
		super.onPlaced(jeu, nb);
		jeu.getJoueurCourant().selectionerJoueur().ramasserTas(jeu.getTas());
	}
	
	

}
