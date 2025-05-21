import java.util.*;
public class quicksort{
    static int qcount=0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size");
        int n = s.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        quicksort(a,0,a.length-1);
        System.out.println("Sorted elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nNumber of basic operations: " + qcount);

    }
    public static void quicksort(int[] a,int l,int r){
        if(l<r){
            int s=hoarepartition(a,l,r);
            quicksort(a,l,s);
            quicksort(a, s+1, r);
        }

    }
    public static int hoarepartition(int []a,int l,int r){
        int pivot=a[l];
        int i=l-1,j=r+1;
        while(true){
            do { 
                i++;
                qcount++;
            } while (a[i]<pivot);
            do { 
                j--;
                qcount++;
            } while (a[j]>pivot);
            if(i>=j)break;
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        int temp=a[l];
        a[l]=a[j];
        a[j]=temp;
        return j;
    }
}