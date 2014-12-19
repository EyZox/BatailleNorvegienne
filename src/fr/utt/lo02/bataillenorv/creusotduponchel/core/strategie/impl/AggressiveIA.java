package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class AggressiveIA extends AbstractStrategie {

	public AggressiveIA(Joueur joueur, Collection<Joueur> listeJoueur) {
		super(joueur, listeJoueur);
	}

	@Override
	public CoupleEchangeCarte choisirCarteEchanger() {
		int plusPetiteCarteVisible = Integer.MAX_VALUE;
		int plusGrandeCarteMain = 0;
		int indexVisibles = 0;
		int indexMain = 0;
		for (int i = 0; i < 3; i++) {
			if (joueur.getMain().get(i).getValeur() < plusPetiteCarteVisible) {
				indexVisibles = i;
				plusPetiteCarteVisible = joueur.getMain().get(i).getValeur();
			}
			if (joueur.getVisibles().get(i).getValeur() > plusGrandeCarteMain) {
				indexMain = i;
				plusGrandeCarteMain = joueur.getVisibles().get(i).getValeur();
			}
		}
		if (plusPetiteCarteVisible > plusGrandeCarteMain)
			return null;
		return new CoupleEchangeCarte(joueur.getMain().get(indexMain), joueur
				.getVisibles().get(indexVisibles));
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
