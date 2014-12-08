package fr.eisti.yushaofeng;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Global implements Executeur {
	static void a(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) throws Exception {
		a(" ");
		a("-------------------------------");
		a(" Exemple destine aux ADEO 2014 ");
		a("-------------------------------");
		a("\nB.M.G. Version 2014 Automne ");

		a("\nligne de commande: ");
		for (int w = 0; w < args.length; w++) {
			a("\t" + w + "\t" + args[w]);
		}

		theAppli = new Global();
		theAppli.faireIHM();
		theAppli.myGo();
	}

	static Global theAppli;

	void myGo() throws Exception {
		theFrame1.setVisible(true);
	}

	public void faireMission(int noMission) {
		try {
			switch (noMission) {
			/* --- */// traiter l'identification
			case 01: {
				theFrame1.setVisible(false);
				Thread.sleep(5000);
				theFrame2.setVisible(true);
			}
				break;

			/* --- */// menu 'File'

			case 19: {
				System.exit(0);
			}

			/* --- */// menu 'Help'

			case 91: {
			}
				break;
			case 92: {
			}
				break;
			case 93: {
			}
				break;

			/* --- */// ???

			default: {
				a("\tMISSION INCONNUE !! " + noMission);
			}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	void faireIHM() throws Exception {
		theName.add(askName);
		theName.add(sayName);
		theFrame1.add(theName, BorderLayout.NORTH);
		thePwd.add(askPwd);
		thePwd.add(sayPwd);
		theFrame1.add(thePwd, BorderLayout.CENTER);
		theFrame1.add(theGoNoGo, BorderLayout.SOUTH);
		theFrame1.setSize(600, 250);
		theFrame1.validate();
		theFrame1.setVisible(true);

		/* --- */

		theFrame2.setMenuBar(theBar);
		theBar.add(theFile);
		theBar.add(theEdit);
		theBar.add(theHelp);
		theFile.add(theQuit);
		theHelp.add(theJavadoc);
		theHelp.add(theAPropos);
		theHelp.add(theAide);
		theFrame2.setSize(800, 300);
		theFrame2.validate();
	}

	MyFrame theFrame1 = new MyFrame("Identifiez-vous !");
	Panel theName = new Panel();
	Label askName = new Label("Votre nom ?");
	TextField sayName = new TextField(40);
	Panel thePwd = new Panel();
	Label askPwd = new Label("Votre mot de passe ?");
	TextField sayPwd = new TextField(40);
	MyButton theGoNoGo = new MyButton(this, 01, "Suite");

	MyFrame theFrame2 = new MyFrame("Travaillez !");
	MenuBar theBar = new MenuBar();
	Menu theFile = new Menu("File");
	MyMenuItem theQuit = new MyMenuItem(this, 19, "Quitter");
	Menu theEdit = new Menu("Edit");
	Menu theHelp = new Menu("Help");
	MyMenuItem theJavadoc = new MyMenuItem(this, 91, "Javadoc");
	MyMenuItem theAide = new MyMenuItem(this, 92, "Aide");
	MyMenuItem theAPropos = new MyMenuItem(this, 93, "APropos");
}
