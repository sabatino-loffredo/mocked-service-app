package io.swagger.service;

import io.swagger.model.SearchUserInfoResponse;

import java.io.IOException;

public interface UserService {
    public SearchUserInfoResponse getUsers(Integer page, Integer size) throws IOException;
}
