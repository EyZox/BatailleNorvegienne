package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Joueur {
	private static int nombredejoueurs;
	private int identifiant;
	private String nom;
	private ArrayList<Carte> main;
	private ArrayList<Carte> cachees;
	private ArrayList<Carte> visibles;
	private Strategie strategie;

	public Joueur(Strategie strategie){
		this.strategie=strategie;
		this.main=new ArrayList<Carte>();
		this.cachees=new ArrayList<Carte>(3);
		this.visibles=new ArrayList<Carte>(3);
		this.identifiant=Joueur.nombredejoueurs;
		Joueur.nombredejoueurs++;
	}

	public void distribuer(ArrayList<Joueur> listeDesJoueurs, Queue<Carte> pioche){
		for(int i = 0; i<3; i++) {
			for(Joueur joueur : listeDesJoueurs) {
				joueur.main.add(pioche.poll());
				joueur.cachees.add(pioche.poll());
				joueur.visibles.add(pioche.poll());
			}
		}
	}

	public void piocher(Carte carte){
		this.main.add(carte);
	}

	public void echanger(Carte carteMain, Carte carteVisible){
		if(this.main.contains(carteMain)&&this.visibles.contains(carteVisible)){
			this.main.add(this.visibles.remove(this.visibles.indexOf(carteVisible)));
			this.visibles.add(this.main.remove(this.main.indexOf(carteMain)));
		}
	}

	public void piocherVisibles(){
		this.main.addAll(visibles);
		this.visibles.clear();
	}

	public void piocherCachee(){
		Carte carte;
		do {
			carte = strategie.choisirCachee();
		}while(!this.cachees.remove(carte));
		this.main.add(carte);
	}

	public void ramasserTas(LinkedList<Carte> tas){
		this.main.addAll(tas);
		tas.clear();
	}

}
