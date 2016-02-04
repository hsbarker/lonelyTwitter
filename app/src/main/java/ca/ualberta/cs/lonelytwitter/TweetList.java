package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by hsbarker on 1/28/16.
 * This class stores a set of tweets in the form of an array.
 * @see Tweet
 * This class provides methods to allow the rest of
 * the application to access the list for usage and changes.
 */
public class TweetList
{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        if (hasTweet(tweet))
            ;
        else
            tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    public void remove(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }
    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet first, Tweet second) {
                if (first.getDate().before(second.getDate()))
                    return 0;
                else
                    return -1;
            }
        });
        return tweets;
    }
}
