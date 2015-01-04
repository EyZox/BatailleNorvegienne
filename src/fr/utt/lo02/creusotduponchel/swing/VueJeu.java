package fr.utt.lo02.creusotduponchel.swing;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;

public class VueJeu extends JPanel implements Observer {
	private Jeu jeu;
	private Joueur joueurCourant;
	private JCarte carteDuTas;
	private JPanel mainJoueurCourant;
	private JPanel tas;
	

	public VueJeu(Jeu jeu) {
		this.setLayout(new GridLayout());
		this.jeu = jeu;
		this.carteDuTas = new JCarte();	
		this.mainJoueurCourant = new JPanel();
		this.tas = new JPanel();
		this.joueurCourant = this.jeu.getTourJeu().getJoueurCourant();
		// get tas renvoie une collection et non une linkedList (changé)
		if (this.jeu.getTas().size() != 0) {
			carteDuTas = new JCarte(this.jeu.getTas().getLast());		
		}
		int nbCartes=this.joueurCourant.getMain().size();
		for(int i =0;i<nbCartes;i++)
			this.mainJoueurCourant.add(new JCarte(this.joueurCourant.getMain().get(i)));
		this.tas.add(new JLabel("tas"));
		this.tas.add(carteDuTas);
		this.add(tas);
		this.add(mainJoueurCourant);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.mainJoueurCourant.removeAll();
		this.tas.removeAll();
		System.out.println("ok");
		this.jeu = (Jeu)arg0;
		this.carteDuTas.setCarte(null);	
		this.joueurCourant = this.jeu.getTourJeu().getJoueurCourant();
		
		if (this.jeu.getTas().size() != 0) {
			carteDuTas.setCarte(this.jeu.getTas().getLast());		
		}
		int nbCartes=this.joueurCourant.getMain().size();
		for(int i =0;i<nbCartes;i++)
			this.mainJoueurCourant.add(new JCarte(this.joueurCourant.getMain().get(i)));
		this.tas.add(new JLabel("tas"));
		this.tas.add(carteDuTas);
		
		this.add(tas);
		this.add(mainJoueurCourant);
	}

}
