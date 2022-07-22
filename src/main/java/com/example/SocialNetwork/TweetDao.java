package com.example.SocialNetwork;

import com.example.SocialNetwork.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TweetDao {

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
}
