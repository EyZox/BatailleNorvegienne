package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.Collection;
import java.util.Scanner;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class ConsoleStrategie extends AbstractStrategie {

	private Scanner sc;
	
	public ConsoleStrategie(Joueur joueur, Collection<Joueur> listeJoueur) {
		super(joueur, listeJoueur);
		sc = new Scanner(System.in);
	}

	@Override
	public CoupleEchangeCarte choisirCarteEchanger() {
		afficherJeuJoueur();
		int main, visible;
		System.out.println("Choisir une carte de la main a echanger (<0 pour ne rien changer)");
		do {
			main = sc.nextInt();
		}while(main >= joueur.getMain().size());
		if(main < 0) return null;
		System.out.println("Choisir une carte visible a echanger avec "+joueur.getMain().get(main)+"(<0 pour ne rien changer)");
		do {
			visible = sc.nextInt();
		}while(visible >= joueur.getVisibles().size());
		if(visible <0)return null;
		
		return new CoupleEchangeCarte(joueur.getMain().get(main), joueur.getVisibles().get(visible));
	}

	@Override
	public Collection<Carte> choisirCarteAPoser(Carte derniereCarte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carte choisirCachee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Adversaire choisirAdversaire() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void afficherJeuJoueur() {
		System.out.println("Cartes en main :"+joueur.getMain());
		System.out.println("Cartes visibles :"+joueur.getVisibles());
		System.out.print("Cartes cachées : [");
		for(int i=0; i<joueur.getNbCachees(); i++) {
			System.out.print("X");
			if(i<joueur.getNbCachees()-1)System.out.print(",");
		}
		System.out.println("]");
	}

}
