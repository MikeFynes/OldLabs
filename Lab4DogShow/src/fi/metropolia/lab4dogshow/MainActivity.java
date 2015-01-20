package fi.metropolia.lab4dogshow;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Fragment TF1 = new Tab1Fragment();
		Fragment TF2 = new Tab2Fragment();
		Fragment TF3 = new Tab3Fragment();
		
		String label1 = getResources().getString(R.string.label1);
		
		
		Tab tab1 = actionBar.newTab();
		tab1.setText(label1);
		TListener t1 = new TListener(TF1);
		tab1.setTabListener(t1);
		actionBar.addTab(tab1);
		
		label1 = getResources().getString(R.string.label2);
		
		Tab tab2 = actionBar.newTab();
		tab2.setText(label1);
		TListener t2 = new TListener(TF2);
		tab2.setTabListener(t2);
		actionBar.addTab(tab2);
		
		label1 = getResources().getString(R.string.label3);
		
		Tab tab3 = actionBar.newTab();
		tab3.setText(label1);
		TListener t3 = new TListener(TF3);
		tab3.setTabListener(t3);
		actionBar.addTab(tab3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
