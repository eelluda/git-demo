package com.ad.boot_thymeleaf.service.impl;

import com.ad.boot_thymeleaf.bean.Users;
import com.ad.boot_thymeleaf.mapper.UsersMapper;
import com.ad.boot_thymeleaf.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
