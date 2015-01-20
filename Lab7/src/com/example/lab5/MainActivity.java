package com.example.lab5;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements AleListener, View.OnClickListener {

		private Button prison, release;
			
		private String prisoner, message="";
		private boolean pris;
		private TextView tv;
		
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        prison = (Button) findViewById(R.id.btnPrison);
        release = (Button) findViewById(R.id.btnRelease);
        
        prisoner = getString(R.string.captured);
        
        prison.setOnClickListener(this);
        release.setOnClickListener(this);
        
        tv = (TextView)findViewById(R.id.TextView02);

        
        
        
  /*      release = (Button) findViewById(R.id.btnRelease);
        release.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
        		Toast.makeText(getApplicationContext(), prisoner + " released!", Toast.LENGTH_SHORT).show();
       }
    }); */
       }
    

    
    
 


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onPosClick() {
		// TODO Auto-generated method stub
		Log.d("BOOB", "I AM A POSITIVE");
		if(pris)
		{
			tv.setText(prisoner + " " + getResources().getString(R.string.prisonReply));
		}
		else
		{
			tv.setText(prisoner + " " + getResources().getString(R.string.releaseReply));
		}
	}


	@Override
	public void onCancelClick() {
		// TODO Auto-generated method stub
		Log.d("BOOB", "I AM A NEGATIVE");
		if(pris)
		{
			tv.setText(prisoner + " " + getResources().getString(R.string.prisonReplyCancel));
		}
		else
		{
			tv.setText(prisoner + " " + getResources().getString(R.string.releaseReplyCancel));
		}
	}




	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void onClick(View v){
		if(v.getId() == R.id.btnPrison){
			pris = true;
			message = getString(R.string.decisionPrison);
		}
		else
		{
			pris = false;
			message = getString(R.string.decisionRelease);
		}
	
		
		DialogFragment ale = new AlertFrag();
		ale.show(getFragmentManager(), "AlertDialogFragment");
	}	
	
	
    
    
}
