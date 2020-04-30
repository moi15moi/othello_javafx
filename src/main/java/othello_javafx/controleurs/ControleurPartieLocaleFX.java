package othello_javafx.controleurs;

import othello_javafx.afficheurs.*;
import othello_javafx.vues.*;
import commun.debogage.J;
import othello_client.controleurs.*;

public class ControleurPartieLocaleFX extends ControleurPartieLocale<VuePartieLocaleFX, AfficheurPartieLocaleFX> {

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}

}
