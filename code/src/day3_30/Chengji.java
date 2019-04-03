package day3_30;

import java.util.Scanner;

public class Chengji {
    public static int q(int n,int[] arr,int a,int b ){    //查询
        int max=arr[a];
        int start=a-1;
        int end=b-1;
        for (int i=start;i<=end;i++){
            if (arr[start]>arr[end]){
                max=arr[start];
            }
        }
        return max;
    }
    public static void u(int n,int[] arr,int a,int b ){   //修改
        int start=a-1;
        arr[start]=b;
    }
    public static void caozuo(int n,int m,int[] arr,char c,int a,int b ){
        for (int i=0;i<m;i++){
            if (c=='Q'){
                int max=q(n,arr,a,b);
                System.out.println(max);
            }
            if (c=='U'){
                u(n,arr,a,b);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
////    int n=scanner.nextInt();
////    int m=scanner.nextInt();
////        System.out.println(n+" "+m+" ");
////    int[] arr=new int[n];
////        for (int i=0;i<n;i++){
////        arr[i]=scanner.nextInt();
////        System.out.println(arr[i]);
////    }
////
////    char[] arr1=scanner.nextLine().toCharArray();
////    char ch=arr1[0]; //操作选项字符
////    char a=arr1[2];
////    char b=arr1[4];
////            System.out.println(ch+" "+a+" "+b);
        int n=5;
        int m=3;
        int[] arr={1,2,3,4,5};
        char ch='Q';
        int a=3;
        int b=5;
        caozuo(n,m,arr,ch,a,b);

}
}
