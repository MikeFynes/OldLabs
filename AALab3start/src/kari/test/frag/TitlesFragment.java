package kari.test.frag;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {

    int mCurCheckPosition = 0;
	String [] dogs;  
    
    DogListIF mListener;

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        dogs = getResources().getStringArray(R.array.doggies);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
        		android.R.layout.simple_list_item_1,
                dogs));
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DogListIF) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement DogListIF");
        }
    }

    public void onListItemClick(ListView l, View v, int pos, long id) {
        showDetails(pos);
    }


    void showDetails(int index) {

    	mListener.onDogSelected(index);

        }

 } 
