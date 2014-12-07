package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Collection;

public interface Strategie {
	Carte[] choisirCarteEchanger();
	Collection<Carte> choisirCarteAPoser(Carte derniereCarte);
	Carte choisirCacher();
	String choisirJoueur();
}
