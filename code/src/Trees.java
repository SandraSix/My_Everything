//
//import java.util.*;
//
//public class Trees{
//
//        public  int getLCA(int a, int b) {
//            // write code here
//            while(a!=b){
//                int r1=a/2;
//                int r2=b/2;
//                if(r1==r2){
//                    return r1;
//                }else{
//                    getLCA(r1,r2);
//                }
//            } return -1;
//        }
//        public void main(){
//            Scanner s=new Scanner(System.in);
//            String str=s.nextLine();
//            int a=Integer.valueOf(str.split(",")[0]);
//            int b=Integer.valueOf(str.split(",")[1]);
//            this.getLCA(a,b);
//        }
//    }
//}

import java.util.*;

public class Trees{
//    public int getLCA(int a, int b) {
//        // write code here
//
//        while(a!=b){
//            int r1=a/2;
//            int r2=b/2;
//            if(r1==r2){
//                return r1;
//            }else{
//                getLCA(r1,r2);
//            }
//        } return -1;
//    }
    public static void main(){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        int a=Integer.valueOf(str.split(",")[0]);
        int b=Integer.valueOf(str.split(",")[1]);
        while(a!=b){
            int r1=a/2;
            int r2=b/2;
            if(r1==r2){
                System.out.println(r1);
            }
            a=r1;
            b=r2;
        }
        //getLCA(a,b);
    }
}