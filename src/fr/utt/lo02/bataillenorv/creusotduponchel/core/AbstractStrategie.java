package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Collection;

public abstract class AbstractStrategie implements Strategie {

	private Joueur joueur;
	private Collection<Adversaire> adversaires;
	
	public AbstractStrategie(Joueur joueur, Collection<Joueur> listeJoueur) {
		this.joueur = joueur;
		for(Joueur j : listeJoueur) {
			if(j != joueur) {
				adversaires.add(new Adversaire(j));
			}
		}
	}

	@Override
	public Joueur choisirJoueur() {
		Adversaire adv = choisirAdversaire();
		if(adv == null) return null;
		return adv.getJoueur();
	}
	
	protected abstract Adversaire choisirAdversaire();

}
