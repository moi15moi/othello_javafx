package othello.modeles.Grille;

import java.util.List;

import javafx.scene.paint.Color;
import othello.modeles.Jeton.JetonLectureSeule;

public interface GrilleLectureSeule {
	
	JetonLectureSeule[][] getJetons();
	boolean[][] getCoupPossibles();

}
