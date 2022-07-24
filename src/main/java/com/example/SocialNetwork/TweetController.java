package com.example.SocialNetwork;


import java.sql.Timestamp;
import java.util.List;
import com.example.SocialNetwork.Tweet;
import com.example.SocialNetwork.TweetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;



@SpringBootApplication
@RestController
public class TweetController{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    public TweetDao dao;
//    private TweetRepository TwRepo;

//    @GetMapping("/tweet")
//    public String listAll() {
////        List<Tweet> ListTweet = TwRepo.findAll();
////        model.addAttribute("listStudents", ListTweet);
//        return "Tweet";
//    }
// Tweet
    //get tweet info
    @GetMapping("/tweet/{id}")
    public Tweet findTweet(@PathVariable Long id) {
        return dao.findTweetById(id);
    }
    @GetMapping("/tweet123/{id}")
    public void findTweet1(@PathVariable Long id) {
        System.out.println(String.valueOf(findTweet(id).getContent()));
        return ;
    }
    //show all tweets
    @GetMapping("/tweet/")
    public List<Tweet> getAllTweets() {
        return dao.findAll();
    }
    //PostTweet
    @PostMapping("/tweet/")
    private Tweet newTweet(@RequestBody Tweet newTweet) {
        String id = String.valueOf(newTweet.getId());
        String tid = String.valueOf(newTweet.getTid());
        String title = newTweet.getTitle();
        String content = newTweet.getContent();
        String picture = newTweet.getPicture();
        Timestamp create_time = newTweet.getCreate_time();

        String sql = "INSERT INTO test (id, tid, title, content, picture, create_time) VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, id, tid, title, content, picture, create_time);

        if (result > 0) {
            System.out.println("Insert successfully.");
        }

        return dao.save(newTweet);
    }
    @DeleteMapping("/tweet/{id}")
    public String remove(@PathVariable Long id)   {
        return dao.deleteTweet(id);
    }
//    @GetMapping("/redis/{key}")
//    private void TestRedis(@PathVariable String key){
//        ValueOperations<String, String> vo = redisTemplate.opsForValue();
//        System.out.println(vo.get(key));
//
//    }
//    @PostMapping("/redis/")
//    public void setValue(@RequestBody String key, String value) {
//        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
//        vo.set(key, value);
//        redisTemplate.expire(key, 1, TimeUnit.HOURS); // 这里指的是1小时后失效
//    }
//    @Autowired
//    @Autowired
//    public ProductDao dao1;
////
//    @PostMapping("/123/")
//    public Product save(@RequestBody Product product) {
//        return dao1.save(product);
//    }
////
//    @GetMapping("/123/")
//    public List<Product> getAllProducts() {
//        return dao1.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Product findProduct(@PathVariable String id) {
//        return dao.findProductById(id);
//    }
//    @DeleteMapping("/{id}")
//    public String remove(@PathVariable String id)   {
//        return dao.deleteProduct(id);
//    }




//    @PostMapping("/123/")
//    public Tweet save(@RequestBody Tweet tweet) {
//        return dao.save(newTweet);
//    }







    // delete tweet
//    @DeleteMapping("/tweet/")
//    public String DeleteTweet(@RequestParam long tid){
//        return "Delete Reply successfully";
//    }
//    //hide tweet
//    @GetMapping("/tweet/")
//    private String HideTweet(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//
//
//    //Reply
//    //get reply
//    @GetMapping("/tweet/reply")
//    public String GetReply_tid(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    @GetMapping("/tweet/reply")
//    public String GetReply_user(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    //post reply
//    @PostMapping("/tweet/reply")
//    public String PostReply(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    //delete reply
//    @DeleteMapping("/tweet/reply")
//    public String DeleteReply(@RequestParam long tid){
//        return "Delete Reply successfully";
//    }
//
//
//    //Likes
//    // get likes
//    @GetMapping("/tweet/likes")
//    public String GetLikes_tid(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    @GetMapping("/tweet/likes")
//    public String GetLikes_user(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    //delete likes
//    @DeleteMapping("/tweet/likes")
//    public String DeleteLikes(@RequestParam long tid){
//        return "Delete Likes successfully";
//    }
//
//
//    //Collection/bookmark
//    @GetMapping("/tweet/collection")
//    public String GetCollection_tid(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    @GetMapping("/tweet/collection")
//    public String GetCollection_user(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    @PostMapping("/tweet/collection")
//    public String PostCollection_tid(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    @PostMapping("/tweet/collection")
//    public String PostCollection_user(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    @DeleteMapping("/tweet/collection")
//    public String DeleteCollection(@RequestParam long userid){
//        return "Delete Likes successfully";
//    }
//
//
//    //Quote
//    @GetMapping("/tweet/quote")
//    public String GetQuote_tid(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    @GetMapping("/tweet/quote")
//    public String GetQuote_user(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    @PostMapping("/tweet/quote")
//    public String PostQuote_tid(@RequestParam long tid) {
//        return String.valueOf(tid);
//    }
//    @PostMapping("/tweet/collection")
//    public String PostQuote_user(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    @DeleteMapping("/tweet/collection")
//    public String DeleteQuote(@RequestParam long userid){
//        return "Delete Likes successfully";
//    }
//    @DeleteMapping("/tweet/collection")
//    public String DeleteQuote_tid(@RequestParam long tid){
//        return "Delete Likes successfully";
//    }
//
//
//
//    ////////////// Account Service
//    //Account info, account/pwd
//    @GetMapping("/user/account")
//    public String GetAccount(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    @PostMapping("/user/account")
//    public String PostAccount(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    //how to hide?
//
//    //user info, username, picture, signature
//    @GetMapping("/user/info")
//    public String GetUserInfo(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//    @PostMapping("/user/info")
//    public String PostUserInfo(@RequestParam long userid) {
//        return String.valueOf(userid);
//    }
//
//    //user's tweet
//    @GetMapping("/tweet/{userId}")
//    public String GetTweet_User(@PathVariable Long userId){
//        return String.valueOf(userId);
//    }
//    @PostMapping("/tweet/{userId}")
//    public String PostTweet_User(@PathVariable Long userId){
//        return String.valueOf(userId);
//    }
//
//    //follow
//    @GetMapping("/user/follow")
//    public String GetFollow_User(@RequestParam Long userId){
//        return String.valueOf(userId);
//    }
//    @PostMapping("/user/follow")
//    public String PostFollow_User(@RequestParam Long userId){
//        return String.valueOf(userId);
//    }
//    @DeleteMapping("/user/follow")
//    public String DeleteFollow_user(@RequestParam long userId){
//        return "Delete Likes successfully";
//    }
//
//    //user likes
//
//
//
//
//
//
}
