package AI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;
class details{
int id,val;
String place;
	public details(String place,int val)
	
	{
		
		this.place=place;
		this.val=val;
	}
	public String getplace(){
		return place;
	}
	public int getdist(){
		return val;
	
	}
	
}
public class gbfs {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	
	
	//Definition of places and their straight line distances
	details d[]=new details[8];
	d[0]=new details("A",366);
	d[1]=new details("Z",374);
	d[2]=new details("S",253);
	d[3]=new details("T",329);
	d[4]=new details("O",380);
	d[5]=new details("F",170);
	d[6]=new details("R",193);
	d[7]=new details("B",0);
	int mat[][]=new int[8][8];
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			mat[i][j]=0;
		}
		
	}
	//static defintion of connection of places
	//1: connected 0:Not connected.
	mat[0][1]=1;mat[0][2]=1;mat[0][3]=1;
	mat[2][0]=1;mat[2][5]=1;mat[2][4]=1;mat[2][6]=1;
	mat[3][0]=1;
	mat[1][0]=1;
	mat[5][2]=1;mat[5][7]=1;
	mat[7][5]=1;
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			System.out.print(mat[i][j]);
		}
		System.out.println();
	}
	
	
	
	

	
	
	
	    int ind=0,ci=0;
	    int min=999;
	    ArrayList <String>f=new ArrayList<String>();
	    f.add("A");
	    String goal="B";
	    String result="";
	    while(!result.equals(goal)){
	    for(int j=0;j<8;j++){
	    	if(mat[ind][j]==1)
	    	{
	    		if(d[j].getdist()<min){
	    		min=d[j].getdist();
	    		ci=j;
	    		
	    		}
	    	}
	    }
	    
	    
	    result=d[ci].getplace();
	    f.add(d[ci].getplace());
	    ind=ci;
	    System.out.println("The path till now->");
	    for(int disp=0;disp<f.size();disp++)
	    {
	     System.out.print(" "+f.get(disp));
	    }System.out.println();
	    }
	
	
	
}



}