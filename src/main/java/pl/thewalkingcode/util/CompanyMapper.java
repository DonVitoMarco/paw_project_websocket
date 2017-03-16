package pl.thewalkingcode.util;

import com.google.gson.Gson;
import pl.thewalkingcode.model.Company;

import java.util.List;

public class CompanyMapper {

    public static String toJson(Company company) {
         return new Gson().toJson(company);
    }

    public static String listToJson(List<Company> companyList) {
        return new Gson().toJson(companyList);
    }

}
