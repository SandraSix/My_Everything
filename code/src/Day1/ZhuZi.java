package Day1;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Scanner;

public class ZhuZi {
    public static void number(char[] arr, char[] arr2) {
        //arr1是摊主给出的  arr2是想要的珠子
        int sum = 0;
        char[] arr1 = arr;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i=0;
        int j=0;
        for (i = 0; i < len2; i++) {
            char n = arr2[i];
            for (j = 0; j < len1; j++) {
                char m = arr1[j];
                if (n == m) {
                    arr2[i] = ',';
                    arr1[j] = ',';
                    break;
                }
            }
        }
        for (int x = 0; x < len2; x++) {
            if (arr2[x] == ',') {
                sum += 1;
            }
        }
            if (sum == len2) { //够得情况，统计arr1中多了几个
                int num = 0;
                for (int x = 0; x < len1; x++) {
                    if (arr1[x] != ',') {
                        num += 1;
                    }
                }
                System.out.print("Yes " + num);
            }
            if (sum < len2) {  //不够的情况
                System.out.println("No " + (len2 - sum));
            }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr1 = scanner.nextLine().toCharArray();
        char[] arr2 = scanner.nextLine().toCharArray();
        number(arr1,arr2);
    }
}

