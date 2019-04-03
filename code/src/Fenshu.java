import java.util.Scanner;

public class Fenshu {
    private static int num(int n,int[] arr,int fenshu){
        int nums=0;
        for (int i=0;i<n;i++){
            if (arr[i]==fenshu){
                nums++;
            }
        }
        System.out.println(nums);
        return nums;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i=0;
        int n=0;
        int tmp=0;

       while(i<3){
            n=scanner.nextInt();    //存人数
            i++;
            int[] arr=new int[n];
            for (int j=0;j<n;j++){      //存储分数
                arr[j]=scanner.nextInt();
                if (j==n){
                    break;
                }
            }
            i++;
            tmp=scanner.nextInt();
            i++;
            num(n,arr,tmp);
        }
    }
}
