package com.example.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;

public class tUserDBService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public boolean saveUserDB(Tweet newTweet) {
        String id = String.valueOf(newTweet.getId());
        String userId = String.valueOf(newTweet.getUserid());
        String title = newTweet.getTitle();
        String content = newTweet.getContent();
        String picture = newTweet.getPicture();
        Timestamp create_time = newTweet.getCreate_time();

        String sql = "INSERT INTO test (id, userId, title, content, picture, create_time) VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, id, userId, title, content, picture, create_time);

        return result > 0;
    }
}
