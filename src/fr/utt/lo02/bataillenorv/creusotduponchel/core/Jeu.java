package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.Iterator;
import java.util.LinkedList;

public class Jeu {
	private Iterator<Joueur> tourJeu;
	private LinkedList<Joueur> listeDeJoueurs;
	
	public Jeu(LinkedList<Joueur> listeDeJoueurs){
	//	this.tourJeu=new Iterator<Joueur>();
		this.listeDeJoueurs=listeDeJoueurs;
	}
}
