package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Iterator;
import java.util.List;
/**
 * classe represantant un tour de jeu
 * @author Alexandre
 *
 */
public class TourJeu implements Iterator<Joueur>, Cloneable{
	/**
 	* joueurs est la liste des joueurs 
 	*/
	private List<Joueur> joueurs;
	/**
	 * indice dans la liste du joueur courant
	 */
	private int index = -1;
	
	/**
	 * constructeur 
	 * @param joueurs initialisation de la liste des joueurs
	 */
	public TourJeu(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	/**
	 * constructeur avec 2 parametres
	 * @param joueurs initialisation de la liste des joueurs
	 * @param depart initialisation de l index
	 */
	public TourJeu(List<Joueur> joueurs, int depart) {
		this(joueurs);
		this.index = depart;
	}
	
	@Override
	/**
	 * @return vrai
	 */
	public boolean hasNext() {
		return true;
	}

	@Override
	/**
	 * @return le joueur suivant
	 */
	public Joueur next() {
		if(index >= joueurs.size()-1) index = -1;
		return joueurs.get(++index);
	}

	@Override
	public void remove() {
	}

	@Override
	public Object clone() {
		TourJeu t = null;
		try {
			t = (TourJeu) super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		t.joueurs = joueurs;
		return t;
	}
	
	/**
	 * @return le joueur courant
	 */
	public Joueur getJoueurCourant() {
		return index<0?null:joueurs.get(index);
	}
	/**
	 * modifie l indice du joueur courant
	 * @param j le nouveau joueur courant
	 */
	public void setJoueurCourant(Joueur j) {
		if(joueurs.contains(j)) {
			index = joueurs.indexOf(j);
		}
	}
}
