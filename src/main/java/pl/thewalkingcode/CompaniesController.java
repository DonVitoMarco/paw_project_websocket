package pl.thewalkingcode;

import pl.thewalkingcode.model.Company;
import pl.thewalkingcode.util.CompaniesProducer;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Set;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.math.BigDecimal.ROUND_UP;

@Singleton
public class CompaniesController {

    private Set<Company> companies;

    public CompaniesController() {
        companies = CompaniesProducer.createCompanies();
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public Set<Company> refreshCompanies() {
        Random r = new Random();
        for (Company c : companies) {
            double changeValue = (0.1) * r.nextDouble();
            boolean change = r.nextBoolean();
            BigDecimal oldPrice = c.getPrice();
            changeRating(c, changeValue, change);
            BigDecimal newPrice = c.getPrice();
            changeLevelInfo(c, oldPrice, newPrice);
        }
        return companies;
    }

    private void changeRating(Company c, double changeValue, boolean change) {
        BigDecimal newPrice = c.getPrice();
        BigDecimal newRandom = new BigDecimal(changeValue).setScale(2, ROUND_UP);
        if (change) {
            newPrice = newPrice.add(newRandom);
        } else {
            BigDecimal newSubtractPrice = newPrice.subtract(newRandom);
            if (newSubtractPrice.compareTo(BigDecimal.ZERO) != -1) {
                newPrice = newSubtractPrice;
            }
        }
        newPrice = newPrice.setScale(2, ROUND_UP);
        c.setPrice(newPrice);
    }

    private void changeLevelInfo(Company c, BigDecimal oldPrice, BigDecimal newPrice) {
        c.setChangeToUp(newPrice.compareTo(oldPrice));
    }

}
