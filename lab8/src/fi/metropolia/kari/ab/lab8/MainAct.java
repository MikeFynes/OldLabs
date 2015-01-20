package fi.metropolia.kari.ab.lab8;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainAct extends Activity implements FragListener {

	private AskFrag afrag;
	private DecFrag dfrag;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dfrag = new DecFrag();
		afrag = new AskFrag();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.add(R.id.frag_placeholder, afrag, "AFRAG");
		ft.commit();

    }

	public void getDec() {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.remove(afrag);
		ft.add(R.id.frag_placeholder, dfrag, "DFRAG");
		ft.commit();
		
	}

	public void sendDec(String decision) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.frag_placeholder, afrag);
		ft.commit();
		getFragmentManager().executePendingTransactions();
		afrag.setDec(decision);
	}
    	
}
