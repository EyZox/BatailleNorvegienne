package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Iterator;
import java.util.List;

public class TourJeu implements Iterator<Joueur> {

	private List<Joueur> joueurs;
	private int index = -1;
	
	public TourJeu(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Joueur next() {
		if(index >= joueurs.size()) index = -1;
		return joueurs.get(++index);
	}

	@Override
	public void remove() {
	}

}
