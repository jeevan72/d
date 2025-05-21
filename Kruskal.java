import java.util.Scanner;
public class kruskal{
    public static void main(String[]args){
        int n;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the no. of towns");
        n=s.nextInt();
        int [][]c =new int[n][n]; 
        System.out.println("enter the cost of lying roads between two towns in lakhs");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                c[i][j]=s.nextInt();
                if(c[i][j]==0){
                    c[i][j]=Integer.MAX_VALUE;
                }
            }
            
        }
        krushkal(c,n);
    }
    public static void krushkal(int cost[][],int n){
        int []par=new int[n]; // Parent array for union-find
        for(int i=0;i<n;i++)par[i]=-1; // Initialize all parents as -1
        int a=0,b=0,u=0,v=0,min,mincost=0,ne=0;
        
        // Loop until we have n-1 edges in our MST
        while(ne<n-1){
            min=Integer.MAX_VALUE;
            // Find minimum cost edge
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(cost[i][j]<min){
                        min=cost[i][j];
                        a=u=i;
                        b=v=j;
                    }
                }
            }
            // Find roots of the sets
            while(par[u]!=-1) u=par[u];
                    while(par[v]!=-1) v=par[v];
                    // If including this edge doesn't create a cycle
                    if(u!=v){
                        System.out.println("Cost of laying road from town"+a+"to town "+b+"is "+min+"lakhs");
                        mincost+=min;
                        // Union of two sets
                        if(u<v)par[v]=u;
                        else par[u]=v;
                        ne++;
                    }
                    // Mark the used edge as infinity
                    cost[a][b]=cost[b][a]=Integer.MAX_VALUE;
        }
        System.out.println("Cost of laying entire road network = "+mincost+"lakhs");
    }
}