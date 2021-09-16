package com.ad.boot_thymeleaf;

import com.ad.boot_thymeleaf.bean.Users;
import com.ad.boot_thymeleaf.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@DisplayName("测试")
@Slf4j
@SpringBootTest
class BootThymeleafApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private UsersMapper usersMapper;

    @DisplayName("数据调试测试")
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("数据条数：{}",aLong);
        System.out.println("kkkk");
        System.out.println("llll");
        System.out.println("llll");
    }

    @DisplayName("master")
    @Test
    public void testSelect() {
        Users users = usersMapper.selectById(1L);
        System.out.println(users);
    }
}
