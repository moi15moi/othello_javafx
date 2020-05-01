package othello.modeles.PartieLocale;


import commun.debogage.J;
import othello.enumerations.Couleur;
import othello.modeles.Partie.GrilleLectureSeule;
import othello.modeles.Partie.Partie;

public class PartieLocale extends Partie<PartieLocaleLectureSeule>
implements PartieLocaleLectureSeule { 
	
	public PartieLocale() {
		super();
		J.appel(this);
		
	}
	
	public boolean siInitialisee() {
		J.appel(this);
		
		return getGrille() != null && getCouleurCourante() != null;
	}

}
