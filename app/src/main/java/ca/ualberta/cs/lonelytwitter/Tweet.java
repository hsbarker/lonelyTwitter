package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hsbarker on 1/14/16.
 */
public abstract class Tweet {
    protected String message;
    private Date date;
    private ArrayList<Mood> Moods;

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }


    public Tweet(String message) {
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }
    public String getMessage(){return this.message;}

    public void setMessage(String message) throws Exception
    {
        if (message.length() > 140) {
            throw new Exception();
        }
        this.message = message;
    }
    abstract public boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
