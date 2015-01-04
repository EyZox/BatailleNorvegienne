package fr.utt.lo02.creusotduponchel.swing;


import java.awt.Dimension;

import javax.swing.JButton;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;

public class JCarte extends JButton {
	
	public static final Dimension DIMENSION = new Dimension(40,60);
	
	public JCarte() {
		setCarte(null);
	}
	
	public JCarte(Carte c) {
		this();
		setCarte(c);
	}
	
	public void setCarte(Carte c) {
		if(c == null) {
			this.setText("");
		}else {
			this.setText(c.getValeur()+"");
		}
		this.setEnabled(c!=null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return DIMENSION;
	}
	
	@Override
	public Dimension getMinimumSize() {
		return DIMENSION;
	}
	
	@Override
	public Dimension getMaximumSize() {
		return DIMENSION;
	}
	
}
