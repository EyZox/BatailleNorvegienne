package fr.utt.lo02.creusotduponchel.swing;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;

public class VueJeu extends JFrame implements Observer {
	private Jeu jeu;
	private JButton carteDuTas;
	private VueJoueur joueurCourant;

	public VueJeu(Jeu jeu) {
		super("Bataille Norvegienne");
		this.jeu = jeu;
		carteDuTas = new JButton("X");
		// get tas renvoie une collection et non une linkedList (changé)
		if (this.jeu.getTas().size() != 0) {
			carteDuTas = new VueCarte(this.jeu.getTas().getLast());		
		}
		
		joueurCourant = new VueJoueur(this.jeu.getTourJeu().getJoueurCourant());
		this.add(joueurCourant);
		this.add(carteDuTas);
		this.pack();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.jeu = jeu;
		carteDuTas = new VueCarte(this.jeu.getTas().getLast());
		joueurCourant = new VueJoueur(this.jeu.getTourJeu().getJoueurCourant());
		this.validate();
		this.pack();
	}

}
