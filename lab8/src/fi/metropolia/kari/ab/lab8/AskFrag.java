package fi.metropolia.kari.ab.lab8;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AskFrag extends Fragment {
	
	private View askView;	
    private FragListener mListener;
    private TextView tv;    
    
   
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
        askView = inflater.inflate(R.layout.ask, container, false);
        Button button = (Button) askView.findViewById(R.id.askBtn);
        button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
            mListener.getDec();
          }
        });
		return askView;
    }
	
	public void setDec(String str){
        tv = (TextView) askView.findViewById(R.id.askTxt);
		tv.setText(str);
	}
	
}
