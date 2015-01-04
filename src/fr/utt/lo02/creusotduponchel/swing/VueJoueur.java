package fr.utt.lo02.creusotduponchel.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;

public class VueJoueur extends JPanel implements Observer {

	private Joueur joueur;
	private JCarte[] visibles;
	private JLabel nbCachees;
	private JLabel nbMain;
	
	
	public VueJoueur(Joueur joueur) {
		this.joueur = joueur;
		visibles =  new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		nbCachees = new JLabel("0");
		nbMain = new JLabel("0");
		build();
	}
	
	
	private void build() {
		this.setLayout(new GridBagLayout());
		if(joueur != null) this.setBorder(BorderFactory.createTitledBorder(joueur.getNom()));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0; c.gridy=0; c.gridheight = GridBagConstraints.REMAINDER; c.fill = GridBagConstraints.BOTH; c.weightx = 0.8; c.weighty = 1;
		
		JPanel pVisibles = new JPanel();
		pVisibles.setBorder(BorderFactory.createTitledBorder("Carte(s) visible(s)"));
		pVisibles.setLayout(new BoxLayout(pVisibles, BoxLayout.X_AXIS));
		for(JCarte carte : visibles) {
			pVisibles.add(carte);
		}
		
		this.add(pVisibles, c);
		c.gridx=1; c.gridy=0; c.gridheight=1; c.weightx=0;
		this.add(new JLabel("Nb Cachees : "),c);
		c.gridx=1; c.gridy=1;
		this.add(new JLabel("Nb en main : "),c);
		c.gridx=2; c.gridy=0; c.weightx=0.2;
		this.add(nbCachees,c);
		c.gridx=2; c.gridy=1;
		this.add(nbMain,c);
		
		nbCachees.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		nbMain.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		for(int i=0; i<joueur.getVisibles().size();i++) {
			visibles[i].setCarte(joueur.getVisibles().get(i));
		}
		
		for(int i = joueur.getVisibles().size(); i < 3; i++) {
			visibles[i].setCarte(null);
		}
		
		nbCachees.setText(joueur.getNbCachees()+"");
		nbMain.setText(joueur.getMain().size()+"");
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setContentPane(new VueJoueur(null));
		f.pack();
	}

	/*
	private ArrayList<JButton> listeDeCartes;

	public VueJoueur(Joueur j) {
		this.joueur = j;
		int nbcartes = j.getMain().size();
		this.setLayout(new GridLayout(1,nbcartes));
		for (int i = 0; i < nbcartes; i++) {
			listeDeCartes.add(new VueCarte(j.getMain().get(i)));
			this.add(listeDeCartes.get(i));
		}
	}

	@Override
	public void update(Observable j, Object arg) {
		// TODO Auto-generated method stub
		//this.joueur = (Joueur)j;
		int nbcartes = joueur.getMain().size();
		this.removeAll();
		listeDeCartes.removeAll(listeDeCartes);
		for (int i = 0; i < nbcartes; i++) {			
			listeDeCartes.add(new VueCarte(joueur.getMain().get(i)));
			this.add(listeDeCartes.get(i));
		}
		this.validate();
	}
	*/

}
