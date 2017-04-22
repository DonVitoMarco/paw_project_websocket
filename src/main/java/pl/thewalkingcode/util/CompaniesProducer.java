package pl.thewalkingcode.util;

import pl.thewalkingcode.model.Company;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CompaniesProducer {

    public static Set<Company> createCompanies() {
        Set<Company> companies = new HashSet<>();
        companies.add(new Company.CompanyBuilder().fullName("Facebook").code("FB").price(new BigDecimal(5).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Ebay").code("EB").price(new BigDecimal(5).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Yahoo").code("YH").price(new BigDecimal(5).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        return companies;
    }

}