package fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.AbstractStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;
/**
 * classe qui fait office de strategie en etant l'interraction avec le joueur
 * @author Alexandre
 *
 */
public class ConsoleStrategie extends AbstractStrategie {
	/**
	 * classe representant un scanner pour que le joueur ne rentre pas autre chose qu'un int
	 * @author Alexandre
	 *
	 */
	private class ProtectedIntScanner {
		Scanner sc;
		/**
		 * constructeur
		 * @param is flux d'octet en entree
		 */
		ProtectedIntScanner(InputStream is) {
			sc = new Scanner(is);
		}
		/**
		 * lis un entier
		 * @return l'entier entre par l'utilisateur
		 */
		public int nextInt() {
			while(true)
			try {
				return sc.nextInt();
			}catch(InputMismatchException e) {
				System.err.println("Veuillez entrer un indice numérique");
				sc.nextLine();
			}
		}
	}
	private ProtectedIntScanner sc;
	/**
	 * constructeur
	 */
	public ConsoleStrategie() {
		sc = new ProtectedIntScanner(System.in);
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
	public List<Carte> choisirCartesAPoser(Carte derniereCarte) {
		List<Integer> choix = new ArrayList<>();
		int main;
		System.out.println("Dernière carte sur le tas : "+derniereCarte);
		System.out.println("Selectionner une carte de votre main (<0 pour ne rien poser)");
		do {
			afficherCarteChoisies(choix);
			main = sc.nextInt();
			if(main >= 0 && main < joueur.getMain().size()) {
				if(choix.isEmpty()) {
					if(derniereCarte == null || derniereCarte.accept(joueur.getMain().get(main))) {
						choix.add(main);
					}else {
						System.out.println("Impossible de placer cette carte");
					}
				}else if(choix.contains(main)) {
					choix.remove((Integer) main);
				}else if(choix.size() < 3) {
					if(joueur.getMain().get(choix.get(0)) == joueur.getMain().get(main)){
						choix.add(main);
					}else {
						System.out.println("Vous devez choisir des cartes de valeurs identiques");
					}
				}else {
					System.out.println("Vous ne pouvez pas choisir plus que 3 cartes");
				}
			}

		}while(main >= 0);
		//Construit la liste des cartes
		if(choix.isEmpty()) return null;
		List<Carte> l = new ArrayList<>(choix.size());
		for(int i : choix) {
			l.add(joueur.getMain().get(i));
		}
		return l;
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
	
	/**
	 * methode d'affichage du jeu complet du joueur
	 */
	private void afficherJeuJoueur() {
		afficherAdversaire();
		afficherMain();
		afficherVisibles();
		afficherCachees();
	}

	/**
	 * methode d'affichage de la main
	 */
	private void afficherMain() {
		System.out.println("Cartes en main :"+joueur.getMain());
	}

	/**
	 * methode d'affichage des cartes visibles
	 */
	private void afficherVisibles() {
		System.out.println("Cartes visibles :"+joueur.getVisibles());
	}

	/**
	 * methode d'affichage des cartes cachees
	 */
	private void afficherCachees() {
		System.out.print("Cartes cachées : [");
		for(int i=0; i<joueur.getNbCachees(); i++) {
			System.out.print("X");
			if(i<joueur.getNbCachees()-1)System.out.print(",");
		}
		System.out.println("]");
	}

	/**
	 * methode d'affichage des adversaires
	 */
	private void afficherAdversaire() {
		System.out.println("Adversaires :");
		for(int i = 0; i<adversaires.size(); i++) {
			System.out.println(i+" - "+adversaires.get(i));
		}
	}

	/**
	 * methode d'affichage des cartes choisies pour etre posees
	 */
	private void afficherCarteChoisies(Collection<Integer> indiceCarteChoisies) {
		System.out.print("Carte choisies (entre []): ");
		for(int i = 0; i<joueur.getMain().size(); i++) {
			if(indiceCarteChoisies.contains(i)) System.out.print("["+joueur.getMain().get(i)+"] ");
			else System.out.print(joueur.getMain().get(i)+" ");
		}
		System.out.println();
	}

}
