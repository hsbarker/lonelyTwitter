package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hsbarker on 1/14/16.
 */
public class Tweet {
    private String message;
    private Date date;

    public Tweet(String message,Date date) {
        this.message = message;
        this.date = date;
    }

    public Tweet(String message) {
        this.message = message;
    }
}
