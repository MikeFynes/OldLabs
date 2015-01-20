package kari.test.frag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FragTestActivity extends Activity implements DogListIF {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
    public void onDogSelected(int dpos) {
        DetailsFragment viewer = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
     
        if (viewer == null || !viewer.isInLayout()) {
            Intent showContent = new Intent(getApplicationContext(),
                    DetActivity.class);
            showContent.putExtra("selpos", dpos);
            startActivity(showContent);
        } else {
            viewer.update(dpos);
        }
    }
}