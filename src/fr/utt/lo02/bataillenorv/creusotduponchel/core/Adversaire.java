package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.List;
/**
 * Classe permettant de restreindre la visibilit� de certains �l�ment d'un joueur
 * @author Alexandre
 *
 */
public class Adversaire {
	/**
	 * le joueur en question
	 */
	private Joueur joueur;
	
	/**
	 * constructeur avec un joueur en parametre
	 * @param joueur initialise le joueur en question
	 */
	public Adversaire(Joueur joueur) {
		super();
		this.joueur = joueur;
	}
	
	/**
	 * Retourne les cartes visibles de l'adversaire
	 * @return liste des cartes visibles
	 */
	public List<Carte> getVisible() {
		return joueur.getVisibles();
	}
	
	/**
	 * Retourne le nombre de carte que l'adversaire poss�de face cach�e
	 * @return le nombre de carte face cach�e
	 */
	public int getNbCachees() {
		return joueur.getNbCachees();
	}
	
	/**
	 * Retourne le nombre de carte que l'adversaire a en main
	 * @return nombre de carte en main
	 */
	public int getNbMain() {
		return joueur.getMain().size();
	}
	
	/**
	 * Retourne le joueur correspondant a l'adversaire
	 * @return le joueur
	 */
	Joueur getJoueur() {
		return joueur;
	}
	
	/**
	 * Retourne le nom de l'adversaire 
	 * @return le nom de l'adversaire
	 */
	public String getNom() {
		return joueur.getNom();
	}

	@Override
	public String toString() {
		return joueur.getNom()+"[nb carte en main : "+getNbMain()+", carte visible : "+getVisible()+", nb carte cachees : "+getNbCachees();
	}
}