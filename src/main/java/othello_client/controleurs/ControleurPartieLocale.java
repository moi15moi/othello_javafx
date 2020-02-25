package othello_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import othello.modeles.PartieLocale.PartieLocale;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.afficheurs.AfficheurPartieLocale;
import othello_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale <V extends VuePartieLocale, A extends AfficheurPartieLocale<V>> extends ControleurModeleVue<PartieLocaleLectureSeule, PartieLocale, V, A> {
	@Override
	public void demarrer() {
		J.appel(this);
		
	}
}
