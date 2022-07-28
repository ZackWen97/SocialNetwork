package com.example.SocialNetwork;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RedisHash("tUser")
public class tUser implements Serializable {

    private @Id @GeneratedValue Long userId;
    private String username;
    private String account;

    @OneToMany
    private List<Integer> userFans = Arrays.asList(456, 789);
//    private String userFans;
    private Long fansNum;
    private Timestamp create_time;

    tUser() {}
    tUser(String username, String account, List<Integer> userFans) {
        this.username = username;
        this.account = account;
//        this.userFans =  userFans;

    }

    public Long getuserId() {
        return this.userId;
    }
    public String getusername() {
        return this.username;
    }
    public String getaccount() {
        return this.account;
    }
    public Timestamp getCreate_time(){
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

//    public Long getFansNum(){
//        return Long.valueOf(this.userFans.size());
//    }
//    public String getuserFans(){
//        return this.userFans;
//    }

    public List<Integer> getuserFans(){
        return this.userFans;
    };

    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public void setaccount(String account){
        this.account = account;
    }

//    public void setFans(List<Integer> userFans){
//        this.userFans = userFans;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof tUser))
            return false;
        tUser tUser = (tUser) o;
        return  Objects.equals(this.userId, tUser.userId) && Objects.equals(this.username, tUser.username)
                && Objects.equals(this.account, tUser.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.username, this.account);
    }
    @Override
    public String toString() {
        return "tUser{" +"userId=" + this.userId + '\''  +", username='" + this.username + '\'' + ", account='" + this.account + '\'' + ", picture='" + '}';
    }



}
