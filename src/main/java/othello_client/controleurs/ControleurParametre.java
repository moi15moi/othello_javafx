package othello_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import othello_client.afficheurs.AfficheurParametre;
import othello_client.vues.VueParametre;
import othello_javafx.modeles.Parametre.Parametre;
import othello_javafx.modeles.Parametre.ParametreLectureSeule;

public abstract class ControleurParametre <V extends VueParametre, A extends AfficheurParametre<V>> extends ControleurModeleVue<ParametreLectureSeule, Parametre, V, A> {
	
	public void demarrer() {
		J.appel(this);

	}
	
}
