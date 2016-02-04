package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hsbarker on 1/14/16.
 * This class provides methods to the mood classes to access the message and date.
 * @see Sad
 * @see Happy
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
