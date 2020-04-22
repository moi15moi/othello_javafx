package othello_javafx.modeles.Parametre;

import javafx.scene.paint.Color;

import commun.modeles.*;

public interface ParametreLectureSeule extends ModeleLectureSeule {

	Color getCouleurAleatoire();
	Color getCouleurFondEcran();
	
	String getNomJoueurUn();
	String getNomJoueurDeux();
}
