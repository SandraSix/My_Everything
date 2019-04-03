import java.util.Scanner;

class Apple{
    int num;

    public Apple(int num) {
        this.num = num;
    }

    public void buyApple(int num){
        int daishu;
        if(num%8==0){
            daishu=num/8;
            System.out.println(daishu);
        }else if ((num-6)%8==0){
            daishu=(num-6)/8+1;
            System.out.println(daishu);
        }else if ((num-12)%8==0){
            daishu=(num-12)/8+2;
            System.out.println(daishu);
        }else if ((num-18)%8==0){
            daishu=(num-18)/8+3;
            System.out.println(daishu);
        }else if ((num-8)%6==0){
            daishu=(num-8)/6+1;
            System.out.println(daishu);
        }else if (num%6==0){
            daishu=num/6;
            System.out.println(daishu);
        }else {
            System.out.println(-1);
        }
    }
}

public class Day3_9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        Apple apple=new Apple(num);
        apple.buyApple(num);
    }
}
