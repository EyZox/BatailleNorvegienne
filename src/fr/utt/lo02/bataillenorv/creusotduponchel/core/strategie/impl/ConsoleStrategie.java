package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.util.Collection;
import java.util.Scanner;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.Carte;
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
	public Carte choisirCarteAPoser(Carte derniereCarte) {
		afficherJeuJoueur();
		int main;
		System.out.println("Selectionner une carte de votre main a placer");
		do {
			main = sc.nextInt();
		}while(main <0 || main >= joueur.getMain().size());
		return joueur.getMain().get(main);
	}

	@Override
	public int choisirCachee() {
		afficherCachees();
		System.out.println("Choississez une carte cachée :");
		return sc.nextInt();
	}

	@Override
	protected Adversaire choisirAdversaire() {
		afficherAdversaire();
		System.out.println("Selectionner le nom d'un adversaire : ");
		int adv;
		do {
			adv = sc.nextInt();
		}while(adv<0 || adv>=adversaires.size());
		return adversaires.get(adv);
	}
	
	private void afficherJeuJoueur() {
		afficherAdversaire();
		afficherMain();
		afficherVisibles();
		afficherCachees();
	}
	
	private void afficherMain() {
		System.out.println("Cartes en main :"+joueur.getMain());
	}
	
	private void afficherVisibles() {
		System.out.println("Cartes visibles :"+joueur.getVisibles());
	}
	
	private void afficherCachees() {
		System.out.print("Cartes cachées : [");
		for(int i=0; i<joueur.getNbCachees(); i++) {
			System.out.print("X");
			if(i<joueur.getNbCachees()-1)System.out.print(",");
		}
		System.out.println("]");
	}
	
	private void afficherAdversaire() {
		System.out.println("Adversaires :");
		for(int i = 0; i<adversaires.size(); i++) {
			System.out.println(i+" - "+adversaires.get(i));
		}
	}

}
