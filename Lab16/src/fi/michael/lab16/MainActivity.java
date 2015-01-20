package fi.michael.lab16;

import java.io.BufferedReader;
import java.net.URL;
import java.io.InputStreamReader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	 ProgressDialog dialog; 
	 TextView res;
	
	private class GetCont extends AsyncTask <URL, Void, String>{

		@Override
		protected String doInBackground(URL... url) {
			String str = "";
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(url[0].openStream()));
				String inStr;
				while((inStr = in.readLine()) != null){
					str= str + inStr; 
								
				}
				in.close();
				
			}
				catch (Exception e){
					Log.e("Connection", "Reading error", e);
				}
			
			return str;
		}
		protected void onPostExecute(String result){
			
			res.setText(result);
			dialog.dismiss();
		}
		
	}
	
	/* private Handler uiHandler = new Handler(){
		public void handleMessage(Message msg){
			if(msg.what == 0 ){
				TextView result = (TextView)findViewById(R.id.sourceCode);
				result.setText((String)msg.obj);
				
			}
		}
	}; */
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		res = (TextView) findViewById(R.id.sourceCode);
		res.setMovementMethod(new ScrollingMovementMethod());
		
	Button myB = (Button)findViewById(R.id.btnGoogleSource);
	myB.setOnClickListener(this);
	
	Button reset = (Button)findViewById(R.id.btnReset);
	reset.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
    		reset();
   }

		
}); 
		
	
	
	
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
	/*	// TODO Auto-generated method stub
	SClient sc = new SClient(uiHandler);
	Thread t = new Thread(sc);
	t.start(); */
		
		try{
			URL myUrl = new URL("http://www.google.com");
			dialog = ProgressDialog.show(this,  "", "Loading, please wait...");
			GetCont myTask = new GetCont();
					myTask.execute(myUrl);
					
		}
		catch(Exception e){
			Log.e("URL", "URL creation ", e);
		}
		
		
		
	}
	private void reset() {
		// TODO Auto-generated method stub
		String txtReset = getResources().getString(R.string.txtReset);
		res.setText(txtReset);
	}
	

}
