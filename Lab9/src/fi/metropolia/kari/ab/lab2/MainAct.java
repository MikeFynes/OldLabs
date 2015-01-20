package fi.metropolia.kari.ab.lab2;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainAct extends Activity {

private TextView txt;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ActionBar bar = getActionBar();
		bar.setHomeButtonEnabled(true);

		txt= (TextView) findViewById(R.id.tv2);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
		}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()) {
		case R.id.prison:
		// txt.setText("Sent to Jail");
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.b1), Toast.LENGTH_SHORT).show();
		break;
		case R.id.release:
	//	txt.setText("Released");
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.b2), Toast.LENGTH_SHORT).show();
		break;

		}
		return true;
		}
	
	
}
