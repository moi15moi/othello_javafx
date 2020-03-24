package othello_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import othello_client.afficheurs.AfficheurPartieLocale;
import othello_client.vues.VuePartieLocale;
import othello_javafx.commandes.jouer_ici.JouerIci;
import othello_javafx.commandes.jouer_ici.JouerIciRecue;
import othello_javafx.modeles.PartieLocale.PartieLocale;
import othello_javafx.modeles.PartieLocale.PartieLocaleLectureSeule;

public abstract class ControleurPartieLocale<V extends VuePartieLocale,
					       				     A extends AfficheurPartieLocale<V>> 

					extends ControleurModeleVue<PartieLocaleLectureSeule, 
											    PartieLocale, 
											    V, 
											    A> {
	
	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);
				
				modele.jouerIci(commande.getIndiceColonne(), commande.getIndiceLigne());
				
			}
			
			@Override
			public boolean siCommandePossible(JouerIciRecue commande) {
				J.appel(this);
				
				return modele.siPossibleJouerIci(commande.getIndiceColonne(), commande.getIndiceLigne());
			}
		});
	}
	
}
