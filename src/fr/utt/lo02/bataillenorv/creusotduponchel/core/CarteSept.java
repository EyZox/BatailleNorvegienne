package fr.utt.lo02.bataillenorv.creusotduponchel.core;


public class CarteSept extends Carte {

	public CarteSept() {
		super(7);
	}

	@Override
	public boolean accept(Carte carte) {
		return carte.bypass() || this.getValeur()<=carte.getValeur();
	}

}
