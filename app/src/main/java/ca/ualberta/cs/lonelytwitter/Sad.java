package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hsbarker on 1/14/16.
 * This class creates a selectable mood called "Sad".
 */
public class Sad extends Mood{
    public Sad(String CurrentMood, Date date) {
        super(CurrentMood, date);
        this.CurrentMood = "sad";
    }

    @Override
    public String getMood() {
        return this.CurrentMood;
    }
}
