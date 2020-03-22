package othello_javafx.vues;

import static othello_javafx.Constantes.*;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.ChargeurDeVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import othello_client.vues.*;
import othello_javafx.commandes.nouvelle_partie.NouvellePartie;
import othello_javafx.commandes.nouvelle_partie.NouvellePartiePourEnvoi;
import othello_javafx.commandes.ouvrir_parametres.OuvrirParametres;
import othello_javafx.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import othello_javafx.commandes.quitter.Quitter;
import othello_javafx.commandes.quitter.QuitterPourEnvoi;

public class VuePrincipaleFX implements VuePrincipale, Initializable {
	
	@FXML
	MenuItem menuNouvellePartie, menuParametres, menuQuitter;
	
	@FXML
	VBox conteneurPartie;
	
	QuitterPourEnvoi quitterPourEnvoi;
	OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	NouvellePartiePourEnvoi nouvellePartiePourEnvoi;

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		nouvellePartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartie.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		menuQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				quitterPourEnvoi.envoyerCommande();
			}
		});
		
		menuParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirParametresPourEnvoi.envoyerCommande();
			}
		});
		
		menuNouvellePartie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				nouvellePartiePourEnvoi.envoyerCommande();
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
	}

	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML, CHEMIN_CHAINES, CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	@Override
	public void verifierCommandesPossibles() {
		// TODO Auto-generated method stub
		
	}

}
