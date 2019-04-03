public class StrCom {

    public static int getCommonStrLength1(String p1, String p2){
        p1=p1.toLowerCase();
        p2=p2.toLowerCase();
        char[]p11=p1.toCharArray();
        char[] p22=p2.toCharArray();
        int a=p11.length;
        int b=p22.length;
        int count=0;
        if (a>b){
            for (int j=0;j<b;j++){
                String s2= String.valueOf(p22[j]);
                for (int i=0;i<a;i++){
                   String s1= String.valueOf(p11[i]);
                   if (s1==s2){
                       count+=1;
                       s2+=p22[i+1];
                   }

               }

           }
        }else {

        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        String a="abcdefg";
        String b="ABCll";
        getCommonStrLength1(a,b);

    }
}
