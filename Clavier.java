import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Clavier extends JPanel {
	
	// Conteneurs et boutons
	JPanel chiffres = new JPanel(); // pour boutons [0] à [11]
	JPanel operations = new JPanel(); // pour boutons [12] à [16]
	JButton[] touche = new JButton[17];
	String valeurTouches[] = {"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/"};

	public Clavier() {		
		
		// Déclaration et initialisation des 17 boutons
		for (int i=0 ; i < valeurTouches.length ; i++) {
			touche[i] = new JButton(valeurTouches[i]);
		};
		
		// Organisation du JPanel chiffres
		GridLayout glChiffres = new GridLayout(4,3,5,5);
		chiffres.setLayout(glChiffres);
		chiffres.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
		for (int i=0; i<12 ; i++) {
			chiffres.add(touche[i]);
		}
		
		// Organisation du JPanel operations
		touche[12].setForeground(Color.RED);
		GridLayout glOperations = new GridLayout(5,1,5,5);
		operations.setLayout(glOperations);
		operations.setBorder(BorderFactory.createEmptyBorder(5,5,0,0));
		for (int i=12; i<17 ; i++) {
			operations.add(touche[i]);
		}		
		
		// Organisation du clavier
		this.setPreferredSize(new Dimension(220,190));
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(chiffres);
		this.add(operations);
	}
	
	// Méthode pour récupérer un bouton particulier et son contenu dans la Classe Fenêtre
	public JButton getTouche (int i) {
		return this.touche[i];
	}
}



