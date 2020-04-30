package othello_client.afficheurs;

import othello.modeles.PartieReseau.PartieReseauLectureSeule;
import othello_client.vues.VuePartieReseau;

public abstract class   AfficheurPartieReseau<V extends VuePartieReseau>

                extends AfficheurPartie<PartieReseauLectureSeule, V>  {

}
