package fr.utt.lo02.bataillenorv.creusotduponchel.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.swing.strategie.impl.ControllerStrategie;

public class VueJoueur extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Joueur joueur;
	private JCarte[] visibles;
	private JLabel nbCachees;
	private JLabel nbMain;
	private JButton designer;
	
	private ControllerStrategie ctrl;
	
	
	public VueJoueur(Joueur joueur, ControllerStrategie ctrl) {
		this.joueur = joueur;
		this.ctrl = ctrl;
		if(this.joueur != null) this.joueur.addObserver(this);
		visibles =  new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		nbCachees = new JLabel("0");
		nbMain = new JLabel("0");
		designer = new JButton("Designer");
		build();
		listeners();
	}
	
	
	private void listeners() {
		designer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(ctrl==null) return;
				ctrl.setInput(joueur);
				
			}
		});
		
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
		c.gridx=1; c.gridy=2; c.gridwidth = GridBagConstraints.REMAINDER;
		this.add(designer,c);
		
		nbCachees.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		nbMain.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		for(int i=0; i<joueur.getVisibles().size();i++) {
			visibles[i].setCarte(joueur.getVisibles().get(i));
			visibles[i].setEnabled(false);
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
		f.setContentPane(new VueJoueur(null,null));
		f.pack();
	}

}
