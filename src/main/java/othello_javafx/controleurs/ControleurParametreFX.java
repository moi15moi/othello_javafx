package othello_javafx.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import javafx.scene.paint.Color;
import othello_client.controleurs.ControleurParametre;
import othello_javafx.afficheurs.AfficheurParametreFX;
import othello_javafx.vues.VueParametreFX;
import othello_javafx.commandes.Cliquer.Cliquer;
import othello_javafx.commandes.Cliquer.CliquerRecue;
import othello_javafx.commandes.changer_nom_joueur_deux.ChangerNomJoueurDeux;
import othello_javafx.commandes.changer_nom_joueur_deux.ChangerNomJoueurDeuxRecue;
import othello_javafx.commandes.changer_nom_joueur_un.ChangerNomJoueurUn;
import othello_javafx.commandes.changer_nom_joueur_un.ChangerNomJoueurUnRecue;


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

		installerRecepteurCommande(ChangerNomJoueurUn.class, new RecepteurCommandeMVC<ChangerNomJoueurUnRecue>() {

			@Override
			public void executerCommandeMVC(ChangerNomJoueurUnRecue commande) {
				J.appel(this);
				
				modele.changerNomJoueurUn(commande.getNomJoueurUn());
			}
		});
		
		installerRecepteurCommande(ChangerNomJoueurDeux.class, new RecepteurCommandeMVC<ChangerNomJoueurDeuxRecue>() {

			@Override
			public void executerCommandeMVC(ChangerNomJoueurDeuxRecue commande) {
				J.appel(this);
				
				modele.changerNomJoueurDeux(commande.getNomJoueurDeux());
			}
		});

	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void installerReceptionMessages() {
		// TODO Auto-generated method stub
		
	}
}