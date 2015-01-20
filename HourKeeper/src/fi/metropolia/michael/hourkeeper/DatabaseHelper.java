package fi.metropolia.michael.hourkeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final int databaseVersion = 1;
	static final String dbName="demoDB";
	static final String hoursTable="hours";
	static final String colID="UserID";
	static final String colName="UserName";
	static final String colStart="StartTime";
	static final String colStop="StopTime";
	static final String colTotal="TotalTime";
	public SQLiteDatabase db;
	MainActivity m;


	
	
	public DatabaseHelper(Context context) {
		  super(context, dbName, null, databaseVersion); 
		  
	 
		  }
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try{
			
			db.execSQL("CREATE TABLE IF NOT EXISTS "+hoursTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+colName+" TEXT, "+
			        colStart+" LONG, "+colStop+" LONG, "+colTotal+" INT)");
		  Log.d("DATABASE","I RAN!"); 
	}
	 catch(Exception e){
		Log.d("SQL", "DID NOT CREATE TABLE");
	}
}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		  
		//db.execSQL("DROP TABLE IF EXISTS "+hoursTable);
		  

		
		//onCreate(db);
		  
		 }
	
	public void insertData(String uname, long start,long stop,int total){
		SQLiteDatabase db=this.getWritableDatabase();
		
		
		
		
			
		 ContentValues cv=new ContentValues();
		   
		   cv.put(colName, uname);
		   cv.put(colStart, start);
		   cv.put(colStop, stop);
		   cv.put(colTotal, total);
		   db.insert(hoursTable, colID, cv);
		  
		
		                     db.close();
	
		                  
	                     Log.d("DATABASE", "INSERTED SUCCESSFULLY!");
	}
	
	public void clearData(){
		SQLiteDatabase db=this.getWritableDatabase();
				db.execSQL("DROP TABLE IF EXISTS "+hoursTable);
				try{
					
					db.execSQL("CREATE TABLE IF NOT EXISTS "+hoursTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+colName+" TEXT, "+
					        colStart+" LONG, "+colStop+" LONG, "+colTotal+" INT)");
				  Log.d("RECREATE","TABLE DROPPED AND RECREATED!"); 
			}
			 catch(Exception e){
				Log.d("SQL", "DID NOT CREATE TABLE");
			}
				db.close();
	}



	}