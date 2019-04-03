import java.util.Scanner;

public class Array_2 {

    public static int[] square(String[] data)throws Exception {
        int[] reselt=null;
        int i=0;
        if(data.length==0){
            return null;
        }else {
            while(i<data.length){
                reselt[i]=Integer.valueOf(data[i])*Integer.valueOf(data[i]);
                i++;
            }
            return reselt;
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] data=scanner.nextLine().split(",");
        int[] arry= new int[0];
        try {
            arry = square(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(arry==null){
            System.out.println("请输入");
        }else {
            int i=0;
            while(i<arry.length){
                System.out.println(arry[i]);
                i++;
            }
        }
    }
}
