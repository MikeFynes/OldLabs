package fi.metropolia.challengeacepted;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View.OnClickListener;




public class MainActivity extends Activity implements OnClickListener {

	private Button btnChallenge;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnChallenge = (Button) findViewById(R.id.btnChallenge);
		btnChallenge.setOnClickListener(this) ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
