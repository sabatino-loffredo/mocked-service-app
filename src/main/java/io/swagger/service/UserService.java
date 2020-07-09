package io.swagger.service;

import io.swagger.model.SearchUserInfoResponse;
import io.swagger.model.UserInfoGetObject;
import io.swagger.model.UserInfoPutObject;
import io.swagger.model.UserRegistrationObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface UserService {
    public SearchUserInfoResponse getUsers(String codiceFisccale, Integer page, Integer size) throws IOException, ParseException;
    public void createUser(UserRegistrationObject userRegistrationObject) throws IOException, ParseException;
    public void updateUser(String username, UserInfoPutObject userInfoPutObject) throws IOException, ParseException;

}
