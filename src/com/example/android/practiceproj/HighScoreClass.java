package com.example.android.practiceproj;

import android.support.v7.app.ActionBarActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;




public class HighScoreClass extends ActionBarActivity {
	MediaPlayer mp = null;
	SQLiteDatabase db;
	
	ImageButton patent;
	
	TextView[] Score=new TextView[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        

        Score[0]=(TextView)findViewById(R.id.highscore_word);
        
        Score[1]=(TextView)findViewById(R.id.highscore_color);
        
        Score[2]=(TextView)findViewById(R.id.highscore_shapes);
        
        patent=(ImageButton)findViewById(R.id.img_dominant);
        
        
        db=openOrCreateDatabase("ScoreDb",Context.MODE_PRIVATE,null);
               
               db.execSQL("CREATE TABLE IF NOT EXISTS score(playerscore INTEGER);");
               
               db.execSQL("CREATE TABLE IF NOT EXISTS scoreWord(playerscore INTEGER);");
               
               db.execSQL("CREATE TABLE IF NOT EXISTS scoreShape(playerscore INTEGER);");
               
               
               Cursor c=db.rawQuery("SELECT*FROM score", null);
               
               Cursor c1=db.rawQuery("SELECT*FROM scoreWord", null);
               
               Cursor c2=db.rawQuery("SELECT*FROM scoreShape", null);
               
           	int x=0,y=0,z=0;
           	
           	int word,color,shape,avg;
    		
            while(c.moveToNext()){
            	x=c.getInt(0);
            }
            	color=x;
            Score[1].setText(String.valueOf(x));
            
            while(c1.moveToNext()){
            	y=c1.getInt(0);
            }
            word=y;
            Score[0].setText(String.valueOf(y));
            
            while(c2.moveToNext()){
            	z=c2.getInt(0);
            }
            shape=z;
            
            avg=(shape+color)/2;
            
            Score[2].setText(String.valueOf(z));
            
            if(word==0||color==0||shape==0){
            	patent.setVisibility(View.INVISIBLE);
            }
            else{
            	patent.setVisibility(View.VISIBLE);
            	
            	if(word>avg){
            		patent.setBackgroundResource(R.drawable.leftdominant);
            	}
            	else if(word<avg){
            		patent.setBackgroundResource(R.drawable.rightdominant);
            	}
            	else {
            		patent.setVisibility(View.INVISIBLE);
            	}
            }
               
    }
    @Override
	 protected void onResume(){
		 super.onResume();
		 mp=MediaPlayer.create(this, R.raw.highscore);

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


