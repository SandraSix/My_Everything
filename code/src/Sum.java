import java.util.Scanner;

public class Sum {
    public static int sum(int a, int b){
        int result=a|b;
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String str1=str.split(",")[0];
        String str2=str.split(",")[1];
        int a=Integer.parseInt(str1);
        int b=Integer.parseInt(str2);
        sum(a,b);
        }
}
