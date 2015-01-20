package michaelfynes.reindeergame;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class ReindeerActivity extends Activity {

	
	 // TROUGHS variables
	public static int NO_OF_TROUGHS = 4;
    int []trough = new int[NO_OF_TROUGHS];
	int troughMax = 100;
	int troughMin = 10;
	
	public int DISTANCE = 100;
	
	public int rDist;
	

	Reindeer myR;
	Wolf myW;
	TextView distanceLeft;
	NumberPicker numberPicker;
	Button btnMove;
	Button btnEat;
	Button btnKick;
	Button btnRestart;
	TextView ammoLeft;
	TextView wolfResult;
	
	
		
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    
        distanceLeft = (TextView) findViewById(R.id.textDistanceResult);
        ammoLeft = (TextView) findViewById(R.id.textAmmoLeft);
        wolfResult = (TextView) findViewById(R.id.textWolfResult);
       //  
        
        // TROUGHS methods
            
//        createArray(NO_OF_TROUGHS);
    	
        createArray(NO_OF_TROUGHS);
  
    	myR = new Reindeer(trough, this);
    	
    
    	myW = new Wolf(this);
    	
    	

    	
    	
    	//DISTANCE
    	
    	distanceLeft.setText(Integer.toString(DISTANCE));
    	ammoLeft.setText(Integer.toString(myR.MAXAMMO));
    	wolfResult.setText(myW.hungerText);
    	
        //SPEED SELECTION BUTTON
        numberPicker = (NumberPicker) findViewById(R.id.speedPick);
        numberPicker.setMaxValue(myR.MAXSPEED);
        numberPicker.setMinValue(myR.MINSPEED);
        
        // Move Button
        btnMove = (Button) findViewById(R.id.btnMove);
        btnMove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				myR.reindeerMove(numberPicker.getValue());
				myW.wolfMove();
				myR.status();
				myW.status();

			}
		});
        // END OF MOVE BUTTON
      
        // EAT BUTTON
       
        btnEat = (Button) findViewById(R.id.btnEat);
        btnEat.setVisibility(View.INVISIBLE);
        btnEat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				myR.eat();
				btnEat.setVisibility(View.INVISIBLE);
				}
			});      
        
      // KICK BUTTON
        btnKick = (Button) findViewById(R.id.btnKick);
        btnKick.setVisibility(View.INVISIBLE);
        btnKick.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				myR.kick();
				}
			});      
        
        
        
        
        // RESET BUTTON
        
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
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
    public void writeDistance(int dist){
    	distanceLeft.setText(Integer.toString(dist));
    	rDist = dist;
    	}
    public void writeAmmo(int ammo){
    	ammoLeft.setText(Integer.toString(ammo));
    }
    public void writeWolf(String hunger){
    	wolfResult.setText(hunger);
    }



    

    
    public void alert (String text) {    
    	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
	// RESET FUNCTION
	
// FUNCTION TO CALL ARRAY OF TROUGHS
	
	public void createArray(int number){
    	// loop begins to fill array with random numbers between 10 and 100
    	for (int i = 0 ; i <trough.length; i++) 
		{ 
		trough [i] = (int) (Math.random () * (troughMax-troughMin) + troughMin); 
		Log.d("Trough Location", Integer.toString(trough[i]));
	
	} // for loop ends
		
	}
	public void reset(){
	createArray(NO_OF_TROUGHS);
	DISTANCE = 100;	
	myR.reset();
	myW.reset();
	}
    
    
}

