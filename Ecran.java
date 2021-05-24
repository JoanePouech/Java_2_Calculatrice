import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ecran extends JPanel {
	
	// JLabel contenant l'affichage de l'écran
	JLabel affichage = new JLabel();
	
	// Constructeur sans paramètre, non utilisé mais obligatoire par défaut
	public Ecran() {
		this.setPreferredSize(new Dimension(220,30));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		affichage.setFont(new Font ("Comics sans MS",Font.BOLD,20));
		this.setLayout(new BorderLayout());
		this.add(affichage, BorderLayout.EAST);	
	}
	
	// Constructeur: paramètres du JPanel + affectation de la valeur à afficher
	public Ecran(String valeur) {
		this.setPreferredSize(new Dimension(220,30));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		affichage.setText(valeur);
		affichage.setFont(new Font ("Comics sans MS",Font.BOLD,20));
		this.setLayout(new BorderLayout());
		this.add(affichage, BorderLayout.EAST);
	}
	
	// Méthode permettant de réaffecter la valeur d'affichage et rafraîchir l'affichage depuis la Classe Fenêtre
	public void setAffichage (String valeur) {
		affichage.setText(valeur);
		affichage.repaint();
	}
	
}
