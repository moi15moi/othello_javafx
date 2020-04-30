package othello.modeles.Partie;

import java.util.List;

import javafx.scene.paint.Color;

public interface GrilleLectureSeule {
	
	JetonLectureSeule[][] getJetons();
	boolean[][] getCoupPossibles();

}
