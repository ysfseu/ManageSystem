package fr.eisti.yushaofeng;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Point de menu qui sera son propre listener.
 */
class MyMenuItem extends MenuItem implements ActionListener {
	// debut de classe
	// ----------------------------------------------------------------------

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
