package com.example.android.practiceproj;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;



public class MainActivity extends ActionBarActivity {
	MediaPlayer mp = null;
	
    Button Btn_Menu,Btn_Score,Btn_Credits,Btn_About;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Btn_Menu=(Button)findViewById(R.id.btn_menu);
        
        Btn_Credits=(Button)findViewById(R.id.btn_credits);
        
        Btn_Score=(Button)findViewById(R.id.highscore_btn);
        
        Btn_About=(Button)findViewById(R.id.btn_aboutus);
        
        Btn_Menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GameMenu();
				
			}
		});
        
        Btn_Score.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HighScore();
			}
		});
        
        Btn_Credits.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Credits();
			}
		});
        
        Btn_About.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				About();
			}
		});
    }
	
	
	
	 @Override
	 protected void onResume(){
		 super.onResume();
		 mp=MediaPlayer.create(this, R.raw.menu);
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
	    
	    
	    
	private void GameMenu()
	{
		Intent gamemenu=new Intent(this,GameMenu.class);
		startActivity(gamemenu);
		
	}
	
	private void HighScore()
	{
		Intent highscore=new Intent(this,HighScoreClass.class);
		startActivity(highscore);
	}
	
	private void Credits()
	{
		Intent credits=new Intent(this,CreditClass.class);
		startActivity(credits);
	}
	

	private void About()
	{
		Intent about=new Intent(this,AboutClass.class);
		startActivity(about);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
}
