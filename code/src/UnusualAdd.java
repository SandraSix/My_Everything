import java.util.*;

public class UnusualAdd {
    public static int addAB(int A, int B) {
        // write code here
        int result= (A^B)|(A <<1);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String str1=str.split(",")[0];
        String str2=str.split(",")[1];
        int A=Integer.parseInt(str1);
        int B=Integer.parseInt(str2);
        System.out.println(A+" "+B);
        addAB(A,B);
    }
}
