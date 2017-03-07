package pl.thewalkingcode;

import javax.enterprise.context.ApplicationScoped;
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

    @OnOpen
    public void onConnectionOpen(Session session) {
        LOG.info("Connection opened : " + session.getId());
    }

    @OnMessage
    public void handleMessage(String message) {
        LOG.info("Handle message : " + message);
    }

    @OnClose
    public void onConnectionClose(Session session) {
        LOG.info("Connection closed : " + session.getId());
    }

}
