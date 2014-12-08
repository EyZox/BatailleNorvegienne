package fr.utt.lo02.bataillenorv.creusotduponchel.core;




public class CarteHuit extends Carte {

	public CarteHuit() {
		super(8);
	}

	@Override
	public void onPlaced(Jeu jeu) {
		super.onPlaced(jeu);
		jeu.getTourJeu().next();
	}
	
	

}
