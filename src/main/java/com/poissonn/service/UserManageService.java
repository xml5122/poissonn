package com.poissonn.service;

import com.poissonn.dto.PoissonnUserDto;

public interface UserManageService {

    boolean login(String username, String password);

    Boolean addUser(PoissonnUserDto dto);
}
