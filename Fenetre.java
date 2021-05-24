import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	// Chiffres d'affichage (String) et de calcul (double, char)
	String valeur = "0";
	double calcul, memoireCalcul=0;
	char signe;
	
	// Conteneur pan = clavier + écran
	JPanel pan = new JPanel();
	Clavier clavier = new Clavier();
	Ecran ecran = new Ecran(valeur);	

	// Constructeur
	public Fenetre () {	
		// Création de la fenêtre
		this.setTitle("Calculette");
		this.setSize(250,275);
		this.setLocation(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan.add(ecran);
		pan.add(clavier);	
		this.setContentPane(pan);
		this.setVisible(true);
		// Affectation des actions des boutons
		for (int i=0 ; i<17 ; i++) {
			if (i<10) {clavier.getTouche(i).addActionListener(new ToucheChiffre());}
			else if (i==10) {clavier.getTouche(i).addActionListener(new TouchePoint());}
			else if (i==11) {clavier.getTouche(i).addActionListener(new ToucheEgal());}
			else if (i==12) {clavier.getTouche(i).addActionListener(new ToucheC());}
			else {clavier.getTouche(i).addActionListener(new ToucheOperateur());}
		}
	}
	
	// Action Boutons touche[0] à touche[9] (1,2,3,4,5,6,7,8,9,0)  
	class ToucheChiffre implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Chiffre"); // Affichage console pour vérification uniquement
			if (valeur == "0") {valeur = e.getActionCommand();}
			else {valeur = valeur.concat(e.getActionCommand());}
			ecran.setAffichage(valeur);
		}
	}
	
	// Action Bouton touche[10] (.)  
	class TouchePoint implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Point"); // Affichage console pour vérification uniquement
			if (!valeur.contains(".")){valeur = valeur.concat(e.getActionCommand());}
			ecran.setAffichage(valeur);
		}		
	}
	
	// Action Bouton touche[11] (=)  
	class ToucheEgal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Egal"); // Affichage console pour vérification uniquement
			calcul = Double.valueOf(valeur);
			if (memoireCalcul==0) {memoireCalcul=calcul;}
			else {
				switch (signe) {
				case '+' : 
					memoireCalcul = memoireCalcul + calcul;
					valeur = Double.toString(memoireCalcul);
					break;
				case '-' : 
					memoireCalcul = memoireCalcul - calcul;
					valeur = Double.toString(memoireCalcul);
					break;
				case '*' : 
					memoireCalcul = memoireCalcul * calcul;
					valeur = Double.toString(memoireCalcul);
					break;
				case '/' : 
					if (calcul == 0) {valeur = "erreur division par 0";}
					else {memoireCalcul = memoireCalcul / calcul; valeur = Double.toString(memoireCalcul);}
					break;
				}
			}
			ecran.setAffichage(valeur);
			valeur = "0";
			signe = '0';
		}		
	}
	// Action Bouton touche[12] (C)  
	class ToucheC implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Touche C"); // Affichage console pour vérification uniquement
			valeur = "0";
			calcul = 0;
			memoireCalcul = 0;
			signe = '0';
			ecran.setAffichage(valeur);
		}	
	}
	
	// Action Bouton touche[13] à touche[16] (+,-,*,/)  
	class ToucheOperateur implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Signe"); // Affichage console pour vérification uniquement
			calcul = Double.valueOf(valeur);
			if (memoireCalcul==0) {memoireCalcul=calcul;}
			else {
				switch (signe) {
				case '+' : 
					memoireCalcul = memoireCalcul + calcul;
					valeur = Double.toString(memoireCalcul);
					break;
				case '-' : 
					memoireCalcul = memoireCalcul - calcul;
					valeur = Double.toString(memoireCalcul);
					break;
				case '*' : 
					memoireCalcul = memoireCalcul * calcul;
					valeur = Double.toString(memoireCalcul);
					break;
				case '/' : 
					if (calcul == 0) {valeur = "erreur division par 0";}
					else {memoireCalcul = memoireCalcul / calcul; valeur = Double.toString(memoireCalcul);}
					break;
				}
			}
			ecran.setAffichage(valeur);
			signe = e.getActionCommand().charAt(0);
			valeur = "0";
		}	
	}	
}


