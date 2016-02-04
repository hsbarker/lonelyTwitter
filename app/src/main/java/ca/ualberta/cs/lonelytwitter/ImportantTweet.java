package ca.ualberta.cs.lonelytwitter;

/**
 * Created by hsbarker on 1/14/16.
 * This class flags a tweet as being important and lets the user know.
 */
public class ImportantTweet extends Tweet implements Tweetable{
    public ImportantTweet(String message) {
        super(message);
    }
    public String getMessage() {
        return "IMPORTANT" + this.getMessage();
    }
    @Override
    public boolean isImportant(){
        return true;
    }
}
