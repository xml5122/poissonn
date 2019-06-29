package com.poissonn.service;

import com.poissonn.dto.PoissonnUserDto;

import java.util.List;
import java.util.Map;

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
    void addUser(PoissonnUserDto dto);

    /**
     * 根据用户名搜索用户
     * @param map
     * @return
     */
    List<PoissonnUserDto> query(Map<String,String> map);

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 给权限下拉框动态赋值
     * @return
     */
    List<Map<String,String>> getRole();
}
