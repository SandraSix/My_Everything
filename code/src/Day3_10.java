import java.util.Scanner;

import static java.lang.Math.pow;

class Sugers{
    int[] arr=null;

    public Sugers(int[] arr) {
        this.arr = arr;
    }

    public void sugerNum(int[] arr){
        if (arr==null){
            System.out.println("No");
        }else{
            double A=Integer.valueOf((arr[0]+arr[2])/2);
            double B=Integer.valueOf((arr[1]+arr[3])/2);
            double C=Integer.valueOf(String.valueOf(B-arr[1]));
            if (A%1==0){
                if (B%1==0){
                    if(C%1==0){
                        System.out.println(A+" "+B+" "+C);
                    }else {
                        System.out.println("No");
                    }
                }else {
                    System.out.println("No");
                }
            }else {
                System.out.println("No");
            }

        }
    }
}

public class Day3_10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] num = new int[4];
        String str=scanner.nextLine();
        if (str!=null&&str!=" "){
            str=str.replaceAll("/r/n"," ");
            num[0]=Integer.parseInt(str.split(" ")[0]);
            num[1]=Integer.parseInt(str.split(" ")[1]);
            num[2]=Integer.parseInt(str.split(" ")[2]);
            num[3]=Integer.parseInt(str.split(" ")[3]);
//            for (int i=0;i<num.length;i++){
//                num[i]=num[i]-1;
//                System.out.println(num[i]);
//            }
            if (num==null){
                System.out.println("No");
            }else{
                double A=Integer.valueOf((num[0]+num[2])/2);
                double B=Integer.valueOf((num[1]+num[3])/2);
                double C=(B-Integer.valueOf(num[1]));
                if (A%1==0){
                    if (B%1==0){
                        if(C%1==0){
                            System.out.println("A="+A+",B="+B+",C="+C);
                        }else {
                            System.out.println("No");
                        }
                    }else {
                        System.out.println("No");
                    }
                }else {
                    System.out.println("No");
                }

            }
        }

//        Sugers sugers=new Sugers(num);
//        sugers.sugerNum(num);
    }

}
