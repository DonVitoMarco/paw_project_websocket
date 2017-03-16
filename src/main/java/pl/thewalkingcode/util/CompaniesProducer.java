package pl.thewalkingcode.util;

import pl.thewalkingcode.model.Company;

import java.util.HashSet;
import java.util.Set;

public class CompaniesProducer {

    public static Set<Company> createCompanies() {
        Set<Company> companies = new HashSet<>();
        companies.add(new Company.CompanyBuilder().fullName("Facebook").code("FB").price(5.00).changeToUp(false).build());
        companies.add(new Company.CompanyBuilder().fullName("Ebay").code("EB").price(5.00).changeToUp(false).build());
        companies.add(new Company.CompanyBuilder().fullName("Yahoo").code("YH").price(5.00).changeToUp(false).build());
        return companies;
    }

}