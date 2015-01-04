package fr.utt.lo02.creusotduponchel.swing;


import java.awt.Dimension;

import javax.swing.JButton;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;

public class JCarte extends JButton {
	
	public JCarte() {
		setPreferredSize(new Dimension(30,45));
	}
	
	public void setCarte(Carte c) {
		if(c == null) {
			this.setText("");
		}else {
			this.setText(c.getValeur()+"");
		}
		this.setEnabled(c!=null);
	}
	
}
