package pl.thewalkingcode;

import pl.thewalkingcode.util.CompanyMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ExchangeSessionHandler {

    @Inject
    private CompaniesController companiesController;

    private Set<Session> sessions = new HashSet<>();

    public void addSession(Session session) {
        sessions.add(session);
        sendToSession(session, createMessage());
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public String createMessage() {
        return CompanyMapper.listToJson(companiesController.getCompanies());
    }

    private void sendToAllConnectedSessions(String message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ioe) {
            sessions.remove(session);
        }
    }

}
