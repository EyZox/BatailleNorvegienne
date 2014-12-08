package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private ArrayList<Carte> cachees;
	private ArrayList<Carte> visibles;
	private Strategie strategie;

	/**
	 * Crée un joueur avec une strategie et un nom
	 * @param strategie strategie du joueur
	 * @param nom nom du joueur
	 */
	public Joueur(Strategie strategie, String nom) {
		this(strategie);
		this.setNom(nom);
	}
	
	/**
	 * Cree un joueur avec une strategie
	 * @param strategie strategie du joueur
	 */
	public Joueur(Strategie strategie){
		this.strategie=strategie;
		this.main=new ArrayList<Carte>(3);
		this.cachees=new ArrayList<Carte>(3);
		this.visibles=new ArrayList<Carte>(3);
	}

	/**
	 * Distribue les cartes de la pioche
	 * @param listeDesJoueurs la liste des joueurs incluant le joueur qui distribue
	 * @param pioche la pioche de carte a distribuer
	 */
	void distribuer(List<Joueur> listeDesJoueurs, Queue<Carte> pioche){
		for(int i = 0; i<3; i++) {
			for(Joueur joueur : listeDesJoueurs) {
				joueur.main.add(pioche.poll());
				joueur.cachees.add(pioche.poll());
				joueur.visibles.add(pioche.poll());
			}
		}
	}

	/**
	 * Ajoute une carte dans la main du joueur
	 * @param carte la carte piochée
	 */
	void piocher(Carte carte){
		this.main.add(carte);
	}

	/**
	 * Echange ses cartes de la main avec ses cartes visible
	 */
	void echanger(){
		CoupleEchangeCarte cartes;
		do {
			cartes = strategie.choisirCarteEchanger();
			if(this.main.contains(cartes.getMain()) && this.visibles.contains(cartes.getVisible())) {
				this.main.remove(cartes.getMain());
				this.visibles.add(cartes.getMain());
				
				this.visibles.remove(cartes.getVisible());
				this.main.add(cartes.getVisible());
			}
		}while(cartes !=null);
	}

	/**
	 * Recupère les cartes visibles dans sa main
	 */
	void piocherVisibles(){
		this.main.addAll(visibles);
		this.visibles.clear();
	}

	/**
	 * Pioche une carte parmis ses cartes cachees et l'ajoute a sa main
	 */
	void piocherCachee(){
		int indice;
		do {
			indice = strategie.choisirCachee();
		}while(indice<0 || indice>cachees.size());
		this.main.add(this.cachees.remove(indice));
	}

	/**
	 * Ramasse le tas de carte et l'ajoute a sa main
	 * @param tas
	 */
	void ramasserTas(Collection<Carte> tas){
		this.main.addAll(tas);
		tas.clear();
	}
	
	/**
	 * Retourne un joueur adverse
	 */
	Joueur selectionerJoueur() {
		Joueur j;
		do {
			j = this.strategie.choisirJoueur();
		}while(j==this);
		return j;
	}

	/**
	 * Retourne la liste des cartes dans la main du joueur
	 * @return liste des cartes en main
	 */
	public ArrayList<Carte> getMain() {
		return main;
	}

	/**
	 * Retourne la liste des cartes visibles du joueur
	 * @return liste des cartes visibles
	 */
	public ArrayList<Carte> getVisibles() {
		return visibles;
	}
	
	/**
	 * Retourne le nombre de carte que le joueur possède face cachée
	 * @return le nombre de carte face cachée
	 */
	public int getNbCachees() {
		return cachees.size();
	}
	
	
	/**
	 * Retourne la liste des cartes cachees du joueur
	 * @return liste des cartes cachees
	 */
	List<Carte> getCachees() {
		return cachees;
	}

	/**
	 * Retourne le nom du joueur
	 * @return nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Definis le nom du joueur
	 * @param nom nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
