import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ecran extends JPanel {
	
	// JLabel contenant l'affichage de l'�cran
	JLabel affichage = new JLabel();
	
	// Constructeur sans param�tre, non utilis� mais obligatoire par d�faut
	public Ecran() {
		this.setPreferredSize(new Dimension(220,30));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		affichage.setFont(new Font ("Comics sans MS",Font.BOLD,20));
		this.setLayout(new BorderLayout());
		this.add(affichage, BorderLayout.EAST);	
	}
	
	// Constructeur: param�tres du JPanel + affectation de la valeur � afficher
	public Ecran(String valeur) {
		this.setPreferredSize(new Dimension(220,30));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		affichage.setText(valeur);
		affichage.setFont(new Font ("Comics sans MS",Font.BOLD,20));
		this.setLayout(new BorderLayout());
		this.add(affichage, BorderLayout.EAST);
	}
	
	// M�thode permettant de r�affecter la valeur d'affichage et rafra�chir l'affichage depuis la Classe Fen�tre
	public void setAffichage (String valeur) {
		affichage.setText(valeur);
		affichage.repaint();
	}
	
}
