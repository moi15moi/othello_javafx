package othello_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import othello.enumerations.Couleur;
import othello_client.vues.VuePartie;
import othello_client.vues.VuePartieLocale;
import othello_javafx.vues.composants.ConteneurGrille;
import javafx.fxml.Initializable;
import static othello_javafx.Constantes.*;

public class VuePartieFX implements VuePartie, Initializable {

	@FXML
	private Text nomJoueurUn, nomJoueurDeux;

	@FXML
	private HBox conteneurNomJoueurUn, conteneurNomJoueurDeux;

	@FXML
	private ConteneurGrille conteneurGrille;
	
	@FXML
	private VBox conteneurPrincipal;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(nomJoueurUn);
		DoitEtre.nonNul(nomJoueurDeux);
		creerGrille();

	}

	@Override
	public void creerGrille() {
		J.appel(this);

		conteneurGrille.creerGrille();
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		conteneurGrille.obtenirJouerIciPourEnvoi();
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		conteneurGrille.installerCapteursJouerIci();
	}

	@Override
	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);

		conteneurGrille.afficherJeton(indiceColonne, indiceRangee, couleur);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
		//Inutile
		// conteneurGrille.verifierCommandesPossibles();

	}

	@Override
	public void afficherCoupPossible(int indiceColonne, int indiceRangee) {
		J.appel(this);

		conteneurGrille.afficherCoupPossible(indiceColonne, indiceRangee);

	}

	@Override
	public void cacherJeton(int indiceColonne, int indiceRangee) {
		J.appel(this);

		conteneurGrille.cacherJeton(indiceColonne, indiceRangee);

	}

	@Override
	public void joueurCourant(Couleur couleurCourante) {
		J.appel(this);


		switch (couleurCourante) {
		
		//Joueur02	
		case BLANC:
			conteneurNomJoueurUn.setOpacity(0.5);
			conteneurNomJoueurDeux.setOpacity(1);
			break;
		//Joueur01	
		case NOIR:
			conteneurNomJoueurUn.setOpacity(1);
			conteneurNomJoueurDeux.setOpacity(0.5);
			break;
		}

	}

	@Override
	public void afficherNomJoueurUn(String nomJoueurUn) {
		J.appel(this);
		
		this.nomJoueurUn.setText(nomJoueurUn);
	}
	
	@Override
	public void afficherNomJoueurDeux(String nomJoueurDeux) {
		this.nomJoueurDeux.setText(nomJoueurDeux);
		
	}


	@Override
	public void changerCouleurFond(Color couleur) {
		conteneurPrincipal.setStyle("-fx-background-color:rgb(" + (int) (couleur.getRed() * 255) + ","
				+ (int) (couleur.getGreen() * 255) + "," + (int) (couleur.getBlue() * 255) + ");");

		conteneurPrincipal.applyCss();
		
	}

}
