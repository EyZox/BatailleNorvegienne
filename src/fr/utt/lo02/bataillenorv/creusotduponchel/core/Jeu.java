package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jeu {
	private Iterator<Joueur> tourJeu;
	private List<Joueur> listeDeJoueurs;
	private Queue<Carte> pioche;
	private Collection<Carte> tas;
	
	
	
	public Jeu(LinkedList<Joueur> listeDeJoueurs){
		this.listeDeJoueurs=listeDeJoueurs;
		tas = new LinkedList<>();
		pioche = new LinkedList<>();
	}
	
	/**
	 * Initialise les cartes du jeu et les ajoutes dans la pioche
	 */
	private void initCartes() {
		
	}
	
	/**
	 * Lance la partie
	 */
	public void start() {
		
	}
	
	
}
