package fr.utt.lo02.creusotduponchel.swing;


import javax.swing.JButton;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;

public class VueCarte extends JButton {

	private Carte carte;
	
	public VueCarte(Carte carte)
	{
		super(Integer.toString(carte.getValeur()));
		this.carte = carte;
	}
	
}
