package pl.thewalkingcode;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.logging.Logger;

@ApplicationScoped
@ServerEndpoint("/websocket")
public class HomeWebSocketServer {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());
    private ExchangeSessionHandler exchangeSessionHandler;

    @Inject
    public HomeWebSocketServer(ExchangeSessionHandler exchangeSessionHandler) {
        this.exchangeSessionHandler = exchangeSessionHandler;
    }

    @OnOpen
    public void onConnectionOpen(Session session) {
        LOG.info("Connection opened : " + session.getId());
        exchangeSessionHandler.addSession(session);
    }

    @OnMessage
    public void handleMessage(String message) {
        LOG.info("Handle message : " + message);
    }

    @OnClose
    public void onConnectionClose(Session session) {
        LOG.info("Connection closed : " + session.getId());
        exchangeSessionHandler.removeSession(session);
    }

}
