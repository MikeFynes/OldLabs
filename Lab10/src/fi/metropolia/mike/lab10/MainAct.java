package fi.metropolia.mike.lab10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import fi.metropolia.kari.ab.lab2.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainAct extends Activity {

private TextView txtPrison, txtRelease;
private static final String PREF = "TestPref"; 
private String contentET; 
private static final String prisonFile = "prison.txt";
private static final String releaseFile = "release.txt";
private int prison;
private int release;
private int prisonRead, releaseRead;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ActionBar bar = getActionBar();
		bar.setHomeButtonEnabled(true);

		txtPrison= (TextView) findViewById(R.id.txtPrison);
		txtRelease= (TextView) findViewById(R.id.txtRelease);
	
	
		SharedPreferences prefGet = getSharedPreferences(PREF, Activity.MODE_PRIVATE); 
		prison = prefGet.getInt("Prison", 0); 
		release = prefGet.getInt("Release", 0); 
	
		contentET = "some text"; 
	
		SharedPreferences prefPut = getSharedPreferences(PREF, 
		 Activity.MODE_PRIVATE); 
		Editor prefEditor = prefPut.edit(); 
		prefEditor.putString("LT", contentET); 
		prefEditor.commit(); 
		
		prisonRead = readFiles(prisonFile);
		releaseRead = readFiles(releaseFile);

		txtRelease.setText(getResources().getString(R.string.b2)+ " " + Integer.toString(release) + " times");
		txtPrison.setText(getResources().getString(R.string.b1)+ " " + Integer.toString(prison) + " times");
	
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
		}
	
	public boolean onOptionsItemSelected(MenuItem item){

		SharedPreferences prefPut = getSharedPreferences(PREF, 
		 Activity.MODE_PRIVATE); 
		Editor prefEditor = prefPut.edit(); 
		
		switch(item.getItemId()) {
		case R.id.prison:
		
			
		
		
		prison++;
		prefEditor.putInt("Prison", prison); 
		prefEditor.commit(); 
		Toast.makeText(getApplicationContext(), getResources().getString(R.string.b1) + " " + Integer.toString(prison) + " times", Toast.LENGTH_SHORT).show();
		saveFile(prisonFile, prison);
		txtPrison.setText(getResources().getString(R.string.b1)+ " " + Integer.toString(prison) + " times");
		break;
		case R.id.release:
		
		
		
	
		release++;
		prefEditor.putInt("Release", release); 
		prefEditor.commit(); 
		Toast.makeText(getApplicationContext(), getResources().getString(R.string.b2)+ " " + Integer.toString(release) + " times", Toast.LENGTH_SHORT).show();
		saveFile(releaseFile, release);
		txtRelease.setText(getResources().getString(R.string.b2)+ " " + Integer.toString(release) + " times");
	break;
		case R.id.reset:
		reset();
		break;
		}
		
	
		return true;
		}
	

	
	// OPEN FILE OUTPUT EXAMPLE
	public void saveFile(String fName, int value){
		
		String contentET = Integer.toString(value); 
		try { 
		 FileOutputStream fOs = openFileOutput(fName, 0); 
		 OutputStreamWriter oSw = new OutputStreamWriter(fOs); 
		 BufferedWriter bW = new BufferedWriter(oSw); 
		 bW.write(contentET); 
		 bW.flush(); 
		 bW.close(); 
		 oSw.close(); 
		 fOs.close();
		 
		 } 
		catch (Exception e) { 
		 Log.d("onClick", e.toString()); 
		 }
		}

	
	public int readFiles(String fname){
		
		int ch = 0;
		try { 
			 int content; 
			 BufferedReader bR = new BufferedReader(new InputStreamReader(openFileInput(fname))); 
			 String fContent=""; 
			 
			 while ((content = bR.read()) != -1) { 
			 fContent = fContent+(char)content;; 
			 }
			 ch = Integer.parseInt(fContent);
			 bR.close(); 
			} 
			catch (Exception e) { 
			 Log.d("ERROR", e.toString()); 
			} 
			return ch;
			
	}
	public void reset(){
		
		prison = 0;
		release = 0;
		saveFile(releaseFile, release);
		saveFile(prisonFile, prison);
	}
	
}
	

