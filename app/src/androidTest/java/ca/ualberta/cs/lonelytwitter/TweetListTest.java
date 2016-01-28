package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by hsbarker on 1/28/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet= new NormalTweet("Test Tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try{
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet first = new NormalTweet("Another Test Tweet");
        Tweet second = new NormalTweet("Another");
        tweets.add(second);
        tweets.add(first);
        ArrayList<Tweet> sortedTweets = tweets.getTweets();
        assertTrue(sortedTweets.get(0).getDate().before(sortedTweets.get(1).getDate()));
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testRemoveTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");
        tweets.add(tweet);
        tweets.remove(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");
        tweets.add(tweet);
        assertEquals(1,tweets.getCount());
    }
}
