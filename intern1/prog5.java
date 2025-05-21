import java.util.*;
public class prog5{
        public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter the number of cities");
            int n=s.nextInt();
            int [][]cost=new int[n][n];
            System.out.println("Enter the cost matrix ");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cost[i][j]=s.nextInt();
                    if(cost[i][j]==0){
                        cost[i][j]=Integer.MAX_VALUE;
                    }
                }
            }
            System.out.println("Enter the source city");
            int source=s.nextInt();
            if(source >= n || source < 0) {
                System.out.println("Invalid source city. Must be between 0 and " + (n-1));
                return;
            }
            prims(n,cost,source);
            s.close();
        }
        public static void prims(int n,int [][]cost,int source){
            int tver[]=new int[n];
            int min,a=0,b=0,mincost=0,ne=0;
            tver[source]=1;
            while(ne<n-1){
                min=Integer.MAX_VALUE;
                for(int i=0;i<n;i++){
                    if(tver[i]==1){
                        for(int j=0;j<n;j++){
                            if(tver[j]==0 && cost[i][j]<min){
                                min=cost[i][j];
                                a=i;
                                b=j;
                            }
                        }
                    }
                }
                if(min == Integer.MAX_VALUE) {
                    System.out.println("Graph is not connected");
                    return;
                }
                tver[b]=1;
                mincost+=min;
                ne++;
                System.out.println("the cost from city "+a+" to city "+b+" is:"+min);
                
            }
            System.out.println("total minimum cost: "+mincost);
        }

}