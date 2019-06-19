package com.poissonn.service.imp;

import com.poissonn.dao.PoissonnUserMapper;
import com.poissonn.dto.PoissonnUserDto;
import com.poissonn.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserManageServiceImp implements UserManageService {

    @Resource
    private PoissonnUserMapper poissonnUserMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean login(String username, String password) {

        return false;
    }

    @Override
    public Boolean addUser(PoissonnUserDto dto) {
        try{
            poissonnUserMapper.insertUser(dto);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 根据用户名搜索用户
     * @param username
     * @return
     */
    @Override
    public List<PoissonnUserDto> query(String username,String name) {
        return poissonnUserMapper.queryByParams(username,name);
    }
}
