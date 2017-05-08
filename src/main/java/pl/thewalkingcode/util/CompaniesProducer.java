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
        companies.add(new Company.CompanyBuilder().fullName("Apple").code("APL").price(new BigDecimal(4).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Samsung").code("SAM").price(new BigDecimal(4).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Amazon").code("AMA").price(new BigDecimal(6).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Alphabet").code("ALP").price(new BigDecimal(6).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Micorsoft").code("MS").price(new BigDecimal(4).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("IBM").code("IBM").price(new BigDecimal(4).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Sony").code("SY").price(new BigDecimal(3).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());
        companies.add(new Company.CompanyBuilder().fullName("Intel").code("INT").price(new BigDecimal(6).setScale(2, BigDecimal.ROUND_DOWN)).changeToUp(0).build());

        return companies;
    }

}