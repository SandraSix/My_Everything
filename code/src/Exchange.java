import java.util.*;

public class Exchange {
    public static int[] exchangeAB(int[] AB) {
        // write code here
        AB[0]=(AB[0]+AB[1]);
        AB[1]= AB[0]^AB[1];
        AB[0]=AB[0]-AB[1];
        return AB;
    }

    public static void main(String[] args) {
       int[] ab={1,2};
        int[] result=exchangeAB(ab);
            System.out.print(" ["+result[0]+","+result[1]+"]");
    }
}