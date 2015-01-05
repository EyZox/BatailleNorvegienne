package fr.utt.lo02.creusotduponchel.swing.strategie.impl;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.creusotduponchel.swing.JCarte;

public class VueStrategie extends JPanel implements Observer{
	
	private Joueur joueur;

	protected JCarte[] visibles;
	protected JCarte[] cachees;
	private JPanel pMain;
	
	public VueStrategie(Joueur joueur) {
		this.joueur = joueur;
		if(this.joueur != null) this.joueur.addObserver(this);
		visibles = new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		cachees = new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		pMain = new JPanel();
		build();
	}
	
	private void build() {
		this.setLayout(new BorderLayout());
		
		JPanel pVisibles = new JPanel();
		pVisibles.setBorder(BorderFactory.createTitledBorder("Carte(s) visible(s)"));
		pVisibles.setLayout(new BoxLayout(pVisibles, BoxLayout.X_AXIS));
		for(JCarte c : visibles) {
			pVisibles.add(c);
		}
		
		this.add(pVisibles, BorderLayout.WEST);
		
		JPanel pCachees = new JPanel();
		pCachees.setBorder(BorderFactory.createTitledBorder("Carte(s) cachee(s)"));
		pCachees.setLayout(new BoxLayout(pCachees, BoxLayout.X_AXIS));
		for(JCarte c : cachees) {
			pCachees.add(c);
		}
		
		this.add(pCachees, BorderLayout.EAST);
		
		pMain.setLayout(new BoxLayout(pMain, BoxLayout.X_AXIS));
		pMain.setPreferredSize(JCarte.DIMENSION);
		JScrollPane jsp = new JScrollPane(pMain);
		jsp.setBorder(BorderFactory.createTitledBorder(LineBorder.createGrayLineBorder(), "Carte(s) en main", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		this.add(jsp, BorderLayout.SOUTH);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(int i=0; i<joueur.getVisibles().size();i++) {
			visibles[i].setCarte(joueur.getVisibles().get(i));
		}
		
		for(int i = joueur.getVisibles().size(); i < 3; i++) {
			visibles[i].setCarte(null);
		}
		
		for(int i=0; i<joueur.getNbCachees();i++) {
			cachees[i].setText("Cachee");
		}
		
		for(int i = joueur.getNbCachees(); i < 3; i++) {
			cachees[i].setCarte(null);
		}
		
		pMain.removeAll();
		for(Carte c : joueur.getMain()) {
			pMain.add(new JCarte(c));
		}
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setContentPane(new VueStrategie(null));
		f.pack();
	}

}
