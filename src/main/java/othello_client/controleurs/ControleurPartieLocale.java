package othello_client.controleurs;

import othello.modeles.PartieLocale.PartieLocale;
import othello.modeles.PartieLocale.PartieLocaleLectureSeule;
import othello_client.afficheurs.AfficheurPartieLocale;
import othello_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale, 
                                             A extends AfficheurPartieLocale<V>>

                extends ControleurPartie<PartieLocaleLectureSeule, 
                                         PartieLocale, 
                                         V, 
                                         A> {
	
}
