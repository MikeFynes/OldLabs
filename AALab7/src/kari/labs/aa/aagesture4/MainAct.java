package kari.labs.aa.aagesture4;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class MainAct extends Activity implements OnTouchListener {


	private ScaleGestureDetector mySDetector;
	private GestureDetector myGDetector;
    ImageView im;
    LinearLayout ll;
    float mScale=1f;
    boolean pumidog=true;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        im = (ImageView)findViewById(R.id.Img1);
        ll = (LinearLayout)findViewById(R.id.ll1);
		im.setImageResource(R.drawable.pumi);
        ll.setOnTouchListener(this);

		myGDetector = new GestureDetector(this, new SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent e) {
            	if(pumidog) {
            		im.setImageResource(R.drawable.borderterrier);
            		pumidog=false;
            	} else {
            		im.setImageResource(R.drawable.pumi);
            		pumidog=true;            		
            	}
            	return true;
            }});

        mySDetector = new ScaleGestureDetector(this, new SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector detector) {
                mScale *= detector.getScaleFactor();
                mScale = Math.max(0.1f, Math.min(mScale, 2.0f));
        		im.setScaleX(mScale);
        		im.setScaleY(mScale);
                return true;

            }});
    }

	public boolean onTouch(View v, MotionEvent event) {
		mySDetector.onTouchEvent(event);
		myGDetector.onTouchEvent(event);
	    return true;
	}

}
