package othello_serveur;

import commun.debogage.J;

public class ServeurOthello extends ServeurWebSocket {

	public ServeurOthello(int port) {
		super(port);
		J.appel(this);
	}

}
