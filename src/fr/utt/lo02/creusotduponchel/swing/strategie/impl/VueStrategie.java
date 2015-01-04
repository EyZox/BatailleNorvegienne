package fr.utt.lo02.creusotduponchel.swing.strategie.impl;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;

public class VueStrategie extends JPanel implements Observer{

	private static final JButton NO_CARTE = new JButton();
	static {
		NO_CARTE.setEnabled(false);
	}
	
	private Joueur joueur;

	private JButton[] visibles;
	private JButton[] cachees;
	private JScrollPane main;
	
	public VueStrategie(Joueur joueur) {
		this.joueur = joueur;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setContentPane(new VueStrategie(null));
		f.pack();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
