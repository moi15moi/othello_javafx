package othello.modeles.Partie;

import commun.modeles.ModeleLectureSeule;
import othello.enumerations.Couleur;
import othello.modeles.Partie.GrilleLectureSeule;

public interface PartieLectureSeule 
	   extends   ModeleLectureSeule { 

	 GrilleLectureSeule getGrille();
	 Couleur getCouleurCourante();

}



