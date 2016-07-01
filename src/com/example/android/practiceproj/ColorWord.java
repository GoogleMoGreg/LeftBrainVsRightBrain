package com.example.android.practiceproj;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;




public class ColorWord extends ActionBarActivity  {
	MediaPlayer mp = null;
	MediaPlayer mp1=null;

	ImageButton error2;
	
	ArrayList<Integer> num=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	ArrayList<Integer> num2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

	ArrayList<Integer> word=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	ArrayList<Integer> word2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	Button[] colorbtn=new Button[5];
	
	Button[] colorbtn2=new Button[5];
	
	public int[] numbers=new int[5];
	
	public int[] numbers2=new int[5];
	
	public int[] wordnumbers=new int[5];
	
	public int[] wordnumbers2=new int[5];
	
	public int cont1=0,cont2=0,cont3=0,cont4=0;
	
	public int testcont1,testcont2;
	
	public boolean pair=false;
	
	public boolean pair2=false;
	
	public int[]n={0,1,2,3,4};
	
	public boolean close=true;
	
	ImageButton[] Brain=new ImageButton[3];

	public int score=0;
	
	public static int lastscore=0;
	
	public int finalscore=0;
	
	public int endscore=0;
	
	public int life=3;
	
	public int newlife=3;
	
	public int lastlife;
	
	public static int LifeFirst=3;
	
	public static int newLife2=3;

	
	SQLiteDatabase db;
	
	TextView Score;
	
	
	@Override
	
	
    protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);
        
        error2 = (ImageButton)findViewById(R.id.img_error2);
        
        db=openOrCreateDatabase("ScoreDb",Context.MODE_PRIVATE,null);
        
        db.execSQL("CREATE TABLE IF NOT EXISTS scoreWord(playerscore INTEGER);");
        
        Brain[0]=(ImageButton)findViewById(R.id.wordbrain_3);
        Brain[1]=(ImageButton)findViewById(R.id.wordbrain_2);
        Brain[2]=(ImageButton)findViewById(R.id.img_error3);
        
        Score=(TextView)findViewById(R.id.TextView_Score);
        
        colorbtn[0]=(Button)findViewById(R.id.shape_btn1);
        colorbtn[1]=(Button)findViewById(R.id.shape_btn3);
        colorbtn[2]=(Button)findViewById(R.id.shape_btn5);
        colorbtn[3]=(Button)findViewById(R.id.shape_btn7);
        colorbtn[4]=(Button)findViewById(R.id.shape_btn9);
        
        colorbtn2[0]=(Button)findViewById(R.id.shape_btn2);
        colorbtn2[1]=(Button)findViewById(R.id.shape_btn4);
        colorbtn2[2]=(Button)findViewById(R.id.shape_btn6);
        colorbtn2[3]=(Button)findViewById(R.id.shape_btn8);
        colorbtn2[4]=(Button)findViewById(R.id.shape_btn10);  
        
        StartGame();
        
	}
	
	public void GenerateRandom(){
		
		Random r=new Random();
			
		int ctr=0;
			
		while(num.size()>0)
			{
				numbers[ctr]=num.remove(r.nextInt(num.size()));
				ctr++;
			}
		
		}
	
	public void GenerateRandom2(){
		
		Random r=new Random();
			
		int ctr=0;
			
		while(num2.size()>0)
			{
				numbers2[ctr]=num2.remove(r.nextInt(num2.size()));
				ctr++;
			}
		
		}
	public void GenerateRandomWord(){
		
		Random r=new Random();
			
		int ctr=0;
			
		while(word.size()>0)
			{
				wordnumbers[ctr]=word.remove(r.nextInt(word.size()));
				ctr++;
			}
		
		}
	
	public void GenerateRandomWord2(){
		
		Random r=new Random();
			
		int ctr=0;
			
		while(word2.size()>0)
			{
				wordnumbers2[ctr]=word2.remove(r.nextInt(word2.size()));
				ctr++;
			}
		
		
		}
	public void Column1()
	{
		GenerateRandom();
		for(int x=1;x<6;x++)
		{
			int RandomColor=numbers[x-1];
			
			switch(RandomColor)
			{
				case 1: colorbtn[x-1].setTextColor(Color.RED);
						break;
				case 2: colorbtn[x-1].setTextColor(Color.BLUE);
						break;
				case 3: colorbtn[x-1].setTextColor(Color.GREEN);
						break;
				case 4: colorbtn[x-1].setTextColor(Color.YELLOW);
						break;
				case 5: colorbtn[x-1].setTextColor(Color.MAGENTA);
						break;
			}
			
		}
	
	}
	
	public void Column2()
	{
		GenerateRandom2();
		for(int x=1;x<6;x++)
		{
			int RandomColor=numbers2[x-1];
			
			
			switch(RandomColor)
			{
			case 1: colorbtn2[x-1].setTextColor(Color.RED);
			break;
	case 2: colorbtn2[x-1].setTextColor(Color.BLUE);
			break;
	case 3: colorbtn2[x-1].setTextColor(Color.GREEN);
			break;
	case 4: colorbtn2[x-1].setTextColor(Color.YELLOW);
			break;
	case 5: colorbtn2[x-1].setTextColor(Color.MAGENTA);
			break;
			}
			
		}

	}
	
	public void ColumnWords()
	{
		GenerateRandomWord();
		for(int x=1;x<6;x++)
		{
			int RandomColor=wordnumbers[x-1];
			
			switch(RandomColor)
			{
				case 1: colorbtn[x-1].setText("RED");
						break;
				case 2: colorbtn[x-1].setText("BLUE");
						break;
				case 3: colorbtn[x-1].setText("GREEN");
						colorbtn[x-1].setTextSize(15);
						break;
				case 4: colorbtn[x-1].setText("YELLOW");
						colorbtn[x-1].setTextSize(15);
						break;
				case 5: colorbtn[x-1].setText("PINK");
						break;
			}
			
		}
	}
	
	public void ColumnWords2()
	{
		GenerateRandomWord2();
		for(int x=1;x<6;x++)
		{
			int RandomColor=wordnumbers2[x-1];
			
			switch(RandomColor)
			{
				case 1: colorbtn2[x-1].setText("RED");
						break;
				case 2: colorbtn2[x-1].setText("BLUE");
						break;
				case 3: colorbtn2[x-1].setText("GREEN");
						colorbtn2[x-1].setTextSize(15);
						break;
				case 4: colorbtn2[x-1].setText("YELLOW");
						colorbtn2[x-1].setTextSize(15);
						break;
				case 5: colorbtn2[x-1].setText("PINK");
						break;
			}
			
		}
	}
	
	public void StartGame(){
		
		int x=0;
		int y=0;
		
		if(newLife2==0){
			finish();
		}
		
		else{
		
		endscore=ContainerClass.Wordaddscore(x);
		
		Score.setText(String.valueOf(endscore));
		

		newlife=ContainerClass.WordGivelife(y);
			
		newLife2=newlife;
		
		if(newLife2==3)
		{
		
			Brain[0].setVisibility(View.VISIBLE);
			Brain[1].setVisibility(View.VISIBLE);
			Brain[2].setVisibility(View.VISIBLE);
			}
		else if(newLife2==2)
		{
		
			Brain[0].setVisibility(View.INVISIBLE);
			Brain[1].setVisibility(View.VISIBLE);
			Brain[2].setVisibility(View.VISIBLE);
			}
		else if(newLife2==1)
		{
		
			Brain[0].setVisibility(View.INVISIBLE);
			Brain[1].setVisibility(View.INVISIBLE);
			Brain[2].setVisibility(View.VISIBLE);
			}
		
		error2.setVisibility(View.INVISIBLE);
		Column1();
		ColumnWords();
		Column2();
		ColumnWords2();
		GameEvents();
		}
	}
	
	public void GameEvents()
	{
		  colorbtn[0].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					testcont1=n[0];
					cont3=wordnumbers[0];
					
					Checker1();
					
					GameClose();
					
					
				}
			});
	        
	     
	        colorbtn2[0].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					testcont2=n[0];
					
					cont4=wordnumbers2[0];
					
					Checker2();
					
					GameClose();
				
					
					
				}
				
	        });
	        colorbtn[1].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[1];
					
					
					cont3=wordnumbers[1];
					
					Checker1();
					
					GameClose();
					
					
				}
			});
	        
	        colorbtn2[1].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[1];
					
					
					cont4=wordnumbers2[1];
					
					Checker2();
					
					GameClose();
				
				}
				
				
				
			});
	        
	        colorbtn[2].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[2];
					
					
					cont3=wordnumbers[2];
					
					Checker1();
					
					GameClose();
				
				}
			});
	        
	        colorbtn2[2].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[2];
					
					
					cont4=wordnumbers2[2];
					
					Checker2();
					
					GameClose();
				}
				
			});
	        
	        colorbtn[3].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[3];
					
					cont3=wordnumbers[3];
					
					Checker1();
					
					GameClose();
					
				}
			});
	        
	        colorbtn2[3].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[3];
					
					
					cont4=wordnumbers2[3];
					
					Checker2();
					
					GameClose();
				}
				
			});
	        
	       
	        
	        colorbtn[4].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[4];
					
					
					cont3=wordnumbers[4];
					
					Checker1();
					
					GameClose();
					
					
				}
			});
	        
	        colorbtn2[4].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[4];
					
					
					cont4=wordnumbers2[4];
					
					Checker2();
					
					GameClose();
				}
				
			});    
	        
	}
	 @Override
   	 protected void onResume(){
   		 super.onResume();
   		 mp1=MediaPlayer.create(this, R.raw.normal);
   		mp1.setLooping(true);
   		mp1.start();
   	 }

   	    @Override
   	protected void onPause(){
   	     super.onPause();
   	     if(mp1!=null){
   	    	mp1.stop();
   	    	mp1.release();
   	    	mp1 = null;
   	     }
   	    }
   	    
   	    @Override
   	protected void onDestroy(){
   	      super.onDestroy();
   	      if(mp1!=null){
   	    	mp1.stop();
   	    	mp1.release();
   	    	mp1 = null;
   	         }
   	        }
	
   	 public void Checker1(){
 		
 		if(pair2==true){
 			
 			if(cont3==cont4){
 				mp=MediaPlayer.create(this, R.raw.win);
 				mp.start();
 				ColorCheck();
 				
 				
 				
 				pair2=false;
 			}
 			else if(cont3!=cont4){
 					
 				
 				int x=0;
 				
 				life=ContainerClass.WordGiveLife2(x);
 				
 				life--;
 					
 				if(life==0)
 					{
 						Toast.makeText(ColorWord.this, "GAME OVER", Toast.LENGTH_LONG).show();
 						Closing();
 					}
 					
 					else{
 					GameClose2();
 					}
 					
 			}
 			
 		}
 		else{
 				pair=true;
 		}
 	}
	
   	public void Checker2(){
   		
   		if(pair==true){
   			
   			if(cont3==cont4){
   				mp=MediaPlayer.create(this, R.raw.win);
   				mp.start();

   				ColorCheck();
   				
   				
   				pair=false;
   				
   				
   			}
   			else if(cont3!=cont4){
   					
   				int x=0;
   				
   				life=ContainerClass.WordGiveLife2(x);
   				
   				life--;
   					
   				if(life==0)
   					{
   						Toast.makeText(ColorWord.this, "GAME OVER", Toast.LENGTH_LONG).show();
   						Closing();
   					}
   					
   					else{
   					GameClose2();
   					}
   			}
   		}
   		else {
   				pair2=true;
   		}
   		
   	}
	public void ColorCheck(){
		
		colorbtn[testcont1].setBackgroundResource(R.drawable.check);
		colorbtn[testcont1].setText("");
		colorbtn[testcont1].setEnabled(false);
		
		colorbtn2[testcont2].setBackgroundResource(R.drawable.check);
		colorbtn2[testcont2].setText("");
		colorbtn2[testcont2].setEnabled(false);
	}
	
public boolean GameChecker(){
		
		if(colorbtn[0].isEnabled()||colorbtn2[0].isEnabled()||colorbtn[1].isEnabled()||colorbtn2[1].isEnabled()
				||colorbtn[2].isEnabled()||colorbtn2[2].isEnabled()||colorbtn[3].isEnabled()||colorbtn2[3].isEnabled()
				||colorbtn[4].isEnabled()||colorbtn2[4].isEnabled()){
				
				return true;
			
		}
		
		else {
	
				return false;
		}

	}

	
	public void GameClose()

{
	
	if(GameChecker()==false)
	{
		mp=MediaPlayer.create(this, R.raw.winner);
		mp.start();	
		
		if(endscore!=0)
		{
			score=endscore;
		}
		score++;
		lastscore=score;
		Score.setText(String.valueOf(score));
		Intent i=getIntent();
		finish();
		startActivity(i);
	}
	
}
	
		public void GameClose2()

{
	mp=MediaPlayer.create(this, R.raw.error);
	mp.start();
	error2.setVisibility(View.VISIBLE);
	LifeFirst=life;
	
	Intent i=getIntent();
	finish();
	startActivity(i);
	
	
}
	
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

			Closing2();
			return true;
		}

		return super.onKeyDown(keyCode, event);
		}



	public void Closing(){
		
		int a=0;
		
		if(endscore>ScoreChecker(a)){
			StoreScore();
			GameOver.ScoreContainer=endscore;
			newLife2=3;
			newlife=3;
			LifeFirst=3;
			lastscore=0;
			GameOver();
		}
		else{
			GameOver.ScoreContainer=endscore;
			newlife=3;
			newLife2=3;
			LifeFirst=3;
			lastscore=0;
			GameOver();}
			
		}

	public void Closing2(){
		newLife2=3;
		newlife=3;
		LifeFirst=3;
		lastscore=0;
		Menu();
	}


	public void StoreScore(){
		
		int b=endscore;
		
		db.execSQL("INSERT INTO scoreWord VALUES('"+b+"');");
		
		Toast.makeText(ColorWord.this, "DATA ADDED", Toast.LENGTH_LONG).show();
	}


	public int ScoreChecker(int x){
		
		
		Cursor c=db.rawQuery("SELECT*FROM scoreWord", null);
		
		while(c.moveToNext()){
	    	x=c.getInt(0);
	    }
		
		return x;

	}
	
	public void GameOver(){
		GameOver.idscore=2;
		Intent GameOver=new Intent(this,GameOver.class);
			startActivity(GameOver);
			finish();
		}
	public void Menu(){
		
		Intent GameMenu=new Intent(this,GameMenu.class);
		startActivity(GameMenu);
		finish();
		}
		
	
}	
