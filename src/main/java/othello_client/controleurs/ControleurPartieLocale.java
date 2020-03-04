package othello_client.controleurs;

import java.awt.Color;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import othello.modeles.PartieLocale.PartieLocale;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.afficheurs.AfficheurPartieLocale;
import othello_client.vues.VuePartieLocale;
import othello_javafx.commandes.Cliquer.Cliquer;
import othello_javafx.commandes.Cliquer.CliquerRecue;

public abstract class ControleurPartieLocale <V extends VuePartieLocale, A extends AfficheurPartieLocale<V>> extends ControleurModeleVue<PartieLocaleLectureSeule, PartieLocale, V, A> {
	@Override
	public void demarrer() {
		J.appel(this);
		
	}
	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(Cliquer.class, new RecepteurCommandeMVC<CliquerRecue>() {

			@Override
			public void executerCommandeMVC(CliquerRecue commande) {
				Color couleur = commande.getCouleurFondEcran();
				modele.cliquer(couleur);
			}

		});

	} 
	
}
