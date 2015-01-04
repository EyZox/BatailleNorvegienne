package fr.utt.lo02.creusotduponchel.swing.container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import fr.utt.lo02.creusotduponchel.swing.JCarte;

public class Vue3Cartes extends JPanel {

	private JCarte[] jCartes;
	
	public Vue3Cartes(String borderTitle) {
		jCartes = new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		
		JPanel pVisibles = new JPanel();
		pVisibles.setBorder(BorderFactory.createTitledBorder(borderTitle));
		pVisibles.setLayout(new BoxLayout(pVisibles, BoxLayout.X_AXIS));
		for(JCarte c : jCartes) {
			pVisibles.add(c);
		}
	}
	
	public JCarte[] getJCartes() {
		return jCartes;
	}
	
}
