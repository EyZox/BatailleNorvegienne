package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.List;
/**
 * Classe permettant de restreindre la visibilité de certains élément d'un joueur
 * @author Alexandre
 *
 */
public class Adversaire {
	private Joueur joueur;

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
	 * Retourne le nombre de carte que l'adversaire possède face cachée
	 * @return le nombre de carte face cachée
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
}
