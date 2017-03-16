package pl.thewalkingcode;

import pl.thewalkingcode.model.Company;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class CompaniesController {

    private Set<Company> companies = new HashSet<>();

    public CompaniesController() {
        Company company = new Company();
        company.setCode("FP");
        company.setFullName("Future Processing");
        company.setPrice("13.001");
        companies.add(company);
    }

    public Set<Company> getCompanies() {
        return companies;
    }

}
