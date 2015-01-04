package fr.utt.lo02.bataillenorv.creusotduponchel.test;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl.AggressiveIA;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl.ConsoleStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl.RandomIA;
import fr.utt.lo02.creusotduponchel.swing.VueJeu;
import fr.utt.lo02.creusotduponchel.swing.VueJoueur;
import fr.utt.lo02.creusotduponchel.swing.strategie.impl.VueStrategie;

public class StartUI {
	public static void main(String[] args) {
		//Construction de la liste des joueurs
		List<Joueur> joueurs = new LinkedList<>();
		Joueur jHumain = new Joueur(new ConsoleStrategie(), "moi");
		
		if(args.length > 0) 
			jHumain = new Joueur(new ConsoleStrategie(), args[0]);
			
		joueurs.add(jHumain);
		joueurs.add(new Joueur(new RandomIA()));
		joueurs.add(new Joueur(new AggressiveIA()));
		joueurs.add(new Joueur(new RandomIA()));
		joueurs.add(new Joueur(new RandomIA()));
		joueurs.add(new Joueur(new AggressiveIA()));
		
		//Creation du jeu
		Jeu jeu = new Jeu(joueurs);
		VueJeu j = new VueJeu(jeu);
		jeu.addObserver(j);
		
		//Création de la fenetre
		JFrame f = new JFrame("Bataille Norvegienne");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(j, BorderLayout.CENTER);
		f.getContentPane().add(new VueStrategie(jHumain), BorderLayout.SOUTH);
		JPanel vueAdversaires = new JPanel();
		vueAdversaires.setLayout(new BoxLayout(vueAdversaires, BoxLayout.X_AXIS));
		
		for(Joueur player : joueurs) {
			if(player != jHumain) {
				vueAdversaires.add(new VueJoueur(player));
			}
		}
		f.getContentPane().add(new JScrollPane(vueAdversaires), BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);
		
		//Demarage du jeu
		jeu.start();
	}
}
