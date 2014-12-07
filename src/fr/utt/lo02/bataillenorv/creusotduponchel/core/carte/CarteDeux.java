package fr.utt.lo02.bataillenorv.creusotduponchel.core.carte;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.CarteSpeciale;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;

public class CarteDeux extends CarteSpeciale {

	public CarteDeux() {
		super(2);
	}
	
	

	@Override
	public void effet(Jeu jeu) {
		//pas d'effet

	}



	@Override
	public boolean peutEtreJoueeSur(Carte carte) {
		return true;
	}

}
