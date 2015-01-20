package fi.metropolia.kari.ab.lab8;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DecFrag extends Fragment {
	
	private View decView;
	
    private FragListener mListener;
	
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragListener");
        }
    }
    
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        decView = inflater.inflate(R.layout.dec, container, false);
        Button release = (Button) decView.findViewById(R.id.relBtn);
        release.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
            mListener.sendDec("Release Joe");
          }
        });
        Button prison = (Button) decView.findViewById(R.id.priBtn);
        prison.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
            mListener.sendDec("Send Joe to prison");
          }
        });
		return decView;
    }
	

}
