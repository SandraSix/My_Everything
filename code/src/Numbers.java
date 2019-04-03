import java.util.Scanner;

public class Numbers {
    public static int[] num(char[] arr){
        int[] cishu=new int[10];
        for (int i=0;i<arr.length;i++){
            switch (arr[i]){
                case '0':
                  cishu[0]++;
                  break;
                case '1':
                    cishu[1]++;
                    break;
                case '2':
                    cishu[2]++;
                    break;
                    case '3':
                    cishu[3]++;
                    break;
                case '4':
                    cishu[4]++;
                    break;
                case '5':
                    cishu[5]++;
                    break;
                case '6':
                    cishu[6]++;
                    break;
                case '7':
                    cishu[7]++;
                    break;
                case '8':
                    cishu[8]++;
                    break;
                case '9':
                    cishu[9]++;
                    break;
                    default:
                        System.out.println("输入错误");
                        break;

            }
        }
        return cishu;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] arr=str.toCharArray();
        int[] cishu=num(arr);
        for (int i=0;i<10;i++){
            if (cishu[i]==0){
                continue;
            }
            System.out.println(i+":"+cishu[i]);
        }
    }
}
