package kari.labs.aa.aalab1start;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myArrayAdapter extends ArrayAdapter<String>{
	private final Context ctx;
	private final String[] vals;
	private final int[] ids;
	
	public myArrayAdapter(Context context, String[] values, int[] imgids){
		super(context, R.layout.listi, R.id.tv, values);
		ctx = context;
		vals = values;
		ids = imgids;
	}
	
	public View getView(int position, View rView, ViewGroup parent){
		
		LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(rView == null){
			rView = inflater.inflate(R.layout.listi,  parent, false);
			
		}
		((TextView) rView.findViewById(R.id.tv)).setText(vals[position]);
		
		((ImageView) rView.findViewById(R.id.im)).setImageResource(ids[position]);
		return rView;
	}
	

}
