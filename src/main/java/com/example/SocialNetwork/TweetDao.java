package com.example.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TweetDao {
    @Autowired
    tweetDBService dbService;


    public static final String HASH_KEY = "Tweet";
    @Autowired
    private RedisTemplate template;


    public Tweet save(Tweet tweet){
        template.opsForHash().put(HASH_KEY,tweet.getId(),tweet);
        return tweet;
    }

    public List<Tweet> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Tweet findTweetById(Long id){
        return (Tweet) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteTweet(Long id){
        template.opsForHash().delete(HASH_KEY,id);
        return "tweet removed !!";
    }

    public boolean saveTweet(Tweet tweet) {
        // save tweet content to db
        dbService.saveTweetDB(tweet);
        save(tweet);
        // get all (active) followers

        tUser CurrentUser = (tUser) template.opsForHash().get("tUser", tweet.getUserid());

        //timeline:
        //{
        //userId(key): [id1, id2,....]
        //}

        // fan out to all followers' queues
        //  timeline_12345: [tweet_id_1]
        // 	timeline_23456: [tweet_id_1]
        for(int id: CurrentUser.getuserFans()) {
            template.opsForList().leftPush("timeline_" + id, tweet.getId());
        }
        return true;
    }

//    public Tweet getTweet(Long tweetId) {
//        Object value = template.opsForHash().get(HASH_KEY, tweetId);
//
//        if(value==null) {
//            Tweet tweet =  dbService.getTweetDB(tweetId);
//            template.opsForHash().put(HASH_KEY,tweet.getId(),tweet);
//        } else {
//            return (Tweet)value;
//        }
//        return (Tweet)value;
//    }




}
