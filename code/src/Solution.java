import java.util.ArrayList;
public class Solution {
    public static int[] multiply(int[] A) {
        int[] B=new int[A.length];
        for (int i=0;i<A.length;i++){           //找A中是否有0；
            if(A[i]==0) {
                for (int x=0;x<A.length;x++){   //A中有0，B全为0；
                     B[x]=0;
                }
                return B;
            }
        }
        int sum=1;
        for (int j=0;j<A.length;j++){
            sum*=A[j];
        }
        for (int x=0;x<A.length;x++){   //A中没有0，B全为sum；
            B[x]=sum;
        }
        return B;

    }

    public static void main(String[] args) {
        int[] A=new int[]{1,2,3,0,5,6};
        int[] B=multiply(A);
        for (int i=0;i<B.length;i++){
            System.out.print(B[i]+" ");
        }
    }
}