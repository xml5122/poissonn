package com.poissonn.dao;

import com.poissonn.dto.PoissonnUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoissonnUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoissonnUserDto record);

    int insertSelective(PoissonnUserDto record);

    PoissonnUserDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoissonnUserDto record);

    int updateByPrimaryKey(PoissonnUserDto record);
}