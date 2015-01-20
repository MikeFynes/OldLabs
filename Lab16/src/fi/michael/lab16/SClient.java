package fi.michael.lab16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class SClient implements Runnable{

	private Handler ui;
	
	public SClient(Handler handy){
		ui = handy;
	}
	

	
	@Override
	public void run() {
		try{
			Message msg;
			URL myURL = new URL("http://www.google.com");
			URLConnection myConn = myURL.openConnection(); 


			BufferedReader in = new BufferedReader(new InputStreamReader(myConn.getInputStream()));
			
			String str="";
			String inStr;
			while ((inStr = in.readLine()) !=null){
					str = str + inStr; 
					
			}
			in.close();
			msg = ui.obtainMessage();
			msg.obj = str;
			msg.what = 0;
			ui.sendMessage(msg);
					
		} 
		catch (Exception e){
			Log.e("TCP", "C:Error", e);
			
		}
		
	}

}
