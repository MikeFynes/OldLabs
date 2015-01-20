package michaelfynes.reindeergame;

import android.util.Log;
import android.view.View;

public class Wolf extends Animal {

	private ReindeerActivity myM;
	
	public final int WOLFSTART = 120;
	
	public final int WOLFMAXSPEED = 11;
	
	public final int WOLFSLOWSPEED = 4;
	
	public int speed;
	
	public int hungerLevel;
	
	public int wolfDistance;
	
	public int distanceDiff;
	
	public String hungerText;

	
	public Wolf(ReindeerActivity m) {
		this.myM = m;
	// wolf distance method
		wolfDistance = WOLFSTART;
		
		
		
		// HUNGER DETERMINES WOLFS MAX SPEED
	
		hungerLevel =( (int)(Math.random() * 10)); 
		hungerText = "Time to hunt!";
		
		
	}
	public void hunger(){
		
		if(hungerLevel==1){
		speed = (int) (Math.random() * WOLFSLOWSPEED); // by not adding the MINSPEED it allows for a value of 0 meaning wolf can stand still
	}
		else if(hungerLevel==2){
		speed = (int) (Math.random() * (MAXSPEED - MINSPEED) + MINSPEED);

		}
		else if(hungerLevel>=3){
		speed = (int) (Math.random() * (WOLFMAXSPEED - MINSPEED) + MINSPEED);
		
		}
		
	}
		
	public void kick(){
		speed = 0;
	}
	
			public void wolfMove() {
			hunger();
			
			myM.btnKick.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					kick();

				}
			});
	        
			wolfDistance -= speed;
			
			distanceDiff = (wolfDistance - myM.rDist);
			
			// IF WOLF OVERTAKES REINDEER IT WILL MOVE BACKWARDS AND "AMBUSH"
			if(distanceDiff<=0){
				speed = (speed * - 1);
				wolfDistance -= speed;
			}
			
			Log.d("WOLF SPEED", Integer.toString(speed));			
			Log.d("Wolf","This is where wolf is " +wolfDistance);
			
		}
		
		public void kickCheck(){
			if(distanceDiff<= 3){
				myM.btnKick.setVisibility(View.VISIBLE);
			}
			else{
				myM.btnKick.setVisibility(View.INVISIBLE);
			}
		}
		
		
	public void status() {
		kickCheck();
		if(distanceDiff<=-2){
			hungerText ="HueHue Ambush time";
		}
		
		else if(distanceDiff<=2){
			
				myM.alert("You got eaten!");
				myM.reset();
			}
		else if (distanceDiff<=10){
			hungerText="I'm getting close!";
		}
		else if (distanceDiff<=20){
			hungerText="I'm hungry!";
		}
		else if (distanceDiff<=50){
			hungerText="Maybe i should eat";
		}
		myM.writeWolf(hungerText);
			}
	// RESET FUNCTION
	
	public void reset(){
		
		wolfDistance = 120;
		hungerText= "Time to hunt!";
		
		
		
	}
}


