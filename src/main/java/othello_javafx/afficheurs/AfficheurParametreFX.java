package othello_javafx.afficheurs;

import commun.debogage.J;
import javafx.scene.paint.Color;
import othello.modeles.Parametre.ParametreLectureSeule;
import othello_client.afficheurs.AfficheurParametre;
import othello_client.vues.VueParametre;
import othello_javafx.vues.VueParametreFX;

public class AfficheurParametreFX extends AfficheurParametre<VueParametreFX> {

	public void rafraichirAffichage(ParametreLectureSeule partieLectureSeule, VueParametre vue) {
		J.appel(this);

		Color couleurFondEcran = partieLectureSeule.getCouleurFondEcran();

		vue.afficherCouleurFondEcran(couleurFondEcran);

	}

}
