package com.example.android.practiceproj;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;



public class CreditClass extends ActionBarActivity {
	MediaPlayer mp = null;
	
    Button Btn_Menu,Btn_Score;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);
        
	}
	 @Override
	 protected void onResume(){
		 super.onResume();
		 mp=MediaPlayer.create(this, R.raw.androidcredits);
		 mp.setLooping(true);
		 mp.start();
	 }
	 
	 @Override
		protected void onPause(){
		     super.onPause();
		     if(mp!=null){
		    	 mp.stop();
		    	 mp.release();
		    	 mp = null;
		     }
		    }
		    @Override
		protected void onDestroy(){
		      super.onDestroy();
		      if(mp!=null){
		    	  mp.stop();
		          mp.release();
		       	 mp = null;
		         }
		        }
	    
	    
}
