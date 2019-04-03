import java.util.Scanner;

public class LCA {
    public static int getLCA(int a, int b) {
        if (a==b){
            return a;
        }else {
            while (a!=b&&a>0&&b>0){
                a=a/2;
                b=b/2;
                if (a==b){
                    return a;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int a= Integer.parseInt(str.split(",")[0]);
        int b= Integer.parseInt(str.split(",")[1]);
        System.out.println(getLCA(a,b));
    }

}
