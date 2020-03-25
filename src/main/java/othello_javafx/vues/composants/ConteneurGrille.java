package othello_javafx.vues.composants;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import javafx.beans.NamedArg;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import othello.enumerations.Couleur;
import static othello_javafx.Constantes.*;

public class ConteneurGrille extends VBox {

	private Color couleurBlanc;
	private Color couleurNoir;

	public ConteneurGrille(@NamedArg("couleurBlanc") String couleurBlanc, @NamedArg("couleurNoir") String couleurNoir) {
		super();
		J.appel(this);

		if (couleurBlanc != null && !couleurBlanc.isEmpty()) {
			this.couleurBlanc = Color.valueOf(couleurBlanc);
		}

		if (couleurNoir != null && !couleurNoir.isEmpty()) {
			this.couleurNoir = Color.valueOf(couleurNoir);
		}
	}

	public void creerGrille() {
		J.appel(this);

		this.getStyleClass().add("conteneurGrille");

		VBox.setVgrow(this, Priority.ALWAYS);

		for (int indiceColonne = 0; indiceColonne < LARGEUR_GRILLE; indiceColonne++) {

			this.getChildren().add(new ConteneurLigne(indiceColonne, couleurBlanc, couleurNoir));
		}
		
		ajouterJetonInitial();
	}
	
	public void ajouterJetonInitial() {
		afficherJeton(3, 3, Couleur.BLANC);
		afficherJeton(4, 3, Couleur.NOIR);
		afficherJeton(3, 4, Couleur.NOIR);
		afficherJeton(4, 4, Couleur.BLANC);
	}

	public void afficherJeton(int indiceColonne, int indiceLigne, Couleur couleur) {
		J.appel(this);

		if (siIndiceRangeeValide(indiceLigne)) {

			ConteneurLigne conteneurLigne = getConteneurLigne(indiceColonne);
			conteneurLigne.afficherJeton(indiceLigne, couleur);
		}
	}

	private boolean siIndiceRangeeValide(int indiceRangee) {
		J.appel(this);

		return indiceRangee >= 0 && indiceRangee < this.getChildren().size();
	}

	private ConteneurLigne getConteneurLigne(int indiceColonne) {
		J.appel(this);

		return (ConteneurLigne) this.getChildren().get(indiceColonne);
	}

	public void installerCapteursJouerIci() {
		J.appel(this);

		for (ConteneurLigne conteneurLigne : conteneurLigne()) {

			conteneurLigne.installerCapteursJouerIci();
		}
	}

	private List<ConteneurLigne> conteneurLigne() {
		J.appel(this);

		List<ConteneurLigne> conteneurLigne = new ArrayList<>();

		for (Node enfant : this.getChildren()) {

			conteneurLigne.add((ConteneurLigne) enfant);
		}

		return conteneurLigne;
	}

	public void obtenirJouerIciPourEnvoi() {
		J.appel(this);

		for (ConteneurLigne conteneurLigne : conteneurLigne()) {

			conteneurLigne.obtenirJouerIciPourEnvoi();
		}
	}

	public void verifierCommandesPossibles() {
		J.appel(this);
		
		for (ConteneurLigne conteneurLigne : conteneurLigne()) {

			conteneurLigne.verifierCommandesPossibles();
		}

	}
}
