package io.swagger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.SearchUserInfoGetObject;
import io.swagger.model.SearchUserInfoResponse;
import io.swagger.model.UserInfoPutObject;
import io.swagger.model.UserRegistrationObject;
import io.swagger.util.JsonUtil;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public SearchUserInfoResponse getUsers(String username, String codiceFiscale, Integer page, Integer size) throws IOException, ParseException {
        SearchUserInfoResponse searchUserInfoResponse = JsonUtil.readMockData();

        //SearchUserInfoResponse searchUserInfoResponse = objectMapper.readValue(MockedData.usersMockedData, SearchUserInfoResponse.class);

        if (codiceFiscale != null) {
            searchUserInfoResponse.getResults().stream()
                    .filter(item -> item.getFiscalNumber().equalsIgnoreCase(codiceFiscale)).collect(Collectors.toList());
        }
        if (username != null) {
            searchUserInfoResponse.getResults().stream()
                    .filter(item -> item.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
        }
        if (page != null && size != null) {
            List<SearchUserInfoGetObject> searchUserInfoGetObjectList = searchUserInfoResponse.getResults();
            int listSize = searchUserInfoGetObjectList.size();
            int start = page * size - size;
            int stop = (page * size) > listSize ? listSize : page * size;
            double pages = Math.ceil(listSize / (size * 1.0));
            searchUserInfoResponse.setPages((int) pages);
            searchUserInfoResponse.setResults(searchUserInfoGetObjectList.subList(start, stop));
        }
        return searchUserInfoResponse;
    }

    @Override
    public void createUser(UserRegistrationObject userRegistrationObject) throws IOException, ParseException {
        JsonUtil.writeMockData(userRegistrationObject);
    }

    @Override
    public void updateUser(String username, UserInfoPutObject userInfoPutObject) throws IOException, ParseException {
        JsonUtil.updateSingleMockData(username, userInfoPutObject);
    }
}
