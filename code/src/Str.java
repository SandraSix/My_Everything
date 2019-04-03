import java.util.Scanner;

public class Str {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String str=scanner.nextLine();
//        char[] arr=str.toCharArray();
//        for (int i=0;i<arr.length;i++){
//            System.out.print(arr[(arr.length-i-1)]);
//        }

        String str=scanner.nextLine();
        int a=Integer.valueOf(str.split(",")[0]);
        int b=Integer.valueOf(str.split(",")[1]);
        while(a!=b){
            int r1=a/2;
            int r2=b/2;
            if(r1==r2){
                System.out.println(r1);
            }
            a=r1;
            b=r2;
        }
    }
}
