package com.example.android.practiceproj;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;



public class GameMenu extends ActionBarActivity {
	MediaPlayer mp = null;

	Button Btn_Color;
	
	Button Btn_Word;
	
	Button Btn_Shape;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        Btn_Color=(Button)findViewById(R.id.btn_color);
        
        Btn_Word=(Button)findViewById(R.id.btn_shape);
        
        Btn_Shape=(Button)findViewById(R.id.btn_shapes);
        
        Btn_Shape.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ShowShape();
			}
		});
        Btn_Color.setOnClickListener(new View.OnClickListener() {
			
        	@Override
			public void onClick(View v) {
			
				ShowColor();
			}
		});
        
        Btn_Word.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ShowWord();
				
			}
		});
        
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
		 protected void onResume(){
			 super.onResume();
			 mp=MediaPlayer.create(this, R.raw.menuto);
			 mp.setLooping(true);
			 mp.start();
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
    	
    private void ShowWord(){
    	Intent Word=new Intent(this,ColorWord.class);
    	startActivity(Word);
    	finish();
    
    }
    
    
    private void ShowColor(){
    	Intent Color=new Intent(this,ColorGame.class);
    	startActivity(Color);
    	finish();
    	
    }
    
    private void ShowShape(){
    	Intent Shape=new Intent(this,ColorShape.class);
    	startActivity(Shape);
    	finish();
    }
    
    
	    
}