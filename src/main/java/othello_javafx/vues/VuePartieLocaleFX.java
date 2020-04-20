package othello_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import othello.enumerations.Couleur;
import othello_client.vues.VuePartieLocale;
import othello_javafx.vues.composants.ConteneurEntetes;
import othello_javafx.vues.composants.ConteneurGrille;
import javafx.fxml.Initializable;
import static othello_javafx.Constantes.*;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {

    @FXML
    private Text nomJoueurUn, nomJoueurDeux;
    
    @FXML
    private Text conteneurNomJoueurUn, conteneurNomJoueurDeux;
    
    @FXML
    private ConteneurGrille conteneurGrille;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
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

		//conteneurGrille.verifierCommandesPossibles();
		
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
		
		Color nom = new Color(1, 1, 0, 1);

		switch (couleurCourante) {

		case BLANC:
			nomJoueurUn.setStyle("-fx-background-color:rgb(" + (int) (nom.getRed() * 255) + ","
					+ (int) (nom.getGreen() * 255) + "," + (int) (nom.getBlue() * 255) + ");");

			nomJoueurUn.applyCss();
			
			nomJoueurUn.setOpacity(1);
			
			
			break;
		case NOIR:
			nomJoueurDeux.setStyle("-fx-background-color:rgb(" + (int) (nom.getRed() * 255) + ","
					+ (int) (nom.getGreen() * 255) + "," + (int) (nom.getBlue() * 255) + ");");

			nomJoueurDeux.applyCss();
			
			nomJoueurUn.setOpacity(0.5);

			break;
		}
		
	}

}
