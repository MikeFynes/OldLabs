package kari.labs.aa.aalab1start;

import android.app.ListActivity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListAct extends ListActivity 
{
    
	String [] dogs;
    int[] img;

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);
        
        dogs = getResources().getStringArray(R.array.doggies);
        TypedArray ta = getResources().obtainTypedArray(R.array.imgs);
        int len = ta.length();
        img = new int[len];
        for (int i = 0; i < len; i++)
            img[i] = ta.getResourceId(i, 0);
        ArrayAdapter<String> myList = new ArrayAdapter<String>(this,
        		R.layout.listi, R.id.tv, dogs);
        setListAdapter(myList);
    }    
 
    public void onListItemClick(
    ListView parent, View v,
    int position, long id) 
    	{
    		TextView tv = (TextView)findViewById(R.id.Text1);
    		tv.setText("Selection: " + dogs[position]); 
    		ImageView im = (ImageView)findViewById(R.id.im);
    		im.setImageResource(img[position]);
    	}
}