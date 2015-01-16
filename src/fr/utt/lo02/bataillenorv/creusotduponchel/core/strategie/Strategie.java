package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie;

import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;
/**
 * Interface Strategie definissant les methodes a surcharger dans les strategies (humaines ou non)
 * @author Alexandre
 *
 */
public interface Strategie {
	/**
	 * choisit un couple carte de la main - carte visible a echanger
	 * @return le couple a echanger
	 */
	CoupleEchangeCarte choisirCarteEchanger();
	/**
	 * choisit une ou des cartes a poser sur le tas central
	 * @param derniereCarte la carte sur le dessus du tas central
	 * @return la liste des cartes a poser
	 */
	List<Carte> choisirCartesAPoser(Carte derniereCarte);
	/**
	 * choisit une carte cachee a prendre en main
	 * @return l'indice de la carte cachee (entre 0 et 2 inclus)
	 */
	int choisirCachee();
	/**
	 * choisit le joueur adverse lorsqu'un as est posé
	 * @return le joueur adverse choisit
	 */
	Joueur choisirJoueur();
	/**
	 * initialise le joueur
	 * @param j le joueur en question
	 */
	void setJoueur(Joueur j);
	/**
	 * initialise la liste des joueurs adverses
	 * @param joueurs la liste des joueurs adverses
	 */
	void setAdversaires(List<Adversaire> joueurs);
}
