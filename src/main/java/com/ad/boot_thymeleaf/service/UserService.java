package com.ad.boot_thymeleaf.service;

import com.ad.boot_thymeleaf.bean.User;
import com.ad.boot_thymeleaf.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    AccountMapper accountMapper;

    public User getUserById(int id){
        return accountMapper.getUser(id);
    }
}
