package othello_client.controleurs;

import commun.debogage.J;
import commun.messages.FabriqueMessage;
import commun_client.mvc.controleurs.RecepteurMessageMVC;
import othello.messages.transmettre_coup.TransmettreCoup;
import othello.messages.transmettre_coup.TransmettreCoupPourEnvoi;
import othello.messages.transmettre_coup.TransmettreCoupRecu;
import othello.modeles.PartieReseau.PartieReseau;
import othello.modeles.PartieReseau.PartieReseauLectureSeule;
import othello_client.afficheurs.AfficheurPartieReseau;
import othello_client.vues.VuePartieReseau;
import othello_javafx.commandes.jouer_ici.JouerIciRecue;


public abstract class ControleurPartieReseau<V extends VuePartieReseau, 
                                             A extends AfficheurPartieReseau<V>>

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        V, 
                        A> {
	
	private TransmettreCoupPourEnvoi transmettreCoup;
	

	@Override
	protected void obtenirMessagesPourEnvoi() {
		super.obtenirMessagesPourEnvoi();
		
		J.appel(this);
		
		transmettreCoup = FabriqueMessage.obtenirMessagePourEnvoi(TransmettreCoup.class);
	}

	@Override
	protected void installerReceptionMessages() {
		super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(TransmettreCoup.class, new RecepteurMessageMVC<TransmettreCoupRecu>() {

			@Override
			public void recevoirMessageMVC(TransmettreCoupRecu messageRecu) {
				J.appel(this);
				
				modele.jouerIci(messageRecu.getIndiceColonne(), messageRecu.getIndiceLigne());
			}
		});
	}
	
	@Override
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		super.reagirCommandeJouerIci(jouerIciRecue);
		J.appel(this);
		
		transmettreCoup.setIndiceLigne(jouerIciRecue.getIndiceLigne());
		transmettreCoup.setIndiceColonne(jouerIciRecue.getIndiceColonne());
		transmettreCoup.envoyerMessage();
	}
}
