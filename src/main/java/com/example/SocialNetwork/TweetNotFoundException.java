package com.example.SocialNetwork;

public class TweetNotFoundException  extends RuntimeException{
    TweetNotFoundException(Long id) {
        super("Could not find tweet " + id);
    }
}
