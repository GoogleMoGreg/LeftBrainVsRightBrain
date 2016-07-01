package com.example.android.practiceproj;

public class ContainerClass {
	
	public static int addscore(int test)
	{
		
		test	=ColorGame.lastscore;
		
		return test;
	}
	
	public static int Givelife(int test2){
		
		test2=ColorGame.LifeFirst;
		return test2;
	
	}
	public static int GiveLife2(int test2)
	{
		
		
		test2=ColorGame.newLife2;
		return test2;
	}
	
	public static int Wordaddscore(int test)
	{
		
		test	=ColorWord.lastscore;
		
		return test;
	}
	
	public static int WordGivelife(int test2){
		
		test2=ColorWord.LifeFirst;
		return test2;
	
	}
	public static int WordGiveLife2(int test2)
	{
		
		
		test2=ColorWord.newLife2;
		return test2;
	}
	
	public static int Shapeaddscore(int test)
	{
		
		test	=ColorShape.lastscore;
		
		return test;
	}
	
	public static int ShapeGivelife(int test2){
		
		test2=ColorShape.LifeFirst;
		return test2;
	
	}
	public static int ShapeGiveLife2(int test2)
	{
		
		
		test2=ColorShape.newLife2;
		return test2;
	}
}