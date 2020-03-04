package othello_javafx.vues;

import java.awt.Color;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import othello_client.vues.VuePartieLocale;
import othello_javafx.vues.composants.ButtonPersonnalise;
import othello_javafx.vues.composants.Textbox;


public class VuePartieLocaleFX implements VuePartieLocale, Initializable {

	
	@FXML
	private ButtonPersonnalise buttonPersonnalise;
	
	@FXML
	private Textbox couleurFondEcran;
	
	@FXML
	private static VBox principal;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(buttonPersonnalise);
	}

	@Override
	public void afficherCouleur(Color couleur) {
		
		J.appel(this);
		buttonPersonnalise.afficherCouleur(couleur);
		
	}

	@Override
	public void installerCapteursEvenementsUsagers() {
		J.appel(this);
		
		buttonPersonnalise.installerListeners();
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		buttonPersonnalise.obtenirCliquerPourEnvoi();
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		buttonPersonnalise.installerCapteursCliquer();
		
	}
	
}
