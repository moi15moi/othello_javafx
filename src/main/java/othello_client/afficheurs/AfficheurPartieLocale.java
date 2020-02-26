package othello_client.afficheurs;

import java.awt.Color;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.vues.VuePartieLocale;
import othello_javafx.vues.VuePartieLocaleFX;

public abstract class AfficheurPartieLocale <V extends VuePartieLocale> extends Afficheur<PartieLocaleLectureSeule, V> {
	
	@Override
	public void initialiserAffichage(PartieLocaleLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		int largeur = modeleLectureSeule.getLargeur();
		int hauteur = modeleLectureSeule.getHauteur();
		
		//Couleur Button personnalisé
		Color couleur = modeleLectureSeule.getCouleur();
		vue.afficherCouleur(couleur);
		
	}
}
