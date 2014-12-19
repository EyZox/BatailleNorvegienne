package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Jeu {
	private TourJeu tourJeu;
	private Joueur joueurCourant;
	private List<Joueur> listeDeJoueurs;
	private LinkedList<Carte> pioche;
	private LinkedList<Carte> tas;



	public Jeu(LinkedList<Joueur> listeDeJoueurs){
		this.listeDeJoueurs=listeDeJoueurs;
		tas = new LinkedList<>();
		pioche = new LinkedList<>();
		initCartes();
		tourJeu = new TourJeu(listeDeJoueurs, (int)(Math.random()*listeDeJoueurs.size()));
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
			Collection<Carte> cartesPosees = joueurCourant.poserCartes(tas.getLast());
			if(cartesPosees == null) {
				joueurCourant.ramasserTas(tas);
			}else {
				tas.addAll(cartesPosees);
				cartesPosees.iterator().next().onPlaced(this, cartesPosees.size());
				for(int i=0; i<cartesPosees.size();i++) {
					if(pioche.isEmpty()) break;
					joueurCourant.piocher(pioche.poll());
				}
				
				if(pioche.isEmpty() && joueurCourant.getMain().isEmpty()) {
					if(!joueurCourant.getVisibles().isEmpty()) {
						joueurCourant.piocherVisibles();
					}else {
						Carte carteCachee = null;
						while(!joueurCourant.getCachees().isEmpty() || joueurCourant.getMain().isEmpty()) {
							carteCachee = joueurCourant.piocherCachee();
							if(tas.getLast().accept(carteCachee)) {
								tas.add(carteCachee);
							}else {
								joueurCourant.piocher(carteCachee);
								joueurCourant.ramasserTas(tas);
							}
						}
						
						if(joueurCourant.getMain().isEmpty() && joueurCourant.getCachees().isEmpty()) {
							System.out.println("Gagnant : "+joueurCourant);
							return joueurCourant;
						}
					}
				}
			}
			
		}while(true);
	}
	
	public Iterator<Joueur> getTourJeu() {
		return tourJeu;
	}
	
	public Collection<Carte> getTas() {
		return tas;
	}
	
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}
	
	


}
