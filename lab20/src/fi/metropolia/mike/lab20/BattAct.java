package fi.metropolia.mike.lab20;

import fi.metropolia.kari.ab.lab16.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class BattAct extends Activity {

	private ImageView bImage;
	
	private TextView bText;
	
	 private BroadcastReceiver bReceiver = new BroadcastReceiver() {
		 
		 public void onReceive(Context context, Intent intent) {
			 int health= intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
			 int icon_small= intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,0);
			 int level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
			 int plugged= intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
			 int scale= intent.getIntExtra(BatteryManager.EXTRA_SCALE,0);
			 int status= intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
			 String technology= intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
			 int temperature= intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
			 int voltage= intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);
		  
			 double v = (double)voltage/1000.0;
			 double t = (double)temperature/10.0;
			 double l = (double)level/scale*100;
			 
			 bText.setText(
					"Health: "+getHealth(health)+"\n"+
					"Level: "+l+"%\n"+
					"Status: "+getStatus(status)+"\n"+
					"Plugged: "+getPlugged(plugged)+"\n"+
					"Technology: "+technology+"\n"+
					"Temperature: "+t+"\u00B0C \n"+
					"Voltage: "+v+"V \n");
			 bImage.setImageResource(icon_small);
		 	}
		 };
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.batt);
		bText = (TextView)findViewById(R.id.tv);
		bImage = (ImageView)findViewById(R.id.iv);
		registerReceiver(this.bReceiver,	new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}

	protected void onPause() {
		if (bReceiver != null) {
			unregisterReceiver(bReceiver);
			bReceiver = null;
		}
		super.onPause();
	}
	
	protected void onStop() {
		if (bReceiver != null) {
			unregisterReceiver(bReceiver);
			bReceiver = null;
		}
		super.onStop();
		
	}
	
	
	private String getHealth(int h) {
		String healthString="Not available";
		switch(h){
		case 1:
			healthString ="Unknown";
			break;
		case 2:
			healthString ="Good";
			break;
		case 3:
			healthString ="Overheat";
			break;
		case 4:
			healthString ="Dead";
			break;
		case 5:
			healthString ="Overvoltage";
			break;
		case 6:
			healthString ="Unspecified Failure";
			break;
		case 7:
			healthString ="Cold";
			break;
		}
		
		return healthString;
	}
	
	private String getStatus(int s){
		String statString="Not available";
		switch(s){
		case 1:
			statString ="Unknown";
			break;
		case 2:
			statString ="Charging";
			break;
		case 3:
			statString ="Discharging";
			break;
		case 4:
			statString ="Not charging";
			break;
		case 5:
			statString ="Full";
			break;
		}
		return statString;
		
	}
	
	private String getPlugged(int p){
		String plugString="Not available";
		switch(p){
		case 0:
			plugString ="Not plugged";
			break;
		case 1:
			plugString ="AC";
			break;
		case 2:
			plugString ="USB";
			break;
		case 4:
			plugString ="Wireless";
			break;

		}
		return plugString;
		
	}
	
}
