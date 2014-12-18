package fr.eisti.yushaofeng.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * Point de menu qui sera son propre listener.
 */
class MyMenuItem extends JMenuItem implements ActionListener {
	// debut de classe
	// ----------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Executeur theExecuteur = null;
	int theMission = -1;

	MyMenuItem(Executeur x, int n, String s) {
		super(s);
		theExecuteur = x;
		theMission = n;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		try {
			theExecuteur.faireMission(theMission);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	// ----------------------------------------------------------------------
	// fin de classe
}
