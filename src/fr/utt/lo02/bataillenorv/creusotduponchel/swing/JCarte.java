package fr.utt.lo02.bataillenorv.creusotduponchel.swing;


import java.awt.Dimension;

import javax.swing.JButton;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;

public class JCarte extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension DIMENSION = new Dimension(60,80);
	
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
