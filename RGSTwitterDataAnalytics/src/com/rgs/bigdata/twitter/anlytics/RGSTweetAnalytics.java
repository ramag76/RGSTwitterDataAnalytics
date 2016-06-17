package com.rgs.bigdata.twitter.anlytics;

import java.io.IOException;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class RGSTweetAnalytics {


public void start() throws TwitterException, IOException {
	
	// Enter your Key and token details from dev.twitter.com for your registration.
	   String CONSUMER_KEY = "";
	     String CONSUMER_KEY_SECRET = "";
	     String TWITTER_ACCESS_TOKEN = "";
	     String TWITTER_ACCESS_TOKEN_SECRET = "";

	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    
	    cb.setDebugEnabled(true)
	         .setOAuthConsumerKey(CONSUMER_KEY)
	        .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
	        .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
	        .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
	    
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();

 try {
     Query query = new Query("#Sydney");
     QueryResult result;
     result = twitter.search(query);
     java.util.List<Status> tweets = result.getTweets();
     for (Status tweet : tweets) {
         System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
     }
 }
 catch (TwitterException te) {
     te.printStackTrace();
     System.out.println("Failed to search tweets: " + te.getMessage());
     System.exit(-1);
 }
 

    }

    public static void main(String[] args) throws Exception {
    new RGSTweetAnalytics().start();// run the Twitter client
    
    }
}