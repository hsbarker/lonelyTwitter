package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small Twitter app to capture, <br>notes and comments.
 * <p>It saves the input tweets in the form of json files.</p><br>
 *     A sample code is as: <br>
 *         <code>
 *             for (int i = 0; i < 10; i++){
 *                 for (j = 0; j < i; j++){
 *                     doSomething();
 *                 }
 *             }
 *         </code>
 * The list of important activities in this class are as follows:<br>
 *     <ul>
 *         <li>Show user the saved tweets on screen.</li>
 *         <li>Allow user to type in new tweets.</li>
 *         <li>Allow user to click a save button to save his newly created tweet.</li>
 *         <li>Allow user to clear his/her list of saved tweets.</li>
 *     </ul>
 * @see NormalTweet
 * @see java.awt
 * @author hsbarker
 * @version 2.1
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * @see Tweet
	 */

	static int MAXIMUM_TWEET_SIZE = 100;
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	private int calculateTweetSize(){
		return -1;
	}

	/**
	 *
	 * @param text1 The text for the directory name
	 * @param text2 The file name
	 * @param text3 The extension
	 * @param text4
	 * @return concatenation of ...
	 * @throws
	 * @exception IllegalAccessError
	 * This happens if,,,
	 * @exception IllegalArgumentException
	 * This happens if,,,
	 * @deprecated
	 */
	public String doSomething(String text1, String text2, String text3, String text4){
		return  "";
	}

	public String removeStopWords(String text){
		String expression1 = "",
				expression2 = "",
				expression3 = "",
				expression4 = "";
		int count = 10;
		String expression = doSomething(expression1, expression2,
				doSomething(expression3, expression4, expression3,
						expression4), expression1);

		for (int i = 0; i < count; i++){
			try{
				int j = 1;
				int k = 2;
				int count2 = 0;
				if (j < k) {
					doSomething("", "", "", "");
				}
				else if (true) {
					doSomething("a", "", "", "");
				}
			}
			catch (Exception e){}
		}
		return "";
	}

	private void startSecondActivity(Intent intent){

	}

	protected boolean evatluateOtherActivity(Intent intent){
		return true;
	}

	/**
	 * Called when the activity is first created.
	 * Stores the functions with the buttons with
	 * the ability to store the users new tweets or delete them.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newestTweet = new NormalTweet(text);
//				try {
//					newestTweet.setMessage("Length abiding message");
//				} catch (Exception e) {
//					System.err.print("This text was too long : " + text);
//				}
//				if (newestTweet.isImportant()){
//
//				}
				//newestTweet.getmessage();
//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

				tweets.add(newestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				//Scanner in = new Scanner(System.in);
//
			//	System.out.println("Enter the station");
			//	String station = in.nextLine();

			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);


				tweets.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	/**
	 * Called when the app starts.
	 * Applies the list of tweets stored in Json to a viewable list object.
	 * @ loadFromFile
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**Called when the app starts.
	 * Loads the list of saved tweets from Json for the user.
	 * Creates a new list of tweets in case there is no saved tweets.
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-21 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);
//			String line = in.readLine();
//			while (line != null) {
//				tweets.add(line);
//				line = in.readLine();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
//		return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Applied when the save button is pressed by the user.
	 * This class stores the users tweet in Json.
	 * Checks to make sure there is a file to save to.
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
//			fos.write(new String(date.toString() + " | " + text)
//					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}