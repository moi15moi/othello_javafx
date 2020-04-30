package othello_client.afficheurs;

import javafx.scene.paint.Color;
import othello.modeles.Parametre.ParametreLectureSeule;
import commun.debogage.J;
import commun_client.mvc.Afficheur;
import othello_client.vues.VueParametre;


public abstract class AfficheurParametre <V extends VueParametre> extends Afficheur<ParametreLectureSeule, V> {
	
	@Override
	public void initialiserAffichage(ParametreLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		vue.installerCapteursEvenementsUsagers();
		
	}
	
	@Override
	public void rafraichirAffichage(ParametreLectureSeule partieLectureSeule, VueParametre vue) {
		J.appel(this);

		Color couleurFondEcran = partieLectureSeule.getCouleurFondEcran();
		
		if (couleurFondEcran != null) {
			vue.afficherCouleurFondEcran(couleurFondEcran);
		}
		
	}
}
