package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Jeu extends Observable{
	private TourJeu tourJeu;
	private Joueur joueurCourant;
	private List<Joueur> listeDeJoueurs;
	private LinkedList<Carte> pioche;
	private LinkedList<Carte> tas;



	public Jeu(List<Joueur> listeDeJoueurs){
		this.listeDeJoueurs=listeDeJoueurs;
		tas = new LinkedList<>();
		pioche = new LinkedList<>();
		initCartes();
		tourJeu = new TourJeu(listeDeJoueurs, (int)(Math.random()*listeDeJoueurs.size()));
		for(Joueur j : listeDeJoueurs) {
			j.init(listeDeJoueurs);
		}
	}

	/**
	 * Initialise les cartes du jeu et les ajoutes dans la pioche
	 */
	private void initCartes() {
		Collection<Carte> jeuCarte = new ArrayList<Carte>(13);
		//Initialise un jeu de carte
		for(int i=0; i<13; i++) {
			switch(i+1) {
			case 2 : 
				jeuCarte.add(new CarteDeux());
				break;
			case 7 :
				jeuCarte.add(new CarteSept());
				break;
			case 8 :
				jeuCarte.add(new CarteHuit());
				break;
			case 10 :
				jeuCarte.add(new CarteDix());
				break;
			case 1 :
				jeuCarte.add(new CarteAs());
				break;
			default :
				jeuCarte.add(new Carte(i+1));
				break;
			}
		}

		//nbJoueur/6+1 -> nb packet de carte -> (4*13 carte)
		for(int i =0; i<(listeDeJoueurs.size()/6 +1)*4; i++) {
			pioche.addAll(jeuCarte);
		}
		
		//on melange la pioche
		Collections.shuffle(pioche);
	}

	/**
	 * Lance une partie
	 */
	public Joueur start() {
		tourJeu.next().distribuer(listeDeJoueurs, pioche);
		for(Joueur j : listeDeJoueurs) {
			j.echanger();				
		}
		do {
			joueurCourant = tourJeu.next();
			//actualisation a chaque tour de jeu
			this.setChanged();
			this.notifyObservers();
			Joueur potentielGagnant = processCarteJouees(joueurCourant, joueurCourant.poserCartes(tas.isEmpty()?null:tas.getLast()));
			if(potentielGagnant != null) {
				System.out.println("Gagnant : "+potentielGagnant);
				return potentielGagnant;
			}
		}while(true);
	}
	
	public Joueur processCarteJouees(Joueur joueur, Collection<Carte> cartesJouees) {
		if(cartesJouees == null) {
			joueur.ramasserTas(tas);
		}else {
			tas.addAll(cartesJouees);
			cartesJouees.iterator().next().onPlaced(this, cartesJouees.size());
			for(int i=0; i<cartesJouees.size();i++) {
				if(pioche.isEmpty()) break;
				joueur.piocher(pioche.poll());
			}
			
			if(pioche.isEmpty() && joueur.getMain().isEmpty()) {
				if(!joueur.getVisibles().isEmpty()) {
					joueur.piocherVisibles();
				}else {
					Carte carteCachee = null;
					while(!joueur.getCachees().isEmpty() && joueur.getMain().isEmpty()) {
						carteCachee = joueur.piocherCachee();
						if(tas.isEmpty() || tas.getLast().accept(carteCachee)) {
							tas.add(carteCachee);
						}else {
							joueur.piocher(carteCachee);
							joueur.ramasserTas(tas);
						}
					}
					
					if(joueur.getMain().isEmpty() && joueur.getCachees().isEmpty()) {
						return joueur;
					}
				}
			}
		}
		return null;
	}
	
	public TourJeu getTourJeu() {
		return tourJeu;
	}
	
	public LinkedList<Carte> getTas() {
		return tas;
	}
}
