package com.example.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
@Component
public class tUserDBService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public boolean saveUserDB(tUser user) {
        String userid = String.valueOf(user.getuserId());
        String username = user.getusername();
        String account = user.getaccount();
        Timestamp create_time = user.getCreate_time();
//        String userFans = user.getuserFans();

        String userFans = user.getuserFans().toString();

        String sql = "INSERT INTO tUser (userid, username, account, create_time, userFans) VALUES (?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, userid, username, account,create_time, userFans);

        return result > 0;
    }
}
