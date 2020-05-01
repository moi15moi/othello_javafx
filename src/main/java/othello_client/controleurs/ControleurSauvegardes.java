package othello_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import othello.modeles.sauvegardes.Sauvegardes;
import othello.modeles.sauvegardes.SauvegardesLectureSeule;
import othello_client.afficheurs.AfficheurSauvegardes;
import othello_client.vues.VueSauvegardes;

public abstract class ControleurSauvegardes<V extends VueSauvegardes, 
                                   A extends AfficheurSauvegardes<V>>

	   extends ControleurModeleVue<SauvegardesLectureSeule, 
	                               Sauvegardes,
	                               V,
	                               A> {

	@Override
	protected void demarrer() {
		J.appel(this);
		
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}
}
