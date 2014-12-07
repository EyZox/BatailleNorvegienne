package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.Collection;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class RandomIA extends AbstractStrategie {

	public RandomIA(Joueur joueur, Collection<Joueur> listeJoueur) {
		super(joueur, listeJoueur);
	}

	@Override
	public CoupleEchangeCarte choisirCarteEchanger() {
		if(Math.random() < 0.5) return null;
		return new CoupleEchangeCarte(
				joueur.getMain().get((int)(Math.random()*joueur.getMain().size())),
				joueur.getVisibles().get((int)(Math.random()*joueur.getVisibles().size())));
	}

	@Override
	public Carte choisirCarteAPoser(Carte derniereCarte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int choisirCachee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Adversaire choisirAdversaire() {
		// TODO Auto-generated method stub
		return null;
	}

}
