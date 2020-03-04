package othello_client.afficheurs;

import java.awt.Color;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.vues.VuePartieLocale;

public abstract class AfficheurPartieLocale <V extends VuePartieLocale> extends Afficheur<PartieLocaleLectureSeule, V> {
	
	@Override
	public void initialiserAffichage(PartieLocaleLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		
		//Couleur Button personnalisé
		Color couleur = modeleLectureSeule.getCouleur();
		vue.afficherCouleur(couleur);
		
		vue.installerCapteursEvenementsUsagers();
		
	}
}
