package othello_client.vues;

import commun_client.mvc.Vue;
import javafx.scene.paint.Color;

public interface VueParametre extends Vue{
	
	void afficherCouleurFondEcran(Color couleurFondEcran);	
	
	void installerCapteursEvenementsUsagers();
	
}

