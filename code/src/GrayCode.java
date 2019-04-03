import java.util.*;

public class GrayCode {
    public static String[] getGray(int n) {
        // write code here
        String[] result=null;
        if (n==1){
            result[0]="0";
            result[1]="1";
            return result;
        }else{
            getGray(n-1);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] date=getGray(2);
        for (int i=0;i<date.length;i++){
            System.out.print(date[i]+" ");
        }
    }
}