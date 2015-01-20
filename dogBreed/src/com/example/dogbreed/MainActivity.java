package com.example.dogbreed;


import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.DialogFragment;

public class MainActivity extends ListActivity {

	
	 String[] dogs = { 
	 "Border Terrier", 
	 "Alaskan Malamute", 
	 "Finnish Spitz", 
	 "Portuguese Water Dog", 
	 "Rottweiler", 
	 "Beagle", 
	 "Greyhound", 
	 "Dachshund" 
	 } ;
	 
	 String[] files = { 
	 "border_terrier", 
	 "alaskan_malamute", 
	 "finnish_spitz", 
	 "portuguese_water_dog", 
	 "rottweiler", 
	 "beagle", 
	 "greyhound", 
	 "dachshund" 
	 } ;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> myList = new ArrayAdapter<String>(this, 
        		 R.layout.listitem, R.id.tv, dogs); 
        		 setListAdapter(myList); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onListItemClick( 
    		 ListView parent, View v, 
    		 int position, long id) 
    		 { 
    		
    		 TextView tv = (TextView)findViewById(R.id.Text1);
    		 ImageView iv = (ImageView) findViewById(R.id.Image1) ;
    		 
    		 
    		 
    		 
    		
    		 
    		 int imageResource = getResources().getIdentifier(files[position], "drawable", getPackageName());
    		 
    		 tv.setText("Selection: " + dogs[position]); 
    		 iv.setImageResource(imageResource);
    		 } 

    
    
}

