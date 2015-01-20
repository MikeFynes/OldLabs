package kari.labs.aa.aaappwidget1;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MyWidgetProvider extends AppWidgetProvider {

    String[] dogs = {
            "Border Terrier",
            "Alaskan Malamute",
            "Finnish Spitz",
            "Portuguese Water Dog",
            "Rottweiler",
            "Beagle",
            "Greyhound",
            "Dachshund"
    };
    
    Integer[] img = {
    		R.drawable.borderterrier,
            R.drawable.alaskanmalamute,
            R.drawable.finnishspitz,
            R.drawable.portuguesewaterdog,
            R.drawable.rottweiler,
            R.drawable.beagle,
            R.drawable.greyhound,
            R.drawable.dachshund
    };
    
    int currInd;
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
			
		
		
	       final int N = appWidgetIds.length;
	       final String DOGGY_INTENT = "kari.labs.aa.aasearch1.DOGGY";

	        // Perform this loop procedure for each App Widget that belongs to this provider
	        for (int i=0; i<N; i++) {
	            int appWidgetId = appWidgetIds[i];
	            RemoteViews rview = new RemoteViews(context.getPackageName(), R.layout.widgetmain);
            
	            Random r = new Random();
	            currInd=r.nextInt(7);
	            
	            rview.setTextViewText(R.id.Tv1, dogs[currInd]);
	            rview.setImageViewResource(R.id.Img1, img[currInd]);
	            final Intent dogActIntent = new Intent(DOGGY_INTENT); 
	            PendingIntent hsIntent = PendingIntent.getActivity(context,
	                  0, dogActIntent, PendingIntent.FLAG_UPDATE_CURRENT);
	            rview.setOnClickPendingIntent(R.id.Img1, hsIntent);
	            
	            appWidgetManager.updateAppWidget(appWidgetId, rview);	            
	        }

	        
	}
	
}
