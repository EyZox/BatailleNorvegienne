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
		int plusPetiteCarteVisible=Integer.MAX_VALUE;
		int plusGrandeCarteMain=0;
		int indexVisibles=0;
		int indexMain=0;
		for(int i=0;i<3;i++){
			if(joueur.getMain().get(i).getValeur()<plusPetiteCarteVisible){
				indexVisibles = i;
				plusPetiteCarteVisible=joueur.getMain().get(i).getValeur();
				}
			if(joueur.getVisibles().get(i).getValeur()>plusGrandeCarteMain){
				indexMain = i;
				plusGrandeCarteMain=joueur.getVisibles().get(i).getValeur();
			}
		}
		if(plusPetiteCarteVisible>plusGrandeCarteMain) return null;
		return new CoupleEchangeCarte(
				joueur.getMain().get(indexMain),
				joueur.getVisibles().get(indexVisibles));
	}

	@Override
	public Carte choisirCarteAPoser(Carte derniereCarte) {
		List<Carte> possibilites = new ArrayList<>();
		for(Carte c : joueur.getMain()) {
			if(derniereCarte.accept(c)) possibilites.add(c);
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
