package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.IA;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;
/**
 * classe representant la strategie basique d'un joueur non-humain
 * @author Alexandre
 *
 */
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
			if((choix.isEmpty() && (derniereCarte == null || derniereCarte.accept(c))) || (!choix.isEmpty() && choix.size() < 3 && choix.get(0) == c)) {
				choix.add(c);
			}else if(!choix.isEmpty()) {
				break;
			}
		}
		if(choix.isEmpty()) return null;
		return choix;
	}

	@Override
	protected Adversaire choisirAdversaire() {
		Collections.sort(adversaires, new Comparator<Adversaire>() {

			@Override
			public int compare(Adversaire o1, Adversaire o2) {
				// *5 et *15 sont des coeffs
				return (o1.getNbMain()+o1.getVisible().size()*5+o1.getNbCachees()*15)-(o2.getNbMain()+o2.getVisible().size()*5+o2.getNbCachees()*15);
			}
		});
		return (adversaires.get(0));
	}

}
