package othello_javafx.modeles.PartieLocale;

import commun.modeles.ModeleLectureSeule;
import othello.modeles.Grille.GrilleLectureSeule;

public interface PartieLocaleLectureSeule extends ModeleLectureSeule { 

	 GrilleLectureSeule getGrille();
	 int getLargeur();
	 int getHauteur();
}



