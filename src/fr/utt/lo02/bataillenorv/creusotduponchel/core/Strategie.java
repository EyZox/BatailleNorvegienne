package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Collection;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public interface Strategie {
	CoupleEchangeCarte choisirCarteEchanger();
	Collection<Carte> choisirCarteAPoser(Carte derniereCarte);
	Carte choisirCachee();
	String choisirJoueur();
}
