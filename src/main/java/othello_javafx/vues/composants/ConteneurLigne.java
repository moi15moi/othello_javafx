package othello_javafx.vues.composants;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import othello.enumerations.Couleur;
import othello_javafx.commandes.jouer_ici.JouerIciPourEnvoi;

import static othello_javafx.Constantes.*;

public class ConteneurLigne extends HBox {

	public ConteneurLigne(int indiceColonne, Color couleurBlanc, Color couleurNoir) {
		J.appel(this);

		this.getStyleClass().add("conteneurLigne");

		VBox.setVgrow(this, Priority.ALWAYS);

		for (int indiceLigne = 0; indiceLigne < HAUTEUR_GRILLE; indiceLigne++) {

			CaseAjustable caseAjustable = new CaseAjustable(couleurBlanc, couleurNoir, indiceColonne, indiceLigne);

			caseAjustable.getStyleClass().add("conteneurCase");

			HBox.setHgrow(caseAjustable, Priority.ALWAYS);

			this.getChildren().add(caseAjustable);
		}
	}

	public void afficherJeton(int indiceLigne, Couleur couleur) {
		J.appel(this);

		if (siIndiceLigneValide(indiceLigne)) {

			CaseAjustable caseAjustable = getCaseAjustable(indiceLigne);
			caseAjustable.afficherJeton(couleur);
		}
	}

	private CaseAjustable getCaseAjustable(int indiceLigne) {
		J.appel(this);

		return (CaseAjustable) this.getChildren().get(indiceLigne);
	}

	private boolean siIndiceLigneValide(int indiceLigne) {
		J.appel(this);

		return indiceLigne < this.getChildren().size();
	}

	public void obtenirJouerIciPourEnvoi() {
		J.appel(this);

		for (CaseAjustable caseAjustable : caseAjustable()) {

			caseAjustable.obtenirJouerIciPourEnvoi();
		}
	}

	private List<CaseAjustable> caseAjustable() {
		J.appel(this);

		List<CaseAjustable> caseAjustable = new ArrayList<>();

		for (Node enfant : this.getChildren()) {

			caseAjustable.add((CaseAjustable) enfant);
		}

		return caseAjustable;
	}

	public void installerCapteursJouerIci() {
		J.appel(this);

		for (CaseAjustable caseAjustable : caseAjustable()) {

			caseAjustable.installerCapteurJouerIci();
		}
	}
	
	public void verifierCommandesPossibles() {
		J.appel(this);
		
		for (CaseAjustable caseAjustable : caseAjustable()) {

			caseAjustable.verifierCommandesPossibles();
		}
	}

}
