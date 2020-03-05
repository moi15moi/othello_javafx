package othello.modeles.Parametre;

import javafx.scene.paint.Color;

import commun.modeles.*;

public interface ParametreLectureSeule extends ModeleLectureSeule {

	Color getCouleurAleatoire();
	
	void setCouleurFondEcran(Color couleur);

	Color getCouleurFondEcran();
}
