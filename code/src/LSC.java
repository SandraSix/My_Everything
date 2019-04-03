//
//    public class LSC {
//        public int getLCA(int a, int b) {
//            // write code here
//            if(a==b){
//                return a;
//            }
//            while(a!=b){
//                int r1=a/2;
//                int r2=b/2;
//                if(r1==r2){
//                    return r1;
//                }
//                a=r1;
//                b=r2;
//            }
//            return -1;
//        }
//
//    public static void main(){
//        Scanner s=new Scanner(System.in);
//        String str=s.nextLine();
//        int a=Integer.valueOf(str.split(",")[0]);
//        int b=Integer.valueOf(str.split(",")[1]);
//        while(a!=b){
//            int r1=a/2;
//            int r2=b/2;
//            if(r1==r2){
//                System.out.println(r1);
//            }
//            a=r1;
//            b=r2;
//        }
//    }
//}
