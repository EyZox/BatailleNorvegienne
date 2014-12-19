package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.IA;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class AggressiveIA extends IA {

	@Override
	public CoupleEchangeCarte choisirCarteEchanger() {

		//On trie les cartes
		Collections.sort(joueur.getMain());
		Collections.sort(joueur.getVisibles());

		//On check si la plus grande carte de la main est supérieur a la plus petite carte visible
		if(joueur.getMain().get(joueur.getMain().size()-1).compareTo(joueur.getVisibles().get(0)) > 0) {
			//On echange
			return new CoupleEchangeCarte(joueur.getMain().get(joueur.getMain().size()-1), joueur.getVisibles().get(0));
		}else {
			return null;
		}
	}

	@Override
	public List<Carte> choisirCartesAPoser(Carte derniereCarte) {
		List<Carte> choix = new ArrayList<>();
		//on trie les cartes
		Collections.sort(joueur.getMain());
		for(Carte c : joueur.getMain()) {
			if((derniereCarte == null || derniereCarte.accept(c))|| (!choix.isEmpty() && choix.size() < 3 && choix.get(0) == c)) {
				choix.add(c);
			}else if(!choix.isEmpty()) {
				break;
			}
		}
		if(choix.isEmpty()) return null;
		return choix;
	}

	@Override
	public int choisirCachee() {
		return (int) (Math.random() * joueur.getNbCachees());
	}

	@Override
	protected Adversaire choisirAdversaire() {
		return adversaires.get((int) (Math.random() * adversaires.size()));
	}

}
