package fr.utt.lo02.bataillenorv.creusotduponchel.core.carte;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.CarteSpeciale;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;

public class CarteSept extends CarteSpeciale {

	public CarteSept() {
		super(7);
	}

	@Override
	public void effet(Jeu jeu) {
		//Pas d'effet
	}



	@Override
	public boolean accept(Carte carte) {
		return this.getValeur()<=carte.getValeur();
	}

}
