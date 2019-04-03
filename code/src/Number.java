import java.util.Scanner;

public class Number {
    public static int getTotalCount(int monthCount){
        if (monthCount==1){
            return 1;
        }else if (monthCount==2){
            return 1;
        }else {
            return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(getTotalCount(scanner.nextInt()));
    }
}
