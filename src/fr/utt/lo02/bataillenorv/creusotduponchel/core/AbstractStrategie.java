package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.Strategie;
/**
 * Classe abstraite heritant de Strategie
 * @author Alexandre
 *
 */
public abstract class AbstractStrategie implements Strategie {

	protected List<Adversaire> adversaires;
	protected Joueur joueur;

	@Override
	/**
	 * Methode pour choisir un joueur adverse apres la pose d'un As
	 * @return le joueur adverse choisit
	 */
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
	/**
	 * initialise la liste des adversaires
	 * @param joueurs la liste des adversaires
	 */
	public void setAdversaires(List<Adversaire> joueurs) {
		adversaires = joueurs;
	}
	
	

}
