package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hsbarker on 1/14/16.
 * This class creates a selectable mood called "Happy".
 */
public class Happy extends Mood {
    public Happy(String CurrentMood, Date date) {
        super(CurrentMood, date);
        this.CurrentMood = "HAPPY";
    }

    @Override
    public String getMood() {
        return this.CurrentMood;
    }
}
