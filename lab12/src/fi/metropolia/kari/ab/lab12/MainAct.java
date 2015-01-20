package fi.metropolia.kari.ab.lab12;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.widget.TextView;

public class MainAct extends Activity {

	private String nameStr; 
	private String mailStr;
	private String contStr;
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView cText = (TextView) findViewById(R.id.tv);
		
		Uri uri = ContactsContract.Contacts.CONTENT_URI;   
		Cursor cursor = getContentResolver().query(uri, null, null, null, null);
	    contStr = "";
		while (cursor.moveToNext()) {
			
		       int idIndex = cursor.getColumnIndex( 
		                 ContactsContract.Contacts._ID);
		       String contactId = cursor.getString(idIndex);
		       int nameIndex = cursor.getColumnIndex(
		                 ContactsContract.Contacts.DISPLAY_NAME);
		       nameStr = cursor.getString(nameIndex);
	
		       Cursor emails = getContentResolver().query( 
		    	        ContactsContract.Data.CONTENT_URI, 
		    	        null, 
		    	        ContactsContract.Data.CONTACT_ID +
		    	             " = "  + contactId + " AND " + ContactsContract.Data.MIMETYPE + "='" + Email.CONTENT_ITEM_TYPE+"'", 
		    	        null, 
		    	        null);
		       mailStr = "";
		  
		       while (emails.moveToNext()) { 
		    	   mailStr = mailStr + " Email: " + emails.getString(emails.getColumnIndex(
		      	         ContactsContract.Data.DATA1));                  
	        	    }
	           emails.close();
	           if (mailStr != ""){
	        	   contStr = contStr + "Name: " + nameStr + mailStr + "\n";
	           }
		} 
	      
		cursor.close();
		cText.setText(contStr);
	}

}
