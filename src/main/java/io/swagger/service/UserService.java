package io.swagger.service;

import io.swagger.model.SearchUserInfoResponse;
import io.swagger.model.UserInfoGetObject;

import java.io.IOException;

public interface UserService {
    public SearchUserInfoResponse getUsers(String codiceFisccale, Integer page, Integer size) throws IOException;

}
