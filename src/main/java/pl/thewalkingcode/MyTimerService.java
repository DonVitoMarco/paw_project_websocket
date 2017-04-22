package pl.thewalkingcode;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class MyTimerService {

    public String getCurrentTime() {
        return "GetCurrentTime : " + System.currentTimeMillis();
    }

}
