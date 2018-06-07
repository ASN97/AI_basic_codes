import java.util.ArrayList;
import java.util.Scanner;


public class knapsack {
	static int mx;
	static int mx_ind;
	static int max;
	
	public static void main(String[] args)
	{

		
		Scanner sc=new Scanner(System.in);
		int wtlen=4,proflen=4;
		int wt[]=new int[wtlen];
		int prof[]=new int[wtlen];
		//defining
		int i=0,j=0;
		wt[i++]=7;prof[j++]=42;
		wt[i++]=3;prof[j++]=12;
		wt[i++]=4;prof[j++]=40;
		wt[i++]=5;prof[j++]=25;
		ArrayList<Integer> maxed=new ArrayList<Integer>();
		
		int finale[][]=new int[6][6];
		
		finale[0][0]=0;finale[0][1]=0;finale[0][2]=1;finale[0][3]=0;finale[0][4]=0;finale[0][5]=0;
		finale[1][0]=0;finale[1][1]=1;finale[1][2]=0;finale[1][3]=1;finale[1][4]=0;finale[1][5]=0;
		finale[2][0]=1;finale[2][1]=1;finale[2][2]=0;finale[2][3]=0;finale[2][4]=0;finale[2][5]=0;
		finale[3][0]=1;finale[3][1]=0;finale[3][2]=0;finale[3][3]=0;finale[3][4]=0;finale[3][5]=0;
		finale[4][0]=0;finale[4][1]=1;finale[4][2]=1;finale[4][3]=0;finale[4][4]=0;finale[4][5]=0;
		finale[5][0]=0;finale[5][1]=0;finale[5][2]=0;finale[5][3]=1;finale[5][4]=0;finale[5][5]=0;
	  int max=10;
		int mx=0;
		int mx_ind=0;
		
		for( i=0;i<6;i++){
			for( j=0;j<4;j++)
			{
				if(finale[i][j]==1)
				{
					finale[i][4]=finale[i][4]+wt[j];
					finale[i][5]=finale[i][5]+prof[j];
				}
			}
			if(finale[i][4]>max)
			{
				finale[i][5]=0;
			}
			else
			{
				if(finale[i][5]>mx)
				{
					mx=finale[i][5];
					mx_ind=i;
				}
			}
			
		}
		
		
		//display
		for( i=0;i<6;i++){
			for( j=0;j<6;j++)
			{
				System.out.print(" "+finale[i][j]);
				
			}System.out.println();
		}
		
		System.out.println("Max Profit is  is "+mx+" of combo "+mx_ind);
		
		//crossover
		//ind for crossover is 2;
		System.out.println("Crossover results");
		
		int cross=3;int temp;
		for( i=0;i<6;i=i+2){
			for( j=cross;j<4;j++)
			{
				
				temp=finale[i][j];
				finale[i][j]=finale[i+1][j];
				finale[i+1][j]=temp;
				
			}
		}
		update_wp(finale,wt, prof, 6,6, mx, mx_ind);
		for( i=0;i<6;i++){
			for( j=0;j<6;j++)
			{
				System.out.print(" "+finale[i][j]);
				
			}System.out.println();
		}
		
		//mutation:mut=ind for mutation
		int mut=0;
		for( i=0;i<6;i++){
			if(finale[i][mut]==0)
			{
				finale[i][mut]=1;
				}
			else
				if(finale[i][mut]==1)
			{
				finale[i][mut]=0;
				}
		}
		System.out.println("Mutation results");
		update_wp(finale,wt, prof, 6,6,mx,mx_ind);
		
		for( i=0;i<6;i++){
			for( j=0;j<6;j++)
			{
				System.out.print(" "+finale[i][j]);
				
			}System.out.println();
		}
		//System.out.println("Max Profit is  is "+mx+" of combo "+mx_ind);
		
		
		
	}

	public static void update_wp(int[][] finale,int wt[],int prof[], int i, int j, int mx, int mx_ind) {
		// TODO Auto-generated method stub
		max=10;
		int mm=0;
		int mm_ind=0;
		for( i=0;i<6;i++){
			finale[i][4]=0;
			finale[i][5]=0;
			for( j=0;j<4;j++)
			{
				if(finale[i][j]==1)
				{
					finale[i][4]=finale[i][4]+wt[j];
					finale[i][5]=finale[i][5]+prof[j];
				}
			}
			if(finale[i][4]>max)
			{
				finale[i][5]=0;
			}
			else
			{
				if(finale[i][5]>mm)
				{
					mm=finale[i][5];
					mm_ind=i;
				}
			}
			
		}
		if(mm>mx)
		System.out.println("Max Profit after the process  is "+mm+" of combo "+mm_ind);
		else{
			System.out.println("Max Profit after the process  is "+mx+" of combo "+mx_ind);
			
		}
		

		
		
		
	}
	
	}



