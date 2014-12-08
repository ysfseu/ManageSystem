package fr.eisti.yushaofeng;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Bouton qui sera son propre listener.
 */
class MyButton extends Button implements ActionListener {
	// ----------------------------------------------------------------------

	Executeur theExecuteur = null;
	int theMission = -1;

	MyButton(Executeur x, int n, String s) {
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
