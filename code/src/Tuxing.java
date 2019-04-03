import java.util.Scanner;

public class Tuxing {

    static void print(int n, char c){
        if(n<3 || n>20){
            return;
        }else {
            int col=n/2;
            for(int j=0;j<n;j++){//打印第一行
                System.out.print(c);
            }
            System.out.println("");//换行
            for (int i=0;i<col-2;i++){
                System.out.print(c);
                for (int x=0;x<n-2;x++){
                    System.out.print(" ");
                }
                System.out.println(c);
            }
            for(int j=0;j<n;j++){//打印最后一行
                System.out.print("c");
            }
            System.out.println("");//换行

        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        char a=scanner.next().toCharArray()[0];
        print(n,a);
    }
}
