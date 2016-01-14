package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hsbarker on 1/14/16.
 */
public abstract class Mood {
    public String CurrentMood;
    public Date date;

    public Mood(String CurrentMood, Date date){
        this.CurrentMood = CurrentMood;
        this.date = new Date(System.currentTimeMillis());
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    abstract public String getMood();
}
