package othello.messages.transmettre_coup;

import commun.messages.MessageRecu;

public interface TransmettreCoupRecu extends MessageRecu {
	
	int getIndiceColonne();
	int getIndiceLigne();
}
