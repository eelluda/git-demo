package com.ad.boot_thymeleaf.mapper;

import com.ad.boot_thymeleaf.bean.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AccountMapper {
    public User getUser(int id);
}
