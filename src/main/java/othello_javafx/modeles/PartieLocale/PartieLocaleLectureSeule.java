package othello_javafx.modeles.PartieLocale;

import commun.modeles.ModeleLectureSeule;
import othello.enumerations.Couleur;
import othello.modeles.Grille.GrilleLectureSeule;

public interface PartieLocaleLectureSeule extends ModeleLectureSeule { 

	 GrilleLectureSeule getGrille();
	 Couleur getCouleurCourante();

}



