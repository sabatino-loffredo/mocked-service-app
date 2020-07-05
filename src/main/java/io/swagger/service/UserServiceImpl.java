package io.swagger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.SearchUserInfoGetObject;
import io.swagger.model.SearchUserInfoResponse;
import io.swagger.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public SearchUserInfoResponse getUsers(Integer page, Integer size) throws IOException {
        SearchUserInfoResponse searchUserInfoResponse = objectMapper.readValue(MockedData.usersMockedData, SearchUserInfoResponse.class);
        if(page != null && size != null) {
            List<SearchUserInfoGetObject> searchUserInfoGetObjectList = searchUserInfoResponse.getResults();
            int listSize = searchUserInfoGetObjectList.size();
            int start = page * size - size;
            int stop = (page * size) > listSize ? listSize : page * size;
            double pages = Math.ceil(listSize/(size * 1.0));
            searchUserInfoResponse.setPages((int)pages);
            searchUserInfoResponse.setResults(searchUserInfoGetObjectList.subList(start, stop));
        }
        return searchUserInfoResponse;
    }
}
