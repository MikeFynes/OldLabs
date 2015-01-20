package fi.metropolia.startuptest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    Button btn1 = (Button) findViewById(R.id.btn1);
	    btn1.setOnClickListener(new OnClickListener() {



			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	            finish();
	            System.exit(0);
			}
	    });
	    
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}
