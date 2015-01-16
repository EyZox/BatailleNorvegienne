package fr.utt.lo02.bataillenorv.creusotduponchel.swing.strategie.impl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.Joueur;
import fr.utt.lo02.bataillenorv.creusotduponchel.swing.JCarte;

public class VueStrategie extends JPanel implements Observer, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Joueur joueur;

	protected JCarte[] visibles;
	protected JCarte[] cachees;
	private JLabel status;
	private JPanel pMain;
	private ControllerStrategie ctrl;
	private ModelStrategie model;
	private JButton passer;

	public VueStrategie(Joueur joueur, ModelStrategie model, ControllerStrategie ctrl) {
		this.joueur = joueur;
		this.model = model;
		this.ctrl = ctrl;
		if(this.joueur != null) this.joueur.addObserver(this);
		if(this.model != null) this.model.addObserver(this);
		visibles = new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		cachees = new JCarte[] { new JCarte(), new JCarte(), new JCarte() };
		pMain = new JPanel();
		status = new JLabel();
		passer = new JButton("Fin");
		build();
		listeners();
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

		
		JPanel center = new JPanel(new FlowLayout());
		center.add(passer);
		center.add(status);
		JPanel centerWrapper = new JPanel(new BorderLayout());
		centerWrapper.add(center, BorderLayout.SOUTH);
		this.add(centerWrapper,BorderLayout.CENTER);

	}

	private void listeners() {
		for(JCarte c : visibles) {
			c.addActionListener(this);
		}

		for(JCarte c : cachees) {
			c.addActionListener(this);
		}
		
		passer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(ctrl == null) return;
				ctrl.setInput(-1);
				
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0==model) {
			status.setText(model.getStatus());
		}else if(arg0==joueur){

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

			for(int i = 0; i<pMain.getComponents().length; i++) {
				if(pMain.getComponent(i) instanceof JCarte) {
					((JCarte) pMain.getComponent(i)).removeActionListener(this);
				}
			}
			pMain.removeAll();
			for(Carte c : joueur.getMain()) {
				JCarte jc = new JCarte(c);
				pMain.add(jc);
				jc.addActionListener(this);
			}
			pMain.repaint();
		}

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setContentPane(new VueStrategie(null, null,null));
		f.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ctrl == null) return;

		for(int c = 0; c<visibles.length; c++) {
			if(visibles[c] == e.getSource()) {
				ctrl.setInput(c);
				return;
			}
		}

		for(int c = 0; c<cachees.length; c++) {
			if(cachees[c] == e.getSource()) {
				ctrl.setInput(c);
				return;
			}
		}

		for(int c = 0; c<pMain.getComponentCount(); c++) {
			if(pMain.getComponent(c) == e.getSource()) {
				ctrl.setInput(c);
				return;
			}
		}

	}

}
