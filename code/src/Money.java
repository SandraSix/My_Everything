public class Money {
    public static void main(String[] args) {
        long sum=1;
        long q=1;
        long f=10;
        for (int i=0;i<29;i++){
            q=q*2;
            sum+=q;
        }

        System.out.println((sum-1000000*30)+"分");
        System.out.println((f*30-sum/10000)+"万元");
    }
}
