package com.example.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class tUserDao {
    @Autowired
    tUserDBService dbService;


    public static final String HASH_KEY = "tUser";
    @Autowired
    private RedisTemplate template;

    public tUser save(tUser tuser){
        dbService.saveUserDB(tuser);
        template.opsForHash().put(HASH_KEY,tuser.getuserId(), tuser);
        return tuser;
    }
    public tUser findUserById(Long userId){
        return (tUser) template.opsForHash().get(HASH_KEY,userId);
    }
    public List<tUser> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }
    public String deleteUser(Long userId){
        template.opsForHash().delete(HASH_KEY, userId);
        return "tUser removed !!";
    }


}
