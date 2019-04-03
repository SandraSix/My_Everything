import java.util.*;

public class fssort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Hashtable<String,Integer> hashMap=new Hashtable<>();
            hashMap.put(scanner.next(),scanner.nextInt());
//        for (int i=0;i<hashMap.size()-1;i++){
////            System.out.println(hashMap.get(i));
////            hashMap.get(i + 1);
////        }
        System.out.println(hashMap.get(0));

    }
}
