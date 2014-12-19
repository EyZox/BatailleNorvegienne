package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.IA;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class AggressiveIA extends IA {

	@Override
	public CoupleEchangeCarte choisirCarteEchanger() {
		
		//On trie les cartes
		Collections.sort(joueur.getMain());
		Collections.sort(joueur.getVisibles());
		
		//On check si la plus grande carte de la main est supérieur a la plus petite carte visible
		if(joueur.getMain().get(joueur.getMain().size()-1).compareTo(joueur.getVisibles().get(0)) > 0) {
			//On echange
			return new CoupleEchangeCarte(joueur.getMain().get(joueur.getMain().size()-1), joueur.getVisibles().get(0));
		}else {
			return null;
		}
	}

	@Override
	public List<Carte> choisirCartesAPoser(Carte derniereCarte) {
		List<Carte> possibilites = new ArrayList<>();
		List<Carte> choix = new ArrayList<>();
		Carte plusPetite = new Carte(13);
		//cas ou il n'y a pas de carte sur le tas
		if (derniereCarte == null)
			possibilites = joueur.getMain();
		// sinon on cherche les cartes possibles
		else {
			for (Carte c : joueur.getMain()) {
				if (derniereCarte.accept(c)) {
					possibilites.add(c);
				}
			}
		}
		// on parcourt les cartes possibles pour chercher la plus petite valeur
		for (Carte carte : possibilites)
			if (carte.getValeur() < plusPetite.getValeur())
				plusPetite = carte;
		// plusPetite est la plus petite carte posable, il faut ensuite verifier
		// si il y en a plusieurs
		for (int i = 0; i < 3; i++) {
			if(possibilites.remove(plusPetite))
			choix.add(plusPetite);
		}

		return choix;
	}

	@Override
	public int choisirCachee() {
		return (int) (Math.random() * joueur.getNbCachees());
	}

	@Override
	protected Adversaire choisirAdversaire() {
		return adversaires.get((int) (Math.random() * adversaires.size()));
	}

}
