package othello_javafx.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import javafx.scene.paint.Color;
import othello_client.controleurs.ControleurParametre;
import othello_javafx.afficheurs.AfficheurParametreFX;
import othello_javafx.vues.VueParametreFX;
import othello_javafx.commandes.Cliquer.Cliquer;
import othello_javafx.commandes.Cliquer.CliquerRecue;


public class ControleurParametreFX extends ControleurParametre<VueParametreFX, AfficheurParametreFX> {

	public void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(Cliquer.class, new RecepteurCommandeMVC<CliquerRecue>() {

			@Override
			public void executerCommandeMVC(CliquerRecue commande) {
				Color couleur = commande.getCouleurFondEcran();
				modele.setCouleurFondEcran(couleur);
			}

		});

	}
}