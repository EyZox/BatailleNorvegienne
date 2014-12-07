package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Jeu {
	private Iterator<Joueur> tourJeu;
	private List<Joueur> listeDeJoueurs;
	
	public Jeu(LinkedList<Joueur> listeDeJoueurs){
	//	this.tourJeu=new Iterator<Joueur>();
		this.listeDeJoueurs=listeDeJoueurs;
	}
}
