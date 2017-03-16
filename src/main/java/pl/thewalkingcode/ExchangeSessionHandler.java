package pl.thewalkingcode;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ExchangeSessionHandler {

    private Set<Session> sessions = new HashSet<>();

    public void addSession(Session session) {
        sessions.add(session);
        sendToSession(session, createJsonMessage());
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public JsonObject createJsonMessage() {
        JsonProvider provider = JsonProvider.provider();
        JsonObject company = provider.createObjectBuilder()
                .add("code", "FP")
                .add("name", "FutureProcessing")
                .add("price", "13.0151")
                .add("changeToUp", "false")
                .build();
        return company;
    }

    private void sendToAllConnectedSessions(JsonObject message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, JsonObject message) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ioe) {
            sessions.remove(session);
        }
    }

}
