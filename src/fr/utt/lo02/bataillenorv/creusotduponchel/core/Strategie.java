package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public interface Strategie {
	CoupleEchangeCarte choisirCarteEchanger();
	List<Carte> choisirCartesAPoser(Carte derniereCarte);
	int choisirCachee();
	Joueur choisirJoueur();
}
