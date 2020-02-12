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
		
		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.show();
		
	}
	
	private Scene creerScenePrincipale() {
		J.appel(this);
		
		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PARAMETRE_FXML, CHEMIN_CHAINES, CHEMIN_PARAMETRE_CSS);
		
		//À ajouter dans le futur fichier parametre
		
		Scene scene = chargeur.nouvelleScene(600, 400);
		
		ComboBox combo = (ComboBox) scene.lookup("#couleurPiece");
		
		combo.getItems().addAll("Noir/Blanc", "Noir/Rouge", "Noir/Bleu", "Blanc/Rouge", "Blanc/Bleu");
		
		combo = (ComboBox) scene.lookup("#couleurPlateau");
		
		combo.getItems().addAll("Blanc", "Noir", "Bleu", "Rouge", "Bleu", "Vert");
		
 		DoitEtre.nonNul(scene);
		
		return scene;
	}
	
	@Override
	public void stop() {
		J.appel(this);
	}
}