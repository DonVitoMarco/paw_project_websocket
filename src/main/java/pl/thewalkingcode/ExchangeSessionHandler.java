package pl.thewalkingcode;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.websocket.Session;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ExchangeSessionHandler {

    private Set<Session> sessions = new HashSet<>();

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public void sendToAllConnectedSessions(JsonObject message) {

    }

    public void sendToSession(Session session, JsonObject message) {

    }

}
