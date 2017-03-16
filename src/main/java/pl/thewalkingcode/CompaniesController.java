package pl.thewalkingcode;

import pl.thewalkingcode.model.Company;
import pl.thewalkingcode.util.CompaniesProducer;

import javax.enterprise.context.ApplicationScoped;
import java.util.Set;

@ApplicationScoped
public class CompaniesController {

    private Set<Company> companies;

    public CompaniesController() {
        companies = CompaniesProducer.createCompanies();
    }

    public Set<Company> getCompanies() {
        return companies;
    }

}
