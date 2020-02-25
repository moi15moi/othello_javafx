package othello_client.vues;

import commun_client.mvc.Vue;
import javafx.fxml.Initializable;

public interface VuePartieLocale extends Vue{
	void creerGrille(int largeur, int hauteur);
	
}

