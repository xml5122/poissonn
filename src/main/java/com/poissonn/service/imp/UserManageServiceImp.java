package com.poissonn.service.imp;

import com.poissonn.constance.MenuRoot;
import com.poissonn.dao.PoissonnUserMapper;
import com.poissonn.dto.PoissonnUserDto;
import com.poissonn.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void addUser(PoissonnUserDto dto) {
        poissonnUserMapper.insertUser(dto);
    }

    /**
     * 根据用户名搜索用户
     * @param map
     * @return
     */
    @Override
    public List<PoissonnUserDto> query(Map<String,String> map) {
        return poissonnUserMapper.queryByParams(map.get("username"),map.get("name"));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public void delete(Integer id) {
        poissonnUserMapper.deleteUserById(id);
    }

    /**
     * 给权限下拉框动态赋值
     * @return
     */
    @Override
    public List<Map<String, String>> getRole() {
        List<Map<String, String>> list = new ArrayList<>();
        for (MenuRoot menuRoot :MenuRoot.values()){
            Map<String, String> map = new HashMap<>();
            map.put("code", menuRoot.getRoleCode());
            map.put("value",menuRoot.getRoleName());
            list.add(map);
        }
        return list;
    }
}
