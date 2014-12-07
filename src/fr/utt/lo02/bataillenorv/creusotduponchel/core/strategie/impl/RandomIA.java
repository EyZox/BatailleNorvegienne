package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		List<Carte> possibilites = new ArrayList<>();
		for(Carte c : joueur.getMain()) {
			if(c.peutEtreJoueeSur(derniereCarte)) possibilites.add(c);
		}
		return joueur.getMain().get((int)(Math.random()*joueur.getMain().size()));
	}

	@Override
	public int choisirCachee() {
		return (int)(Math.random()*joueur.getNbCachees());
	}

	@Override
	protected Adversaire choisirAdversaire() {
		return adversaires.get((int)(Math.random()*adversaires.size()));
	}

}
