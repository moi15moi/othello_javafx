package othello_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import othello_javafx.controleurs.ControleurPrincipalFX;
import othello_javafx.vues.VuePrincipaleFX;

import static othello_javafx.Constantes.*;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal extends Application {

	static {
		J.appel(Principal.class);

		Initialisateur.initialiser();
	}

	public static void main(String[] args) {
		J.appel(Principal.class);

		launch(args);
	}
	
	private static ClientOthello client;

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		connecterAuServeur();

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
	
	private void connecterAuServeur() {
		J.appel(this);

		URI uriServeur = null;
		
		try {

			uriServeur = new URI(ADRESSE_SERVEUR);

		} catch (URISyntaxException e) {
			
			Erreur.fatale("L'adresse du serveur est mal formée: " + ADRESSE_SERVEUR, e);
		}

		connecterAuServeur(uriServeur);
	}

	private void connecterAuServeur(URI uriServeur) {
		J.appel(this);

		client = new ClientOthello(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			client.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
	
	public static boolean siConnecteAuServeur() {
		J.appel(Principal.class);
		
		return client != null && client.isOpen();
	}
}
