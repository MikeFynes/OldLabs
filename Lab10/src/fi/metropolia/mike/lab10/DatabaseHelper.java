package fi.metropolia.mike.lab10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	
	static final String dbName="demoDB";
	static final String hoursTable="Hours";
	static final String colID="UserID";
	static final String colName="UserName";
	static final String colStart="Start Time";
	static final String colStop="Stop Time";
	static final String colTotal="Total Time";



	
	
	public DatabaseHelper(Context context) {
		  super(context, dbName, null,33); 
		  }

	@Override
	public void onCreate(SQLiteDatabase db) {
		  // TODO Auto-generated method stub

				  
				  db.execSQL("CREATE TABLE "+hoursTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+colName+" TEXT, "+
				        colStart+" TEXT, "+colStop+" TEXT, "+colTotal+" TEXT");
				  
				  

				    

				
			
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	}