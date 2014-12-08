package fr.utt.lo02.bataillenorv.creusotduponchel.core.carte;


public class CarteDeux extends Carte {

	public CarteDeux() {
		super(2);
	}

	@Override
	public boolean accept(Carte carte) {
		return true;
	}

	@Override
	protected boolean bypass() {
		return true;
	}

}
