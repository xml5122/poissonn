package com.poissonn.service;

import com.poissonn.dto.PoissonnUserDto;

import java.util.List;

public interface UserManageService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);

    /**
     * 新增用户
     * @param dto
     * @return
     */
    Boolean addUser(PoissonnUserDto dto);

    /**
     * 根据用户名搜索用户
     * @param username
     * @return
     */
    List<PoissonnUserDto> query(String username,String name);
}
