package fr.utt.lo02.bataillenorv.creusotduponchel.core;

import java.util.Iterator;
import java.util.List;

public class TourJeu implements Iterator<Joueur>, Cloneable{

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
}
