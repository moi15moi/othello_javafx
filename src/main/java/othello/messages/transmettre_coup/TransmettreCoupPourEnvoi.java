package othello.messages.transmettre_coup;

import commun.messages.MessagePourEnvoi;

public interface TransmettreCoupPourEnvoi extends MessagePourEnvoi {
	
	void setIndiceColonne(int indiceColonne);
	void setIndiceLigne (int indiceLigne);
}
