package othello_client.vues;

import commun_client.mvc.Vue;
import javafx.fxml.Initializable;
import java.awt.Color;

public interface VuePartieLocale extends Vue{
	void creerGrille(int largeur, int hauteur);
	
	void afficherCouleur(Color couleur);
	
}

