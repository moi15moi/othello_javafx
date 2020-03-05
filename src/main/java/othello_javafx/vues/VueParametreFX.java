package othello_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import othello_client.vues.VueParametre;
import othello_javafx.commandes.Cliquer.Cliquer;
import othello_javafx.commandes.Cliquer.CliquerPourEnvoi;
import othello_javafx.vues.composants.ButtonPersonnalise;
import othello_javafx.vues.composants.Textbox;




public class VueParametreFX implements VueParametre, Initializable {

	
	@FXML
	private ButtonPersonnalise buttonPersonnalise;
	
	@FXML
	private Textbox couleurFondEcran;
	
	@FXML
	private VBox conteneurPrincipal;

	private CliquerPourEnvoi cliquerPourEnvoi;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(buttonPersonnalise);
		DoitEtre.nonNul(conteneurPrincipal);
		DoitEtre.nonNul(couleurFondEcran);
		
	}


	@Override
	public void installerCapteursEvenementsUsagers() {
		J.appel(this);
		
		buttonPersonnalise.installerListenersPourAnimation();
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		cliquerPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Cliquer.class);

	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		buttonPersonnalise.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String couleurDesireeChaine = couleurFondEcran.getText();
				
				try {
					
					
					Color couleurDesiree = Color.valueOf(couleurDesireeChaine);
								
					cliquerPourEnvoi.setCouleurFondEcran(couleurDesiree);
					
					cliquerPourEnvoi.envoyerCommande();
					
				}catch(Exception e) {
			
					Erreur.avertissement("Couleur inconnue: " + couleurDesireeChaine + "   " +  e.getMessage());
				}
			}
		});
		
	}


	@Override
	public void afficherCouleurFondEcran(Color couleurFondEcran) {
		J.appel(this);
				
		conteneurPrincipal.setStyle("-fx-background-color:rgb(" + (int) ( couleurFondEcran.getRed() * 255) + "," + (int) (couleurFondEcran.getGreen() * 255) + "," + (int) (couleurFondEcran.getBlue() * 255) + ");");

		conteneurPrincipal.applyCss();	
	}

	
}
