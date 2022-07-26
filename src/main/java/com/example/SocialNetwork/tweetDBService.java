package com.example.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Component
public class tweetDBService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public boolean saveTweetDB(Tweet newTweet) {
        String id = String.valueOf(newTweet.getId());
        String userId = String.valueOf(newTweet.getUserid());
        String title = newTweet.getTitle();
        String content = newTweet.getContent();
        String picture = newTweet.getPicture();
        Timestamp create_time = newTweet.getCreate_time();

        String sql = "INSERT INTO tweet (id, userId, title, content, picture, create_time) VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, id, userId, title, content, picture, create_time);

        return result > 0;
    }

//    public Tweet getTweetDB(Long tweetId) {
//// JDBC select
//        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
//        jdbcTemplate.query(
//                "SELECT id, tweet_content, tweet_author FROM tweet WHERE id = ?", new Object[] { tweetId },
//                (rs, rowNum)
//                        -> new Tweet(rs.getLong("id"),
//                        rs.getString("tweet_content"),
//                        rs.getLong("userid")).forEach(
//                        tweet -> tweets.append(tweet))
//                );
//
//        return tweets.get(0);
//    }
//
}
