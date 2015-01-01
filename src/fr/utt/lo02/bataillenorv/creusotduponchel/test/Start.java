package fr.utt.lo02.bataillenorv.creusotduponchel.test;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl.AggressiveIA;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl.ConsoleStrategie;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.strategie.impl.RandomIA;
import fr.utt.lo02.creusotduponchel.swing.VueJeu;

public class Start {
	public static void main(String[] args) {
		//Construction de la liste des joueurs
		List<Joueur> joueurs = new LinkedList<>();
		if(args.length > 0) joueurs.add(new Joueur(new ConsoleStrategie(), args[0]));
		joueurs.add(new Joueur(new RandomIA()));
		joueurs.add(new Joueur(new AggressiveIA()));
		joueurs.add(new Joueur(new RandomIA()));
		joueurs.add(new Joueur(new RandomIA()));
		joueurs.add(new Joueur(new AggressiveIA()));
		
		//Creation du jeu
		Jeu jeu = new Jeu(joueurs);
		VueJeu j = new VueJeu(jeu);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		jeu.addObserver(j);
		jeu.start();
	}
	
}
