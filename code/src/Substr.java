//import java.util.*;
//
//public class Substr {
//    public boolean[] chkSubStr(String[] p, int n, String s) {
//        // write code here
//        boolean[] result=null;
//        int i=0;
//        for (i=0;i<n;i++){
//            String str=p[i];
//            int size1=str.length();
//            int size2=s.length();
//            int j=0;
//            int x=0;
//            while(x<size2){
//                while(j<size1){
//                    char[] str1=str.toCharArray();
//                    char[] str2=s.toCharArray();
//                    x=0;
//                    if (str1[j]==str2[x]){
//                        x++;
//                        j++;
//                    }else {
//                        j++;
//                    }
//                }
//                result[i]=true;
//            }
//            result[i]=false;
//        }
//        result[i]=false;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String[] p=new String[500];
//        if (!scanner.hasNextInt()){
//            for (int i=0;i<500;i++){
////                p[i]=scanner
//            }
//        }
//
//
//    }
//}