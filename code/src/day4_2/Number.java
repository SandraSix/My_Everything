package day4_2;

import java.util.Scanner;

public class Number {
    public static void number(int n) {
        int a = n / 10000;
        int b = (n % 10000) / 1000;
        int c = (n % 1000) / 100;
        int d = (n % 100) / 10;
        int e = (n % 10);
        int sum = a + b + c + d + e;
        int num = a * a + b * b + c * c + d * d + e * e;
        System.out.println(sum + " " + num);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        number(n);
    }
}
