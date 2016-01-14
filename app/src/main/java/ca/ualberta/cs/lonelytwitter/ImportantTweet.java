package ca.ualberta.cs.lonelytwitter;

/**
 * Created by hsbarker on 1/14/16.
 */
public class ImportantTweet extends Tweet implements Tweetable{
    public ImportantTweet(String message) {
        super(message);
    }
    public String getMessage() {
        return "IMPORTANT" + this.getMessage();
    }
    @Override
    public boolean important(){
        return true;
    }
}
