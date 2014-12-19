package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.Strategie;

public abstract class AbstractStrategie implements Strategie {

	protected List<Adversaire> adversaires;
	protected Joueur joueur;

	@Override
	public Joueur choisirJoueur() {
		Adversaire adv = choisirAdversaire();
		if(adv == null) return null;
		return adv.getJoueur();
	}
	
	protected abstract Adversaire choisirAdversaire();

	@Override
	public final void setJoueur(Joueur j) {
		if(joueur == null) {
			joueur = j;
		}else {
			//Throw exception
		}
		
	}

	@Override
	public void setAdversaires(List<Adversaire> joueurs) {
		adversaires = joueurs;
	}
	
	

}
