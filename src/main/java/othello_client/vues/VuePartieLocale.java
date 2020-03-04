package othello_client.vues;

import commun_client.mvc.Vue;
import java.awt.Color;

public interface VuePartieLocale extends Vue{
	
	void afficherCouleur(Color couleur);
	
	void installerCapteursEvenementsUsagers();
	
}

