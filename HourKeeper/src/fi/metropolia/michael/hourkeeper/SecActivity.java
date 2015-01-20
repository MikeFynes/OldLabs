package fi.metropolia.michael.hourkeeper;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;





import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends MainActivity implements AleListener, OnClickListener {

	Button btnBack, btnClear;
	private TableLayout tableLayout;
	private String user;
	private TextView userName;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sec_activity);
		
		
		Button backButton = (Button)findViewById(R.id.btnBack);
		backButton.setOnClickListener(this);
		Button clearButton = (Button)findViewById(R.id.btnClear);
		clearButton.setOnClickListener(this);
	
		
		
		
		SharedPreferences prefGet = getSharedPreferences(PREF1, Activity.MODE_PRIVATE); 
        user = prefGet.getString("Username", "");
        Log.d("SEC ACTIVITY USERNAME GRAB", "USERNAME IS: "+user );
		// showHours(user);
        userName = (TextView) findViewById(R.id.userName);
        userName.setText(user);
        
        
    	// FINDS TABLE LAYOUT
		tableLayout = (TableLayout)findViewById(R.id.tableLayout);
        
        
        
     // OPENS DATABASE TELLS IT WHAT NEEDS TO BE READ	
   	 Cursor cursor = d.getReadableDatabase().rawQuery("SELECT * FROM hours WHERE UserName = ?", new String[]{user});

   	 int rows = cursor.getCount();
   	 

   	  cursor.moveToFirst();

   	  // outer for loop
   	  for (int i = 0; i < rows; i++) {

   	   TableRow row = new TableRow(this);
   	   row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
   	   
   	   
   	   // inner for loop
   	//   for (int j = 0; j < cols; j++) {}
   	   
   	   
   
  	    

   	    
    	   // START TIME COLUMN
   	    TextView tv2 = new TextView(this);
   	    tv2.setTextSize(12);
   	    tv2.setPadding(2, 0, 2, 0);
   	   
   	    long startDate = cursor.getLong(2);
   	   	SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH);
		sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
		String firstDate = sdf1.format(startDate);
    	tv2.setText(firstDate);
   	    
    	   // STOP TIME COLUMN
   	    TextView tv3 = new TextView(this);
   	    tv3.setTextSize(12);
   	    tv3.setPadding(2, 0, 2, 0);
   	    
   	    long stopDate = cursor.getLong(3);
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH);
		sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
		String lastDate = sdf2.format(stopDate);
    	tv3.setText(lastDate);
   	    
    	   // TOTAL TIME COLUMN
   	    TextView tv4 = new TextView(this);
   	    tv4.setTextSize(12);
   	    tv4.setPadding(2, 0, 2, 0);
   	  
   	    tv4.setTypeface(tv4.getTypeface(), Typeface.BOLD);
   	    tv4.setText(oldTime(cursor.getInt(4)));
   	    
   	  
   	      	    	
  
   	    row.addView(tv2);
   	    row.addView(tv3);
   	    row.addView(tv4);

   	   

   	   cursor.moveToNext();

   	   tableLayout.addView(row);
   	   
   	   
   	 // DIALOGUE FRAGMENT

   	   
   	   

   	  }
   	  

   			   
   			 
   			 
   		//	CLOSES READ STATE CLOSES DB
   			
   			cursor.close();
   			d.close();
	}
	
	
	
		public void onClick(View v){
			switch(v.getId()){
			case R.id.btnBack:
				finish();
				
				break;
				
			case R.id.btnClear:
				getString(R.string.confirmClear);
				DialogFragment ale = new AlertFrag();
				ale.show(getFragmentManager(), "AlertDialogFragment");
				
				
				
			}
			}
		
		public void onPosClick() {
			// TODO Auto-generated method stub
			Log.d("BOOB", "I AM A POSITIVE");
			
				d.clearData();
				Toast.makeText(this, "All data cleared!", Toast.LENGTH_SHORT).show();
	
				
			}
		



		@Override
		public void onCancelClick() {
			// TODO Auto-generated method stub
			Toast.makeText(this, "No data cleared", Toast.LENGTH_SHORT).show();
			
		}



		@Override
		public String getMsg() {
			// TODO Auto-generated method stub
			String message = getString(R.string.confirmClear);
			return message;
		}
		
		
		
}
		
	

		
	

