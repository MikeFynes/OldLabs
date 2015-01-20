package kari.test.frag;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class DetActivity extends Activity {

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                finish();
                return;
              }
          
            
            setContentView(R.layout.detfrag);            
            Intent mIntent = getIntent();
            int selInd = mIntent.getIntExtra("selpos", 0);
            DetailsFragment viewer = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);             
            viewer.update(selInd);
        }
    	
}
