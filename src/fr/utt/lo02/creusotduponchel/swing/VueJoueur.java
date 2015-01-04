package fr.utt.lo02.creusotduponchel.swing;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;

public class VueJoueur extends JPanel implements Observer {

	private Joueur joueur;

	private ArrayList<JButton> listeDeCartes;

	public VueJoueur(Joueur j) {
		this.joueur = j;
		int nbcartes = j.getMain().size();
		this.setLayout(new GridLayout(1,nbcartes));
		for (int i = 0; i < nbcartes; i++) {
			listeDeCartes.add(new VueCarte(j.getMain().get(i)));
			this.add(listeDeCartes.get(i));
		}
	}

	@Override
	public void update(Observable j, Object arg) {
		// TODO Auto-generated method stub
		//this.joueur = (Joueur)j;
		int nbcartes = joueur.getMain().size();
		this.removeAll();
		listeDeCartes.removeAll(listeDeCartes);
		for (int i = 0; i < nbcartes; i++) {			
			listeDeCartes.add(new VueCarte(joueur.getMain().get(i)));
			this.add(listeDeCartes.get(i));
		}
		this.validate();
	}

}
