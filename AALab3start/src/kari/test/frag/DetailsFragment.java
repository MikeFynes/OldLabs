package kari.test.frag;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DetailsFragment extends Fragment {
    
	int[] img;
    private ImageView myView = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView =(ImageView) inflater.inflate(R.layout.det, container, false);
        TypedArray ta = getResources().obtainTypedArray(R.array.imgs);
        int len = ta.length();
        img = new int[len];
        for (int i = 0; i < len; i++)
            img[i] = ta.getResourceId(i, 0);
		return myView;
    }
        
    public void update(int index) {
        if (myView != null) {
           myView.setImageResource(img[index]);
        }
    } 
}