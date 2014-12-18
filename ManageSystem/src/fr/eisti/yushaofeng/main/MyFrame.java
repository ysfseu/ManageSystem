package fr.eisti.yushaofeng.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

class MyFrame extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void windowActivated(WindowEvent evt) {
	}

	public void windowDeactivated(WindowEvent evt) {
	}

	public void windowIconified(WindowEvent evt) {
	}

	public void windowDeiconified(WindowEvent evt) {
	}

	public void windowOpened(WindowEvent evt) {
	}

	public void windowClosed(WindowEvent evt) {
	}

	public void windowClosing(WindowEvent evt) {
		System.exit(-1);
	}

	MyFrame(String t) {
		super(t);
		addWindowListener(this);
	}
}

