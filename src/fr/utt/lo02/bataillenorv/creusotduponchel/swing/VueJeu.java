package fr.utt.lo02.bataillenorv.creusotduponchel.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Jeu;

public class VueJeu extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Jeu jeu;
	private JCarte carteDuTas;
	private JLabel nbTas, nbPioche;
	

	public VueJeu(Jeu jeu) {
		this.jeu = jeu;
		if(this.jeu != null) this.jeu.addObserver(this);
		carteDuTas = new JCarte();
		nbTas = new JLabel("0"); nbPioche = new JLabel("0");
		build();
	}

	private void build() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0; c.gridy=0;c.gridheight = GridBagConstraints.REMAINDER; c.fill = GridBagConstraints.BOTH;
		carteDuTas.setBorder(BorderFactory.createTitledBorder("Tas"));
		this.add(carteDuTas,c);
		
		
		c.gridx=1;c.gridy=0; c.gridheight = 1;
		add(new JLabel("nb tas : "),c);
		c.gridy++;
		add(new JLabel("nb pioche : "),c);
		c.gridy=0;c.gridx++;c.gridwidth = GridBagConstraints.REMAINDER;
		add(nbTas,c);
		c.gridy++;
		add(nbPioche,c);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.nbTas.setText(jeu.getTas().size()+"");
		this.nbPioche.setText(jeu.getPioche().size()+"");
		this.carteDuTas.setCarte(jeu.getTas().size()>0?jeu.getTas().getLast():null);
		this.carteDuTas.setEnabled(false);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setContentPane(new VueJeu(null));
		f.pack();
	}
	
	

}
