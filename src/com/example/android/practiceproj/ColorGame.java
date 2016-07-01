package com.example.android.practiceproj;







import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.graphics.Color;
import android.os.Bundle;




public class ColorGame extends ActionBarActivity  {
	MediaPlayer mp = null;
	
	MediaPlayer mp1=null;
	
	ImageButton error;
	
	
	ArrayList<Integer> num=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	ArrayList<Integer> num2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	ArrayList<Integer> text1=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	ArrayList<Integer> text2=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	
	Button[] colorbtn=new Button[5];
	
	Button[] colorbtn2=new Button[5];
	
	public int[] numbers=new int[5];
	
	public int[] numbers2=new int[5];
	
	public int[] textrandom1=new int[5];
	
	public int[] textrandom2=new int[5];
	
	public int cont1=0,cont2=0;
	
	public int[]n={0,1,2,3,4};
	
	public int testcont1,testcont2;
	
	public boolean pair=false;
	
	public boolean pair2=false;
	
	public boolean gamerunning=true;
	
	public boolean gamerunning2=true;
	
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
        setContentView(R.layout.color);
        
        error = (ImageButton)findViewById(R.id.img_error);
        

    	db=openOrCreateDatabase("ScoreDb",Context.MODE_PRIVATE,null);
                
        db.execSQL("CREATE TABLE IF NOT EXISTS score(playerscore INTEGER);");
        
        Score=(TextView)findViewById(R.id.textview_score);
        
        Brain[0]=(ImageButton)findViewById(R.id.lifebrain3);
        Brain[1]=(ImageButton)findViewById(R.id.lifebrain2);
        Brain[2]=(ImageButton)findViewById(R.id.lifebrain1);
        
        
        colorbtn[0]=(Button)findViewById(R.id.color_btn1);
        colorbtn[1]=(Button)findViewById(R.id.color_btn3);
        colorbtn[2]=(Button)findViewById(R.id.color_btn5);
        colorbtn[3]=(Button)findViewById(R.id.color_btn7);
        colorbtn[4]=(Button)findViewById(R.id.color_btn9);
        
        colorbtn2[0]=(Button)findViewById(R.id.color_btn2);
        colorbtn2[1]=(Button)findViewById(R.id.color_btn4);
        colorbtn2[2]=(Button)findViewById(R.id.color_btn6);
        colorbtn2[3]=(Button)findViewById(R.id.color_btn8);
        colorbtn2[4]=(Button)findViewById(R.id.color_btn10);  
        
        StartGame();

	}
	
	
	
	
	public void GameEvents()
	{
		  colorbtn[0].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					testcont1=n[0];
					
					cont1=numbers[0];
					
					Checker1();
					
					GameClose();

					
				}
			});
	        
	     
	        colorbtn2[0].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					testcont2=n[0];
					
					cont2=numbers2[0];
					
					Checker2();
				
					GameClose();
					
				}
				
	        });
	        colorbtn[1].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[1];
					
					cont1=numbers[1];
					
					Checker1();
					
					GameClose();
				}
			});
	        
	        colorbtn2[1].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[1];
					
					cont2=numbers2[1];
					
					Checker2();
					
					GameClose();
				}
				
				
				
			});
	        
	        colorbtn[2].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[2];
					
					cont1=numbers[2];
					
					Checker1();
					
					GameClose();
				}
			});
	        
	        colorbtn2[2].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[2];
					
					cont2=numbers2[2];
					
					Checker2();
					
					GameClose();
				}
				
			});
	        
	        colorbtn[3].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[3];
					
					cont1=numbers[3];
					
					Checker1();
					
					GameClose();
				}
			});
	        
	        colorbtn2[3].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[3];
					
					cont2=numbers2[3];
					
					Checker2();
					
					GameClose();
				}
				
			});
	        
	        colorbtn[4].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont1=n[4];
					
					cont1=numbers[4];
					
					Checker1();
					
					GameClose();
				}
			});
	        
	        colorbtn2[4].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					testcont2=n[4];
					
					cont2=numbers2[4];
					
					Checker2();
					
					GameClose();
				}
				
			});    
	        
	}
	
	 @Override
		protected void onPause(){
		     super.onPause();
		     if(mp1!=null){
		    	 mp1.stop();
		    	 mp1.release();
		    	 mp1= null;
		     }
		    }
		    @Override
			 protected void onResume(){
				 super.onResume();
				 mp1=MediaPlayer.create(this, R.raw.easy);
				 mp1.setLooping(true);
				 mp1.start();
			 }
		    @Override
		public void onDestroy(){
		      super.onDestroy();
		      if(mp1!=null){
		    	  mp1.stop();
		          mp1.release();
		       	 mp1 = null;
		         }
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
		
		public void GenerateRandomText1(){
			
			
			
			Random r=new Random();
				
			int ctr=0;
				
			while(text1.size()>0)
				{
				textrandom1[ctr]=text1.remove(r.nextInt(text1.size()));
					ctr++;
				}
			
			}
		
		public void GenerateRandomText2(){
			
			
			
			Random r=new Random();
				
			int ctr=0;
				
			while(text2.size()>0)
				{
				textrandom2[ctr]=text2.remove(r.nextInt(text2.size()));
					ctr++;
				}
			
			}
	
		public void StartGame()
	{
		
		
		error.setVisibility(View.INVISIBLE);
		
		int x=0;
		int y=0;
		
		if(newLife2==0){
			finish();
		}
		
		else{
		
		endscore=ContainerClass.addscore(x);
		
		Score.setText(String.valueOf(endscore));
		

		newlife=ContainerClass.Givelife(y);
			
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
		

		ColumnText1();
		ColumnText2();
		Column1();
		Column2();
		GameEvents();
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
	
	public void ColumnText1()
	{
		GenerateRandomText1();
		for(int x=1;x<6;x++)
		{
			int RandomColor=textrandom1[x-1];
			
			
			switch(RandomColor)
			{
				case 1: 
						colorbtn[x-1].setText("RED");
						break;
				case 2: colorbtn[x-1].setText("BLUE");
						
						break;
				case 3: colorbtn[x-1].setText("GREEN");
						
						colorbtn[x-1].setTextSize(15);
						break;
				case 4:colorbtn[x-1].setText("YELLOW");
						
						colorbtn[x-1].setTextSize(12);
						break;
				case 5: colorbtn[x-1].setText("PINK");
						
						
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
	
	public void ColumnText2()
	{
		GenerateRandomText2();
		for(int x=1;x<6;x++)
		{
			int RandomColor=textrandom2[x-1];
			
			
			switch(RandomColor)
			{
				case 1: 
						colorbtn2[x-1].setText("RED");
						break;
				case 2: colorbtn2[x-1].setText("BLUE");
					
						break;
				case 3: colorbtn2[x-1].setText("GREEN");
						
						colorbtn2[x-1].setTextSize(15);
						break;
				case 4:colorbtn2[x-1].setText("YELLOW");
						
						colorbtn2[x-1].setTextSize(12);
						break;
				case 5: colorbtn2[x-1].setText("PINK");
						
						
						break;
			}
			
		}
	}

	
	public void Checker1(){
		
		if(pair2==true){
			
			if(cont1==cont2){
				mp=MediaPlayer.create(this, R.raw.win);
				mp.start();
				ColorCheck();
				
				
				
				pair2=false;
			}
			else if(cont1!=cont2){
					
				
				int x=0;
				
				life=ContainerClass.GiveLife2(x);
				
				life--;
					
				if(life==0)
					{
						Toast.makeText(ColorGame.this, "GAME OVER", Toast.LENGTH_LONG).show();
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
		
		if(cont1==cont2){
			mp=MediaPlayer.create(this, R.raw.win);
			mp.start();

			ColorCheck();
			
			
			pair=false;
			
			
		}
		else if(cont1!=cont2){
				
			int x=0;
			
			life=ContainerClass.GiveLife2(x);
			
			life--;
				
			if(life==0)
				{
					Toast.makeText(ColorGame.this, "GAME OVER", Toast.LENGTH_LONG).show();
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
		
		else{
	
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
		error.setVisibility(View.VISIBLE);
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
	
	
	db.execSQL("INSERT INTO score VALUES('"+b+"');");
	

	Toast.makeText(ColorGame.this, "DATA ADDED", Toast.LENGTH_LONG).show();
	
}


public int ScoreChecker(int x){
	
	
	Cursor c=db.rawQuery("SELECT*FROM score", null);
	
	while(c.moveToNext()){
    	x=c.getInt(0);
    }
	
	return x;

}

public void GameOver()
{
	GameOver.idscore=1;
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



		
		

