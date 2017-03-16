package pl.thewalkingcode.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pl.thewalkingcode.model.Company;

import java.util.Date;
import java.util.Set;

public class CompanyMapper {

    public static String listToJson(Set<Company> companyList) {
        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("companies", gson.toJsonTree(companyList));
        jsonObject.add("time", gson.toJsonTree(new Date().toString()));

        return gson.toJson(jsonObject);
    }

}
