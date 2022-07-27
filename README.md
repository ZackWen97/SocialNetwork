# SocialNetwork
a life sharing website, and
API developing as following
# Target Service: 
User, Tweet，Reply

# ER design
![image](https://user-images.githubusercontent.com/98070161/181100471-79d36514-df85-439e-8306-8e38158491ff.png)


# Nowadays function: 
Tweet Create, Get all in database & Cache and timeline optimaztion
# Tweet:
Current structure: 
Tweet{id, userId, title, content, picture, create_time}

# API:

	tweet,
	info,
		GET /tweet/info?tId
		POST /tweet/info?tId # show all the tweet's content
		GET /tweet/   #show all the tweet     	
	Reply,
		GET /tweet/Reply?tId
			max_results; # tweet's reply total number
			content; # tweet's reply's content
			user_info; # tweet's reply's user information
			Time_Rp; # Reply's time
		GET /user/Reply?tId
			content; # tweet's reply's content
			user_info; # tweet's reply's user information
			Time_Rp; # Reply's time
		DELETE /tweet/Reply?tId
			Delete_userId;
			Delete_TwId;
			Delete_time; # Delete info time;
		POST /tweet/Reply?tId
	Likes,
	    	GET /tweet/likes?tId
		GET /user/likes?UserId
		DELETE /tweet/?tId
		POST /user/ likes?UserId
	Collection,
		GET /user/collection?UserId
		GET /tweet/collection?tId
		POST /user/collection?UserId
		POST /tweet/collection?tId
		DELETE /user/collection?UserId
		DELETE /tweet/collection?tId
	Quote,
		GET /tweet/quote?tId
		GET /user/quote?UserId
		POST /tweet/quote?tId
		POST  /user/quote?UserId
	Operation,
		GET /tweet/delete?tId
		GET /tweet/hide?tId
	User:
	Acc info,
		GET /user/account?UserId
		POST /user/account?UserId
		UPDATE /user/account?UserId
		HIDE /user/account?UserId
	info,
		GET /user/info?UserId
		POST /user/info?UserId
		UPDATE /user/info?UserId
		HIDE /user/info?UserId	
	Tweets,
		GET /tweet/user?UserId
		POST /tweet/user?UserId
		DELETE /tweet/user?UserId
	follow,
		GET /user/follow?UserId
		POST /user/follow?UserId
		DELETE /user/follow?UserId
		HIDE /user/follow?UserId
	Likes,
		GET /user/likes?UserId
		GET /user/likes?tId
		DELETE /user/likes?UserId
		DELETE /user/likes?tId
		POST /user/likes?tId
		POST /user/likes?UserId
	Channel:
	home,
		GET /user/tweet?UserId
		GET /tweet/?tId
		POST /user/tweet?UserId
		POST /tweet/?tId
	Collection,
		GET /tweet/collection?UserId
		POST /tweet/collection?UserId
		DELETE /tweet/collection?UserId
	User Profile,
		GET /user/account?UserId
		POST /user/account?UserId
		UPDATE /user/account?UserId
		HIDE /user/account?UserId
		GET /user/info?UserId
		POST /user/info?UserId
		UPDATE /user/info?UserId
		HIDE /user/info?UserId


# SQL
	create table tweet(
   		id varchar(255) primary key,
    		userId varchar(255),
   		title varchar(255),
    		content varchar(255),
    		picture varchar(255),
    		create_time Timestamp,
    		LikesNum int,
    		Likes varchar(255),
    		isHide int,
    		collectNum int
	)















