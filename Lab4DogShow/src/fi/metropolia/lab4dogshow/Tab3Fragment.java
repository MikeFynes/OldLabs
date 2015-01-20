package fi.metropolia.lab4dogshow;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tab3Fragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
		LinearLayout myView =(LinearLayout) inflater.inflate(R.layout.tab, container, false);
		TextView tv = (TextView) myView.findViewById(R.id.Tv1);
		ImageView im = (ImageView) myView.findViewById(R.id.Img1);
		tv.setText("Rottie");
		im.setImageResource(R.drawable.rottweiler);
		return myView;
		}
}
