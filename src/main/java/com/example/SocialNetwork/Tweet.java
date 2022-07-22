package com.example.SocialNetwork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@AllArgsConstructor
@RedisHash("Tweet")
public class Tweet implements Serializable{
    private @Id @GeneratedValue Long id;
    private Long tid;
    private String title;
    private String content;
    private String picture;
    private Timestamp create_time;

    Tweet() {}

    public Tweet(String title, String content, String picture) {
        this.title = title;
        this.content = content;
        this.picture = picture;
    }//    public void setCreate_time(Timestamp create_time){
    //        this.create_time = create_time;
//    }
    public Long getId() {
        return this.id;
    }
    public Long getTid() {
        return this.tid;
    }
    public String getTitle() {
        return this.title;
    }
    public String getContent() {
        return this.content;
    }
    public String getPicture() {
        return this.picture;
    }
    public Timestamp getCreate_time(){
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTid(Long tid) {
        this.tid = tid;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Tweet))
            return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(this.id, tweet.id)&& Objects.equals(this.tid, tweet.tid) && Objects.equals(this.title, tweet.title)
                && Objects.equals(this.content, tweet.content) && Objects.equals(this.picture, tweet.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.tid, this.title, this.content, this.picture);
    }
    @Override
    public String toString() {
        return "Tweet {" + "id=" + this.id + '\'' +", tid='" + this.tid + '\''  +", title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", picture='" + this.picture + '\'' + '}';
    }


}
