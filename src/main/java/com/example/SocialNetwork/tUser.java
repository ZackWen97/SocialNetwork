package com.example.SocialNetwork;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class tUser {
    private @Id @GeneratedValue Long id;
    private Long userId;
    private String username;
    private String account;
    private String picture;

    private List<Integer> followid;

    tUser() {}

    tUser(String username, String account, String picture) {
        this.username = username;
        this.account = account;
        this.picture = picture;
    }
    public Long getid() {
        return this.id;
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
    public String getPicture() {
        return this.picture;
    }
    public List<Integer> getFollowid(){
        return this.followid;
    };
    public void setid(Long id) {
        this.id = id;
    }
    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public void setaccount(String account){
        this.account = account;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof tUser))
            return false;
        tUser tUser = (tUser) o;
        return Objects.equals(this.id, tUser.id) &&  Objects.equals(this.userId, tUser.userId) && Objects.equals(this.username, tUser.username)
                && Objects.equals(this.account, tUser.account) && Objects.equals(this.picture, tUser.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.userId, this.username, this.account, this.picture);
    }
    @Override
    public String toString() {
        return "tUser{" + "id=" + this.id + '\'' +"userId=" + this.userId + '\''  +", username='" + this.username + '\'' + ", account='" + this.account + '\'' + ", picture='" + this.picture + '\'' + '}';
    }



}
