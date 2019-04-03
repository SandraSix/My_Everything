package day3_30;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Guai {
    public static int yueshu(int a,int b){
        int yueshu=1;
        if (a<b){
            int c=a;
            a=b;
            b=c;
        }
        if (a>=b){
            int[] arr=new int[b+1];
            for (int y=0;y<arr.length;y++){
                arr[y]=1;
            }
            for (int i=1;i<=b;i++){     //找到b的约数
                if (b%i==0){
                    arr[i]=i;
                }
            }
            for (int n=0;n<arr.length;n++){
                int ye=1;
                if (a%(arr[n])==0){
                    ye=arr[n];
                }
                if (yueshu<ye){
                    yueshu=ye;
                }
            }

        }
        return yueshu;
    }

    public static int tili(int n,int x,int[] arr){
        for (int i=0;i<n;i++){
            if (arr[i]<=x){
                x+=arr[i];
            }else {
                int yueshu=yueshu(arr[i],x);
                x+=yueshu;
            }

        }
        return x;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int x=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            System.out.println(tili(n,x,arr));
        }

    }
}
