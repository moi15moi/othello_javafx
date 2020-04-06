package othello_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.FXML;
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
    private ConteneurGrille conteneurGrille;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		J.valeurs("Hum... conteneurGrille.getStyle() est vide?", conteneurGrille.getStyle());
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

		conteneurGrille.verifierCommandesPossibles();
		
	}

}
