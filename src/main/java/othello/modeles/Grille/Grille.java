package othello.modeles.Grille;

import static othello_javafx.Constantes.*;
import commun.debogage.J;
import othello.enumerations.Couleur;
import othello.modeles.Jeton.Jeton;
import othello.modeles.Jeton.JetonLectureSeule;

public class Grille implements GrilleLectureSeule {

	private Jeton[][] jetons = new Jeton[LARGEUR_GRILLE][HAUTEUR_GRILLE];

	public void ajouterJeton(int idColonne, int indiceLigne, Couleur couleur) {
		J.appel(this);

		Jeton jeton = new Jeton();

		jeton.initialiser(couleur);

		jetons[idColonne][indiceLigne] = jeton;
	}

	@Override
	public JetonLectureSeule[][] getJetons() {
		J.appel(this);

		JetonLectureSeule[][] jetonsLectureSeule = new JetonLectureSeule[LARGEUR_GRILLE][HAUTEUR_GRILLE];

		for (int i = 0; i < this.jetons.length; i++) {

			for (int j = 0; j < this.jetons[i].length; j++) {
				jetonsLectureSeule[i][j] = this.jetons[i][j];
			}
		}

		return jetonsLectureSeule;
	}

}
