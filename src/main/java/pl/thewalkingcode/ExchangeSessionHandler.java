package pl.thewalkingcode;

import pl.thewalkingcode.model.Company;
import pl.thewalkingcode.util.CompanyMapper;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Named
@Singleton
public class ExchangeSessionHandler {

    @EJB
    private MyTimerService myTimerService;

    @EJB
    private CompaniesController companiesController;

    private final Logger LOG = Logger.getLogger(this.getClass().getName());
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

    @Schedule(second="*/30", minute="*",hour="*", persistent=false)
    public void changeRating() {
        Set<Company> companyList = companiesController.refreshCompanies();
        LOG.info(myTimerService.getCurrentTime());
        LOG.info(companiesController.getCompanies().toString());
        for(Company c : companyList) {
            LOG.info(c.getFullName() + " " + c.getPrice());
        }
        sendToAllConnectedSessions(createMessage());
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