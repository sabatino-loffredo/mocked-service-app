package io.swagger.util;

import io.swagger.model.AdditionalClaim;
import io.swagger.model.SearchUserInfoGetObject;
import io.swagger.model.SearchUserInfoResponse;
import io.swagger.model.UserRegistrationObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static SearchUserInfoResponse readMockData() throws IOException {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        Resource resource = new ClassPathResource("mockedData.json");

        InputStream input = resource.getInputStream();

        File file = resource.getFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listJson = ((JSONArray) ((JSONObject) obj).get("results"));
            System.out.println(listJson);

            //Iterate over employee array
            SearchUserInfoResponse users = new SearchUserInfoResponse();
            List<SearchUserInfoGetObject> list = new ArrayList<>();

            listJson.forEach(emp -> {
                SearchUserInfoGetObject user = new SearchUserInfoGetObject();

                JSONObject jsonObject = (JSONObject) emp;

                //Get employee first name
                String email = (String) jsonObject.get("email");
                System.out.println(email);
                user.setEmail(email);

                //Get employee last name
                String phone_number = (String) jsonObject.get("phone_number");
                System.out.println(phone_number);
                user.setPhoneNumber(phone_number);

                //Get employee website name
                String given_name = (String) jsonObject.get("given_name");
                System.out.println(given_name);
                user.setGivenName(given_name);

                String family_name = (String) jsonObject.get("family_name");
                System.out.println(family_name);
                user.setFamilyName(family_name);

                JSONArray additionalClaims = (JSONArray) jsonObject.get("additional_claims");

                List<AdditionalClaim> claimList = new ArrayList<>();

                additionalClaims.forEach(claim -> {
                    AdditionalClaim additionalClaim = new AdditionalClaim();

                    JSONObject claimObject = (JSONObject) claim;

                    additionalClaim.setUri((String) claimObject.get("uri"));
                    additionalClaim.setValue((String) claimObject.get("value"));
                    claimList.add(additionalClaim);
                });

                user.setAdditionalClaims(claimList);

                String fiscal_number = (String) jsonObject.get("fiscal_number");
                System.out.println(fiscal_number);
                user.setFiscalNumber(fiscal_number);

                String username = (String) jsonObject.get("username");
                System.out.println(username);
                user.setUsername(username);

                list.add(user);
            });

            users.setResults(list);
            users.setPages(-1);

            return users;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeMockData(UserRegistrationObject userRegistrationObject) throws IOException, ParseException {
        //Creating user
        JSONObject userDetails = new JSONObject();
        userDetails.put("email", userRegistrationObject.getEmail());
        userDetails.put("phone_number", userRegistrationObject.getPhoneNumber());
        userDetails.put("given_name", userRegistrationObject.getGivenName());
        userDetails.put("family_name", userRegistrationObject.getFamilyName());
        //Creating claims
        JSONArray claims = new JSONArray();
        userRegistrationObject.getAdditionalClaims().forEach(additionalClaim -> {
            JSONObject claim = new JSONObject();
            claim.put("uri", additionalClaim.getUri());
            claim.put("value", additionalClaim.getValue());
            claims.add(claim);
        });

        userDetails.put("additional_claims", claims);
        userDetails.put("fiscal_number", userRegistrationObject.getFiscalNumber());
        userDetails.put("username", userRegistrationObject.getUsername());

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        Resource resource = new ClassPathResource("mockedData.json");

        InputStream input = resource.getInputStream();

        File f = resource.getFile();

        BufferedReader reader = new BufferedReader(new FileReader(f));

        //Read JSON file
        Object obj = jsonParser.parse(reader);
        //get all users
        JSONArray listJson = ((JSONArray) ((JSONObject) obj).get("results"));

        JSONObject json = new JSONObject();
        json.put("pages", -1);
        //add user
        listJson.add(userDetails);
        json.put("results", listJson);

        //Write JSON file
        try (FileWriter file = new FileWriter(f)) {

            file.write(json.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
