package othello_javafx.vues;

import java.awt.Color;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import othello_client.vues.VuePartieLocale;
import othello_javafx.vues.composants.ButtonPersonnalise;
import othello_javafx.vues.composants.ConteneurEntetes;
import othello_javafx.vues.composants.ConteneurGrille;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {

	
	@FXML
	private ButtonPersonnalise buttonPersonnalise;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);


		DoitEtre.nonNul(buttonPersonnalise);
	}

	@Override
	public void afficherCouleur(Color couleur) {
		
		buttonPersonnalise.afficherCouleur(couleur);
		
		
	}
	

}
