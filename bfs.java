import java.util.ArrayList;
import java.util.List;
class operators{
	int[][] parent=new int[3][3];
	int[][] left=new int[3][3];
	int[][] right=new int[3][3];
	int[][] down=new int[3][3];
	int[][] up=new int[3][3];
	int costleft,costright,costdown,costup;
	operators()
	{	
	}
	public operators(int[][] parent, int[][] left, int[][] right, int[][] down,
			int[][] up, int costleft, int costright, int costdown, int costup) {
		super();
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.down = down;
		this.up = up;
		this.costleft = costleft;
		this.costright = costright;
		this.costdown = costdown;
		this.costup = costup;
	}
	operators( int[][] parent)
	{
		for(int l=0;l<3;l++)
		{
			for(int m=0;m<3;m++)
			{
				left[l][m]=parent[l][m];
				right[l][m]=parent[l][m];
				down[l][m]=parent[l][m];
				up[l][m]=parent[l][m];
			}
			
		}	
	}
	public int check(List <int[][]> nodes, int[][]a)
	{
		int counterrr=0,flag=0;
		for( int [][] g : nodes)
		{
			counterrr=0;
			for(int o=0;o<3;o++)
				for(int p=0;p<3;p++)
			{
				if(a[o][p]==g[o][p])
				counterrr++;
			}
			if(counterrr==9){flag=1; break;}
		}
		if(flag==1)
			return 1;
			else
		return 0;
	}
	public int[][] makechildren( int[][] parent, List<int[][]> nodes,int[][] goal)
	{
		int i=0,j=0,temp,flagleft=1000,flagright=1000,flagdown=1000,flagup=1000;
		for(int l=0;l<3;l++)
		{
			for(int m=0;m<3;m++)
			{
				if(parent[l][m]==0)
				{
					i=l;
					j=m;
					break;
				}
			}	
		}
		if(j-1>=0)
		{
			temp=left[i][j-1];
			left[i][j-1]=left[i][j];
			left[i][j]=temp;
			if(check(nodes,left)==0) 
			{
				flagleft=1;
				for(int l=0;l<3;l++)
				{
					for(int m=0;m<3;m++)
					{
						if(left[l][m]!=goal[l][m])
						{
							costleft++;
						}
					}
				}
				nodes.add(left);
				System.out.println("left--");
				bfs.printmatrix(left);
			}			
		}
		if(j+1<=2)
		{
			temp=right[i][j];
			right[i][j]=right[i][j+1];
			right[i][j+1]=temp;
			if(check(nodes,right)==0) 
			{
				flagright=1;
				for(int l=0;l<3;l++)
				{
					for(int m=0;m<3;m++)
					{
						if(right[l][m]!=goal[l][m])
						{
							costright++;
						}
					}
				}
				nodes.add(right);
				System.out.println("right--");
				bfs.printmatrix(right);
				
			}
		}
		if(i-1>=0)
		{
			temp=up[i-1][j];
			up[i-1][j]=up[i][j];
			up[i][j]=temp;
			if(check(nodes,up)==0)
			{
				flagup=1;
				for(int l=0;l<3;l++)
				{
					for(int m=0;m<3;m++)
					{
						if(up[l][m]!=goal[l][m])
						{
							costup++;
						}
					}
				}
				nodes.add(up);
				System.out.println("up--");
				bfs.printmatrix(up);
			}
		}
		if(i+1<=2)
		{
			temp=down[i+1][j];
			down[i+1][j]=down[i][j];
			down[i][j]=temp;
			if(check(nodes,down)==0) 
			{
				flagdown=1;
				for(int l=0;l<3;l++)
				{
					for(int m=0;m<3;m++)
					{
						if(down[l][m]!=goal[l][m])
						{
							costdown++;
						}
					}
				}
				nodes.add(down);
				System.out.println("down--");
				bfs.printmatrix(down);
			}
		}
		int m=minimum(flagleft,flagright,flagup,flagdown,costleft,costright,costup,costdown);
		flagleft=1000;flagright=1000;flagdown=1000;flagup=1000;
		switch(m)
		{
			case 1: return left;
				//break;
			case 2: return right;
				//break;
			case 3: return up;
				//break;
			case 4: return down;
			default: return left;	
		}	
	}

	private int minimum(int flagleft, int flagright,int flagup, int flagdown,int costleft2, int costright2, int costup2,
			int costdown2) {
		// TODO Auto-generated method stub
		costleft2=costleft2+flagleft;
		costright2=costright2+flagright;
		costup2=costup2+flagup;
		costdown2=costdown2+flagdown;
		if (costleft2<=costright2 && costleft2<=costdown2 && costleft2<costup2)
		{
			return 1;
		}
		else if (costright2<=costleft2 && costright2<=costdown2 && costright2<costup2)
		{
			return 2;
		}
		else if (costup2<=costright2 && costup2<=costdown2 && costup2<costleft2)
		{
			return 3;
		}
		else
		return 4;
	}	
}
public class bfs {
	public static void printmatrix(int[][] k)
	{
		for(int i=0;i<k.length;i++)
		{
			for(int j=0;j<k[i].length;j++)
				System.out.print(k[i][j]+"\t");
			System.out.print("\n");
		}	
	}
	public static int compare(int[][] a, int[][] b)
	{
		int count=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				if(a[i][j]==b[i][j])
					count++;
				else
					break;
		}
		if(count==9)
			return 1;
		else 
			return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input =new int[][]
			{ {0, 1 ,3},   {4, 2, 5},
			      {7, 8,6}} ;
		int [][] output=new int[][]
			{{1,2,3},{4,5,6},{7,8,0 }};
		System.out.println("initial state......................");
		bfs.printmatrix(input);
		System.out.println("goal state......................");
		bfs.printmatrix(output);
		System.out.println("\n---state space tree---\nparent");
		bfs.printmatrix(input);
		List<int[][]> nodes=new ArrayList<int[][]>();
		nodes.add(input);
		operators op=new operators(input);
		int k[][]=op.makechildren(input,nodes,output);
		System.out.println("\n\n");
		input=k;
		int count=0;
		while(bfs.compare(input,output)!=1)
		{
			operators h=new operators(input);
			System.out.println("*********************************************************************************\nparent--");
			bfs.printmatrix(input);
			int l[][]=h.makechildren(input,nodes,output);
			input=l;
			count++;
		}
		int cost=0;
		System.out.println("\n \n bfs path");
		for (int [][] o : nodes)
		{
			bfs.printmatrix(o);
			System.out.println("----------");
			cost++;
		}
		System.out.println("cost of the path is "+cost);
	}
}

