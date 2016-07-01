package com.example.android.practiceproj;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



public class GameOver extends ActionBarActivity {
	MediaPlayer mp = null;
	TextView Score,HighScore;
	ImageButton  highicon;
	ImageButton newto;
	Button Confirm;
	
	SQLiteDatabase db;
	
	public static int ScoreContainer=0;
	
	public static int idscore=0;
	@Override
	 protected void onResume(){
		 super.onResume();
		 mp=MediaPlayer.create(this, R.raw.gameoverpo);
		
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
	    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        newto = (ImageButton)findViewById(R.id.img_newicon);
        
        db=openOrCreateDatabase("ScoreDb",Context.MODE_PRIVATE,null);
        
        Score=(TextView)findViewById(R.id.TextView_Score);
        
        HighScore=(TextView)findViewById(R.id.TextView_HighScore);
        
        Confirm=(Button)findViewById(R.id.Btn_Confirm);
        
        highicon = (ImageButton)findViewById(R.id.img_iconhighscore);
        
        db.execSQL("CREATE TABLE IF NOT EXISTS score(playerscore INTEGER);");
        
        db.execSQL("CREATE TABLE IF NOT EXISTS scoreWord(playerscore INTEGER);");
        
        db.execSQL("CREATE TABLE IF NOT EXISTS scoreShape(playerscore INTEGER);");
        
        
        Cursor c=db.rawQuery("SELECT*FROM score", null);
        
        Cursor c1=db.rawQuery("SELECT*FROM scoreWord", null);
        
        Cursor c2=db.rawQuery("SELECT*FROM scoreShape", null);
        
    	int x=0,y=0,z=0;
    	
    	if(idscore==1)
    	{
    		
    	     while(c.moveToNext()){
    	     	x=c.getInt(0);
    	     }
    	     
    	     if(x>ScoreContainer){
    	     
    	    highicon.setBackgroundResource(R.drawable.highscorecolor);
    	    HighScore.setText(String.valueOf(x));
    	    newto.setVisibility(View.INVISIBLE);
    	     Score.setText(String.valueOf(ScoreContainer));
    	     
    	    
    	     }
    	     else{
    	    	 highicon.setBackgroundResource(R.drawable.highscorecolor);
    	    	   HighScore.setText(String.valueOf(x));
    	    	     
    	    	   newto.setVisibility(View.VISIBLE);
    	    	     Score.setText(String.valueOf(ScoreContainer));
    	    	     
    	    	 
    	     }
    	     
    	     ScoreContainer=0;
    	     idscore=0;
    	     
    	}
    		
    	else if(idscore==2)
    	{
    		
    	     while(c1.moveToNext()){
    	     	y=c1.getInt(0);
    	     }
    	     
    	     if(y>ScoreContainer){
    	    	 highicon.setBackgroundResource(R.drawable.highscorewords);
    	     HighScore.setText(String.valueOf(y));
    	     newto.setVisibility(View.INVISIBLE);
    	     Score.setText(String.valueOf(ScoreContainer));
    	     
    	     }
    	     else{
    	    	 highicon.setBackgroundResource(R.drawable.highscorewords);
    	    	   HighScore.setText(String.valueOf(y));
    	    	   newto.setVisibility(View.VISIBLE);
    	    	     Score.setText(String.valueOf(ScoreContainer));     
    	    	 
    	     }
    	     
    	     ScoreContainer=0;
    	     idscore=0;
    	     
    	}
    	
    	else if(idscore==3)
    	{
    		
    	     while(c2.moveToNext()){
    	     	z=c2.getInt(0);
    	     }
    	     
    	     if(z>ScoreContainer){
    	    	 highicon.setBackgroundResource(R.drawable.highcoreshape);
    	    	 HighScore.setText(String.valueOf(z));
    	    	 newto.setVisibility(View.INVISIBLE);
    	    	 Score.setText(String.valueOf(ScoreContainer));
    	     
    	     }
    	     else{
    	    	 highicon.setBackgroundResource(R.drawable.highcoreshape);
    	    	   HighScore.setText(String.valueOf(z));
    	    	   newto.setVisibility(View.VISIBLE);
    	    	     Score.setText(String.valueOf(ScoreContainer));     
    	    	 
    	     }
    	     
    	     ScoreContainer=0;
    	     idscore=0;
    	     
    	}
    	
    	Confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			
			public void onClick(View v) {
				
				ShowMenu();
			}
		});
        
    }

	 
    
    
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

		ShowMenu();
		return true;
	}

	return super.onKeyDown(keyCode, event);
	}
	
	public void ShowMenu(){
		
		Intent Menu=new Intent(this,GameMenu.class);
		startActivity(Menu);
		finish();
	}
	
	 
	
	
	    

}