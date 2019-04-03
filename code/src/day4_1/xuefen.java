package day4_1;

import java.util.Scanner;

public class xuefen {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String[] arr1=scanner.nextLine().split(" ");
        String[] arr2=scanner.nextLine().split(" ");
        float[] arry1=new float[arr1.length];
        float[] arry2=new float[arr2.length];
        for (int i=0;i<arr1.length;i++){
            arry1[i]=Float.parseFloat(arr1[i]);
        }
        for (int i=0;i<arr1.length;i++){
            arry1[i]=Float.parseFloat(arr1[i]);
        }

        for (int i=0;i<arry1.length;i++){
            System.out.println(arry1[i]);
        }
    }
}
