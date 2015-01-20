/**
 * 
 */
package michaelfynes.reindeergame;

import java.util.Random;

import android.util.Log;
import android.view.View;

/**
 * @author michaef
 *
 */
public class Reindeer extends Animal {
	
	private ReindeerActivity myM;
	

	
	// Reindeer remaining DISTANCE

	public int remainingDistance; 
	final public int MAXAMMO = 100;
	
	public boolean kickSuccess;
	// Reindeer AMMO Variable
	public int ammo;
	
	// ammo to be added after eating
	public int newAmmo;
	
	// checks if eating is possible
	public int eatCheck;
	
	// METHODS -- below is actions taken when new reindeer is created
	public Reindeer (int[] trough, ReindeerActivity m) {
			this.myM = m;


	remainingDistance = myM.DISTANCE;
	myM.writeDistance(remainingDistance);
	
	ammo = MAXAMMO;
	
	
	}
	
	// SPEED method
		public void reindeerMove(int speed) {
			remainingDistance -= speed;
			myM.writeDistance(remainingDistance);
			setAmmo (ammo - (19/4*speed-30/4));
			myM.writeAmmo(ammo);
			
			// EAT ENABLED? if value of remaining distance - trough is equal to or less than 2 (or -2) then eat button is enabled otherwise invisible
		
			
			eatCheck = Math.abs(myM.trough [0] -remainingDistance);
			int tNum = 0;
			for (int i = 0 ; i <myM.trough.length; i++) 
			{ 
				int eatDist = Math.abs(myM.trough [i] - remainingDistance);
					
		
			if(eatDist<= 2){
				tNum = i;
								}
			}
			eatCheck = Math.abs(remainingDistance - myM.trough [tNum]);
			if(eatCheck<=2){
				myM.btnEat.setEnabled(true);
				myM.btnEat.setVisibility(View.VISIBLE);
			}
			else{
				myM.btnEat.setEnabled(false);
				myM.btnEat.setVisibility(View.INVISIBLE);
			}
			
			Log.d("TROUGH DIFF", Integer.toString(eatCheck));
		}

		
		public void kick(){
			myM.btnKick.setVisibility(View.INVISIBLE);
			Random r = new Random();
			int min = 1;
			int max = 100;
			if((r.nextInt(max -min) + min) < 20){
				kickSuccess = true;
				Log.d("WOLF", "I JUST GOT SLAPPED");
			}
				else{
					kickSuccess = false;
				Log.d("WOLF", "HAH MISSED!");
				}
			}
			
			
		
		//EAT FUNCTION USES AMMO SETTER
		public void eat(){
			ammo= ammo + 20;
			setAmmo(ammo);
			myM.writeAmmo(ammo);
			myM.btnEat.setEnabled(false);
		}
		
		// SETTER AND GETTER FOR AMMO
	public int getAmmo() {
		return ammo;
		}
	
	
		public void setAmmo (int a) {
		if (a<this.ammo) {
		this.ammo = a;
	
		}
			}
		
	    public void status(){
			if(ammo<=0){
				myM.alert("You starved!");
				myM.reset();
			}
			else if(remainingDistance<=0){
				myM.alert("You wins!");
				myM.reset();
			}
			
			
			
			}

		
		// RESET FUNCTION
		
		public void reset(){
			ammo = 100;
			remainingDistance = 100;
			myM.writeAmmo(ammo);
			myM.writeDistance(remainingDistance);
			
		}
		
		
}



