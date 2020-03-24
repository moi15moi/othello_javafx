package othello.modeles.Colonne;

import commun.debogage.J;
import othello.enumerations.Couleur;
import othello.modeles.Jeton.Jeton;
import othello.modeles.Jeton.JetonLectureSeule;
import static othello_javafx.Constantes.*;

public class Colonne implements ColonneLectureSeule {

	private Jeton[] jetons = new Jeton[HAUTEUR_GRILLE];

	public void ajouterJeton(int indiceLigne, Couleur couleur) {
		J.appel(this);

		Jeton jeton = new Jeton();

		jeton.initialiser(couleur);

		jetons[indiceLigne] = jeton;

	}

	@Override
	public JetonLectureSeule[] getJetons() {
		J.appel(this);

		JetonLectureSeule[] jetonsLectureSeule = new JetonLectureSeule[8];

		for (int i = 0; i < this.jetons.length; i++) {
			jetonsLectureSeule[i] = this.jetons[i];
		}

		return jetonsLectureSeule;
	}
}
