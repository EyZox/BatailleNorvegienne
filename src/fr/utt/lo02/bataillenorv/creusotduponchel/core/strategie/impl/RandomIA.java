package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	public List<Carte> choisirCartesAPoser(Carte derniereCarte) {
		//Construction du set de cartes possible a jouer
		Set<Carte> possibilites = new HashSet<>();
		for(Carte c : joueur.getMain()) {
			if(derniereCarte.accept(c)) possibilites.add(c);
		}
		if(possibilites.isEmpty()) return null;
		
		//Determine quel carte jouer
		int rdn = (int) (Math.random()*possibilites.size());
		Iterator<Carte> it = possibilites.iterator();
		Carte choix = null;
		for(int i = 0; i<= rdn; i++) {
			choix = it.next();
		}
		
		//Compte le nombre de fois que la carte apparait dans la main
		int nbAppar = 0;
		for(Carte c : joueur.getMain()) {
			if(c == choix) nbAppar++;
			if(nbAppar >= 3) break;
		}
		
		//Ajoute un nombre aléatoire de carte choisie
		rdn = (int) (Math.random()*nbAppar) +1;
		List<Carte> l = new ArrayList<>(rdn);
		for(int i = 0 ; i < rdn; i++) {
			l.add(choix);
		}
		return l;
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
