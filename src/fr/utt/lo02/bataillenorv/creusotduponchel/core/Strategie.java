package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Collection;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public interface Strategie {
	CoupleEchangeCarte choisirCarteEchanger();
	Carte choisirCarteAPoser(Carte derniereCarte);
	int choisirCachee();
	Joueur choisirJoueur();
}
