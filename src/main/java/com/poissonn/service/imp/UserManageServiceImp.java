package com.poissonn.service.imp;

import com.poissonn.dao.PoissonnUserMapper;
import com.poissonn.dto.PoissonnUserDto;
import com.poissonn.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImp implements UserManageService {

    @Autowired
    private PoissonnUserMapper poissonnUserMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean login(String username, String password) {

        return false;
    }

    @Override
    public Boolean addUser(PoissonnUserDto dto) {

        int count = poissonnUserMapper.insertSelective(dto);
        logger.info("新增成功的数量：",count);

        if (count > 0)
            return true;

        return false;
    }
}
