package com.example.lab5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertFrag extends DialogFragment{

	private AleListener mListener;
	
	public void onAttach(Activity act){
		super.onAttach(act);
		try{
			mListener = (AleListener) act;
		} catch (ClassCastException e){
			throw new ClassCastException(act.toString() + " must implement AleListener");
		}
		
	} 
	   public Dialog onCreateDialog(Bundle savedInstanceState){
	    	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    	builder.setMessage(mListener.getMsg());
	    	builder.setPositiveButton(R.string.alok, new DialogInterface.OnClickListener(){
	    		public void onClick(DialogInterface dialog, int id) {
	    			mListener.onPosClick();
	    		}
	    	});
	    	
	    builder.setNegativeButton(R.string.alcancel, new DialogInterface.OnClickListener(){
	    	public void onClick(DialogInterface dialog,int id){
	    		mListener.onCancelClick();
	    	}
	    });
	    
	    return builder.create();
	    
	    }
	
}
