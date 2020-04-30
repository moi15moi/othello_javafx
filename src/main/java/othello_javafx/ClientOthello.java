package othello_javafx;

import java.net.URI;

import commun_javafx.ClientWebSocketFX;

public class ClientOthello extends ClientWebSocketFX {

	public ClientOthello(URI serverUri) {
		super(serverUri);
	}

}
