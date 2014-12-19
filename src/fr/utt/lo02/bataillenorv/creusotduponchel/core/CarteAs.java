package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Collection;



public class CarteAs extends Carte {

	public CarteAs() {
		super(1);
	}

	@Override
	public void onPlaced(Jeu jeu, int nb) {
		super.onPlaced(jeu, nb);
		Collection<Carte> cartes = jeu.getJoueurCourant().selectionerJoueur().poserCartes(this);
		if(cartes == null) jeu.getJoueurCourant().ramasserTas(jeu.getTas());
		else {
			jeu.getTas().addAll(cartes);
			Carte c = cartes.iterator().next();
			c.onPlaced(jeu, nb);
		}
	}

	@Override
	public boolean accept(Carte carte) {
		return carte instanceof CarteAs || carte instanceof CarteDeux;
	}
	
	
	
	

}
