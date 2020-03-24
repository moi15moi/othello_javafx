package othello.modeles.Grille;

import java.util.List;

import othello.modeles.Colonne.ColonneLectureSeule;
import othello.modeles.Jeton.JetonLectureSeule;

public interface GrilleLectureSeule {
	
	JetonLectureSeule[][] getJetons();
}
