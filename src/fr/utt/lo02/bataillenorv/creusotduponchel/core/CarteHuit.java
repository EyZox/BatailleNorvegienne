package fr.utt.lo02.bataillenorv.creusotduponchel.core;




public class CarteHuit extends Carte {

	public CarteHuit() {
		super(8);
	}

	@Override
	public void onPlaced(Jeu jeu, int nb) {
		super.onPlaced(jeu, nb);
		for(int i = 0; i <nb; i++) {
			
			System.out.println(jeu.getTourJeu().next().getNom()+" passe son tour");
		}
	}
	
	

}
