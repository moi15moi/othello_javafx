package othello_client.afficheurs;

import commun.debogage.J;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.vues.VuePartieLocale;

public abstract class   AfficheurPartieLocale<V extends VuePartieLocale> extends AfficheurPartie<PartieLocaleLectureSeule, V>  {
	
	@Override
	public void initialiserAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
		J.appel(this);
		
		super.rafraichirAffichage(partieLectureSeule, (V) vue);
	}

}
