package othello_javafx;

import static othello_javafx.Constantes.*;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import commun_javafx.Initialisateur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;



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
	public void start(Stage fenetrePrincipale) throws Exception{
		J.appel(this);
		
		Scene scene= creerScenePrincipale();
		
		afficherFenetre(fenetrePrincipale, scene);
		
	}
	
	private void afficherFenetre(Stage fenetrePrincipale, Scene scene) {
		J.appel(this);


		fenetrePrincipale.setScene(scene);
		
		setLargeurFenetre(fenetrePrincipale, scene.getWidth());
		setHauteurFenetre(fenetrePrincipale, scene.getHeight());
		
		fenetrePrincipale.show();

	}

	private void setHauteurFenetre(Stage fenetrePrincipale, double hauteur) {
		J.appel(this);
		
		fenetrePrincipale.setHeight(hauteur);
		fenetrePrincipale.setMinHeight(hauteur);
	}

	private void setLargeurFenetre(Stage fenetrePrincipale, double largeur) {
		J.appel(this);
		
		fenetrePrincipale.setWidth(largeur);
		fenetrePrincipale.setMinWidth(largeur);
	}
	
	private Scene creerScenePrincipale() {
		J.appel(this);
		
		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PRINCIPAL_FXML, CHEMIN_CHAINES, CHEMIN_PRINCIPAL_CSS);
		
		//À ajouter dans le futur fichier parametre
		
		Scene scene = chargeur.nouvelleScene(600, 400);
		
		//ComboBox combo = (ComboBox) scene.lookup("#couleurPiece");
		
		//combo.getItems().addAll("Noir/Blanc", "Noir/Rouge", "Noir/Bleu", "Blanc/Rouge", "Blanc/Bleu");
		
		//combo = (ComboBox) scene.lookup("#couleurPlateau");
		
		//combo.getItems().addAll("Blanc", "Noir", "Bleu", "Rouge", "Bleu", "Vert");
		
 		DoitEtre.nonNul(scene);
		
		return scene;
	}
	
	@Override
	public void stop() {
		J.appel(this);
	}
}
