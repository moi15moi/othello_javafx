package othello_javafx.vues;

import static othello_javafx.Constantes.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import othello_client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import othello_client.commandes.nouvelle_partie_reseau.NouvellePartieReseauPourEnvoi;
import othello_client.vues.*;
import othello_javafx.commandes.nouvelle_partie.NouvellePartieLocale;
import othello_javafx.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import othello_javafx.commandes.ouvrir_parametres.OuvrirParametres;
import othello_javafx.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import othello_javafx.commandes.quitter.Quitter;
import othello_javafx.commandes.quitter.QuitterPourEnvoi;
import othello_client.commandes.sauvegarder_partie.SauvegarderPartie;
import othello_client.commandes.sauvegarder_partie.SauvegarderPartiePourEnvoi;

public class VuePrincipaleFX implements VuePrincipale, Initializable {
	
	@FXML
	MenuItem menuNouvellePartieLocale, menuNouvellePartieReseau, menuParametres, menuQuitter, menuSauvegarderPartieLocale;
	
	@FXML
	VBox conteneurPartie;
	
	QuitterPourEnvoi quitterPourEnvoi;
	OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	NouvellePartieReseauPourEnvoi nouvellePartieReseauPourEnvoi;
	SauvegarderPartiePourEnvoi sauvegarderPartiePourEnvoi;


	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		nouvellePartieLocalePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		nouvellePartieReseauPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieReseau.class);
		sauvegarderPartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(SauvegarderPartie.class);

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
		
		menuNouvellePartieLocale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				nouvellePartieLocalePourEnvoi.envoyerCommande();
			}
		});
		
	
		menuNouvellePartieReseau.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				nouvellePartieReseauPourEnvoi.envoyerCommande();
			}
		});
		
		menuSauvegarderPartieLocale.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				File fichierChoisi = DialogueModal.ouvrirDialogueFichiers();

				if(fichierChoisi != null) {

					String cheminDansHome = Systeme.cheminDansHome(fichierChoisi);

					sauvegarderPartiePourEnvoi.setCheminDansHome(cheminDansHome);
					sauvegarderPartiePourEnvoi.envoyerCommande();
				}
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuNouvellePartieReseau);
		DoitEtre.nonNul(menuParametres);
		DoitEtre.nonNul(menuQuitter);
		DoitEtre.nonNul(menuSauvegarderPartieLocale);

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
	
	public VuePartieReseauFX creerVuePartieReseau() {
		J.appel(this);

		ChargeurDeVue<VuePartieReseauFX> chargeur = new ChargeurDeVue<VuePartieReseauFX>(CHEMIN_PARTIE_RESEAU_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_RESEAU_CSS);
		
		VuePartieReseauFX vuePartieReseau = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieReseau;
	}
	
	public VueSauvegardesFX creerVueSauvegardes() {
		J.appel(this);

		ChargeurDeVue<VueSauvegardesFX> chargeur = new ChargeurDeVue<VueSauvegardesFX>(CHEMIN_VUE_SAUVEGARDES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_VUE_SAUVEGARDES_CSS);
		
		VueSauvegardesFX vueSauvegardes = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vueSauvegardes;
	}


	@Override
	public void verifierCommandesPossibles() {
		// TODO Auto-generated method stub
		
	}
	

}
