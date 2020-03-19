package othello_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import othello.modeles.Parametre.Parametre;
import othello_client.controleurs.ControleurPrincipal;
import othello_client.vues.VueParametre;
import othello_client.vues.VuePrincipale;
import othello_javafx.afficheurs.AfficheurParametreFX;
import othello_javafx.controleurs.ControleurParametreFX;
import othello_javafx.controleurs.ControleurPartieLocaleFX;
import othello_javafx.controleurs.ControleurPrincipalFX;
import othello_javafx.vues.VueParametreFX;
import othello_javafx.vues.VuePartieLocaleFX;
import othello_javafx.vues.VuePrincipaleFX;

import static othello_javafx.Constantes.*;

public class Principal extends Application {

	static {
		J.appel(Principal.class);

		Initialisateur.initialiser();
	}

	public static void main(String[] args) {
		J.appel(Principal.class);

		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
		ChargeurDeVue<VuePrincipaleFX> chargeur = new ChargeurDeVue<VuePrincipaleFX>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PRINCIPAL_CSS);

		Scene scene = chargeur.nouvelleScene(50, 50, 2);

		fenetrePrincipale.setScene(scene);
		

		fenetrePrincipale.show();

		VuePrincipaleFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurPrincipalFX.class, vue);
		
	}	
}
