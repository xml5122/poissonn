package com.poissonn.dao;

import com.poissonn.dto.PoissonnUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoissonnUserMapper {

    int insert(PoissonnUserDto record);


    void insertUser(PoissonnUserDto dto);

    List<PoissonnUserDto> queryByParams(String username, String name);

    void deleteUserById(Integer id);
}