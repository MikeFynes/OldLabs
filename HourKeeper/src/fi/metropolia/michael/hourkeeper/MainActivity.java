package fi.metropolia.michael.hourkeeper;


import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.text.SimpleDateFormat;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStart, btnStop, btnPrevious;
	private TextView lastText, hoursWorked, totalHours;
	private EditText userName; 
	private long firstSecs, lastSecs;
	private static final String fileName = "username.txt";
	private String stringyUsername, iFirst, firstDate;
	private int finalSecs;
	protected static final String PREF1 = "Username";
	protected static final String PREF2 = "Start";
	DatabaseHelper d;
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		SharedPreferences prefGet = getSharedPreferences(PREF1, Activity.MODE_PRIVATE); 
        stringyUsername = prefGet.getString("Username", "");
        SharedPreferences prefGetDate = getSharedPreferences(PREF2, Activity.MODE_PRIVATE); 
        iFirst = prefGetDate.getString("Start", "");
        Log.d("MAIN ACTIVITY USERNAME GRAB", "USERNAME IS: "+stringyUsername );
        Log.d("FIRST DATE", "IS: "+iFirst );
		
		
		// CREATING DATABASE
		d = new DatabaseHelper(this);
		
		
	// USER NAME FIELD
		userName= (EditText) findViewById(R.id.userName);
		userName.setText(prefGet.getString("Username", ""));
		

	
	// START BUTTON
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(this) ;
	
      
      // STOP BUTTON
      btnStop = (Button) findViewById(R.id.btnStop);
      btnStop.setOnClickListener(this); 
	
      
     // PREVIOUS HOURS BUTTON
      btnPrevious = (Button) findViewById(R.id.btnPrevious);
      btnPrevious.setOnClickListener(this); 
	
      // FIND TEXT VIEWS
      lastText = (TextView) findViewById (R.id.lastHours);
      hoursWorked = (TextView) findViewById(R.id.hoursWorked);
      totalHours = (TextView) findViewById(R.id.totalHours);
      
  	// START FIELD REMEMBERED
		
      
      if(iFirst == ""){
    	  hoursWorked.setText(iFirst);
      }
      else{
    	  
      
      setFirstSecs(Long.parseLong(iFirst)); 
      SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH);
      sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
      String firstDate = sdf1.format(getFirstSecs());
      Log.d("Save Date", Long.toString(getFirstSecs()));
      
      hoursWorked.setText(firstDate);
      }
      
     
      
      
	}
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.btnStart:
			// String firstDateTimeString = Date.toString(new Date());
			setStringyUsername(userName.getText().toString());

			if(getStringyUsername().matches("")){
				Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
			}
			else{
				
			setFirstSecs((new Date().getTime()));
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH);
			sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
			firstDate = sdf1.format(getFirstSecs());
			
			hoursWorked.setText(firstDate);
			
			}
			
			
			break;
			
		case R.id.btnStop:
		
			if(iFirst.matches("")){
				Toast.makeText(this, "You cannot stop before you start!", Toast.LENGTH_SHORT).show();
			}
			else{
			
			setLastSecs((new Date().getTime()));
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH);
			sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
			String lastDate = sdf2.format(getLastSecs());
			
			setStringyUsername(userName.getText().toString());
			
			lastText.setText(lastDate);

			
			setFinalSecs((int) (getLastSecs() - getFirstSecs()));
			
			
			
			totalHours.setText(oldTime(getFinalSecs()));	
			
			String clearStart = "";
			saveStart(clearStart);
			
			
			if(getStringyUsername().matches("")){
				Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
			}
			else{
				d.insertData(stringyUsername, firstSecs, lastSecs, finalSecs);
				Toast.makeText(this, "Hours saved!", Toast.LENGTH_SHORT).show();
			}
			
			}
			
			
			break;
			
		case R.id.btnPrevious:
			
			
			Intent myIntent = new Intent(this, SecActivity.class);
			startActivity(myIntent);
			
			break;
		}
	}
	// CONVERS TIME FROM MILLISECONDS TO HH:MM:SS FORMAT
	
		public String oldTime (int finalSecs){
			
			
	String time = "";
	    	
	   
	int hrs = (int) finalSecs/ (1000*60*60) % 24;
	if(hrs < 10)
		time += "0" + hrs +":";
	else
		time += hrs +":";

			int mins = (int) ((finalSecs / (1000*60)) % 60);
				if(mins < 10)
					time += "0" + mins+":";
				else
			time += mins+":";
	    	
	 		int secs = (int) (finalSecs / 1000) % 60;
	    	if(secs < 10)
	    		time += "0" + secs;
		   	else
		   		time += secs;
	    	
	     	
	    	
			return time;
			
			
			
			}
		
	
		public String getStringyUsername() {
			return this.stringyUsername;
		}





		public void setStringyUsername(String stringyUsername) {
			this.stringyUsername = stringyUsername;
			
			SharedPreferences prefPut = getSharedPreferences(PREF1, Activity.MODE_PRIVATE); 
            Editor prefEditor = prefPut.edit(); 
        	prefEditor.putString("Username", stringyUsername);
    		prefEditor.commit();
    		Log.d("USERNAME","USERNAME SAVED " +stringyUsername);
		}


		public long getFirstSecs() {
			return this.firstSecs;
			
		}





		public void setFirstSecs(long firstSecs) {
			this.firstSecs = firstSecs;
			iFirst = Long.toString(firstSecs);
			saveStart(iFirst);
			
			
		}

		public void saveStart(String date){
			SharedPreferences prefPut = getSharedPreferences(PREF2, Activity.MODE_PRIVATE); 
            Editor prefEditor = prefPut.edit(); 
        	prefEditor.putString("Start", date);
    		prefEditor.commit();
    		Log.d("FIRST DATE SAVED","IS: " +date);
		}



		public long getLastSecs() {
			return this.lastSecs;
		}





		public void setLastSecs(long lastSecs) {
			this.lastSecs = lastSecs;
		}





		public int getFinalSecs() {
			return this.finalSecs;
		}





		public void setFinalSecs(int finalSecs) {
			this.finalSecs = finalSecs;
		}





		public static String getFilename() {
			return fileName;
		}
		
			


}
