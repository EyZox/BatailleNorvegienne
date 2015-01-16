package fr.utt.lo02.bataillenorv.creusotduponchel.swing.strategie.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Adversaire;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.Strategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.wrapper.CoupleEchangeCarte;

public class ModelStrategie extends Observable implements Strategie {
	private String status;
	private ControllerStrategie ctrl;
	private Joueur joueur;

	public ModelStrategie(ControllerStrategie ctrl) {
		this.ctrl = ctrl;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		setChanged();
		notifyObservers();
	}

	@Override
	public CoupleEchangeCarte choisirCarteEchanger() {
		int main, visible;
		setStatus("Choisir une carte de la main a echanger");
		do {
			main = ctrl.getInput();
		}while(main >= joueur.getMain().size());
		if(main < 0) return null;
		setStatus("Choisir une carte visible a echanger avec "+joueur.getMain().get(main));
		do {
			visible = ctrl.getInput();
		}while(visible >= joueur.getVisibles().size());
		setStatus("");
		if(visible <0)return null;

		return new CoupleEchangeCarte(joueur.getMain().get(main), joueur.getVisibles().get(visible));
	}

	@Override
	public List<Carte> choisirCartesAPoser(Carte derniereCarte) {
		List<Integer> choix = new ArrayList<>();
		int main;
		do {
			setStatus("Selectionner une carte de votre main");
			if(!choix.isEmpty()) {
				String s = "";
				for(int i : choix) {
					s+=joueur.getMain().get(i);
					if(i != choix.get(choix.size()-1)) s+=", ";
				}
				setStatus("Choix : ["+s+"]");
			}
			main = ctrl.getInput();
			if(main >= 0 && main < joueur.getMain().size()) {
				if(choix.isEmpty()) {
					if(derniereCarte == null || derniereCarte.accept(joueur.getMain().get(main))) {
						choix.add(main);
					}else {
						setStatus("Impossible de placer cette carte");
					}
				}else if(choix.contains(main)) {
					choix.remove((Integer) main);
				}else if(choix.size() < 3) {
					if(joueur.getMain().get(choix.get(0)) == joueur.getMain().get(main)){
						choix.add(main);
					}else {
						setStatus("Vous devez choisir des cartes de valeurs identiques");
					}
				}else {
					setStatus("Vous ne pouvez pas choisir plus que 3 cartes");
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
		setStatus("Choississez une carte cachée :");
		return ctrl.getInput();
	}

	@Override
	public Joueur choisirJoueur() {
		setStatus("Choisir un joueur");
		return ctrl.getJoueur();
	}

	@Override
	public void setJoueur(Joueur j) {
		this.joueur = j;
		
	}

	@Override
	public void setAdversaires(List<Adversaire> joueurs) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
